package com.wj.service;

import java.util.List;

import com.wj.entity.Product;

public interface IProductService {
	//查询所有
	public List<Product> findAll(Integer page,Integer size);
	//添加
	public int save(Product product);
	//删除
	public int deleteByIds(String[] ids);
}
