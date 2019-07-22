package com.wj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.wj.entity.Orders;
import com.wj.service.IOrdersService;

@Controller
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private IOrdersService ordersService;
	//��ʾ���ö���
	@RequestMapping("/findAll.do")
	public String findAll(Integer page,Integer size,ModelMap model) {
		// TODO Auto-generated method stub
		//ʹ��PageHelper��������з�ҳ
		List<Orders> list=ordersService.findAll(page,size);
		//ʹ��pageInfo��������з�װ�����Եøñ���ҳ�����ܼ�¼���ȵȡ�
		PageInfo pageInfo=new PageInfo(list);
		//�����ݴ���ȥ
		model.put("pageInfo", pageInfo);
		return "orders-list";
	}
	//��ʾ����,��Ա���ÿ�������Ϣ,
	@RequestMapping("/findById.do")
	public String findById(String id,ModelMap model){
		Orders order=ordersService.findById(id);
		model.put("orders", order);
		return "orders-show";
	}
	//ɾ��
	@RequestMapping("/delete.do")
	public String delete(String []ids){
		if(ordersService.deleteByIds(ids)>0)
			return "redirect:findAll.do?page=1&&size=3";
		return "error";
	}
}
