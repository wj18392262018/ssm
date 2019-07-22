package com.wj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wj.entity.Orders;
import com.wj.mapper.IOrdersMapper;
@Service("ordersService")
public class OrdersServiceImpl implements IOrdersService {
	//显示所用订单
	@Autowired
	private IOrdersMapper ordersMapper;
	//使用分页
	public List<Orders> findAll(Integer page,Integer size) {
		// TODO Auto-generated method stub
		//使用PageHelper工具类进行分页，必须紧跟着的第一个select方法会被分页
		PageHelper.startPage(page, size);
		//中间不能加其他的select
		return ordersMapper.findAll();
	}
	//通过订单查询用户和会员
	public Orders findById(String id) {
		// TODO Auto-generated method stub
		return ordersMapper.findAllGetById(id);
	}
	//删除
	public int deleteByIds(String[] ids) {
		// TODO Auto-generated method stub
		return ordersMapper.deleteByIds(ids);
	}

}
