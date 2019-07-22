package com.wj.service;

import java.util.List;

import com.wj.entity.Orders;

public interface IOrdersService {
	public List<Orders> findAll(Integer page,Integer size);
	public Orders findById(String id);
	public int deleteByIds(String[] ids);
}
