package com.wj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wj.entity.Orders;
import com.wj.mapper.IOrdersMapper;
@Service("ordersService")
public class OrdersServiceImpl implements IOrdersService {
	//��ʾ���ö���
	@Autowired
	private IOrdersMapper ordersMapper;
	//ʹ�÷�ҳ
	public List<Orders> findAll(Integer page,Integer size) {
		// TODO Auto-generated method stub
		//ʹ��PageHelper��������з�ҳ����������ŵĵ�һ��select�����ᱻ��ҳ
		PageHelper.startPage(page, size);
		//�м䲻�ܼ�������select
		return ordersMapper.findAll();
	}
	//ͨ��������ѯ�û��ͻ�Ա
	public Orders findById(String id) {
		// TODO Auto-generated method stub
		return ordersMapper.findAllGetById(id);
	}
	//ɾ��
	public int deleteByIds(String[] ids) {
		// TODO Auto-generated method stub
		return ordersMapper.deleteByIds(ids);
	}

}
