package com.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wj.entity.Orders;

public interface IOrdersMapper {
	//链表查询（Product表）
	//对应关系
	@Results({
		@Result(id=true,column = "id",property = "id"),
		@Result(column = "orderNum",property = "orderNum"),
		@Result(column = "orderTime",property = "orderTime"),
		@Result(column = "orderStatus",property = "orderStatus"),
		@Result(column = "peopleCount",property = "peopleCount"),
		@Result(column = "payType",property = "payType"),
		@Result(column = "orderDesc",property = "orderDesc"),
		@Result(column = "productId",property = "product",one = @One(select =
		"com.wj.mapper.IProductMapper.getProductById"))
	})
	//通过订单查询用户和会员
	@Select("select * from orders")
	public List<Orders> findAll();
	@Results({
		@Result(id=true,column = "id",property = "id"),
		@Result(column = "orderNum",property = "orderNum"),
		@Result(column = "orderTime",property = "orderTime"),
		@Result(column = "orderStatus",property = "orderStatus"),
		@Result(column = "peopleCount",property = "peopleCount"),
		@Result(column = "payType",property = "payType"),
		@Result(column = "orderDesc",property = "orderDesc"),
		@Result(column = "productId",property = "product",one = @One(select =
		"com.wj.mapper.IProductMapper.getProductById")),
		@Result(column = "id",property = "travellers",many = @Many(select =
		"com.wj.mapper.ITravellerMapper.findByOrdersId")),
		@Result(column = "memberId",property = "member",one = @One(select =
		"com.wj.mapper.IMemberMapper.findById")),
	})
	@Select("select * from orders where id=#{id}")
	public Orders findAllGetById(String id);
	//删除
	@Delete("<script>" +
            "delete from orders" +
            "<where>" +
                "id in"+
                "<foreach item='pid' collection='array' separator=',' open='(' close=')' index=''>"
                	+"#{pid, jdbcType=VARCHAR}"
               +"</foreach>"
           + "</where>" 
           + "</script>")
	public int deleteByIds(String[] ids);
}
