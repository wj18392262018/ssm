package com.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.wj.entity.Product;

public interface IProductMapper {
	//查询所有
	@Select("select * from product")
	public List<Product> findAll();
	//添加
	@Insert("insert into product values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
	public int save(Product product);
	//链表查询
	@Select("select * from product where id=#{id}")
	public Product getProductById(String id);
	//删除
	@Delete("<script>" +
            "delete from product" +
            "<where>" +
                "id in"+
                "<foreach item='pid' collection='array' separator=',' open='(' close=')' index=''>"
                	+"#{pid, jdbcType=VARCHAR}"
               +"</foreach>"
           + "</where>" 
           + "</script>")
	public int deleteByIds(String[] ids);
}
