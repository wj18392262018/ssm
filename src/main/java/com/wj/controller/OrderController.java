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
	//显示所用订单
	@RequestMapping("/findAll.do")
	public String findAll(Integer page,Integer size,ModelMap model) {
		// TODO Auto-generated method stub
		//使用PageHelper工具类进行分页
		List<Orders> list=ordersService.findAll(page,size);
		//使用pageInfo工具类进行封装，可以得该表总页数，总记录数等等。
		PageInfo pageInfo=new PageInfo(list);
		//将数据传回去
		model.put("pageInfo", pageInfo);
		return "orders-list";
	}
	//显示订单,会员，旅客所有信息,
	@RequestMapping("/findById.do")
	public String findById(String id,ModelMap model){
		Orders order=ordersService.findById(id);
		model.put("orders", order);
		return "orders-show";
	}
	//删除
	@RequestMapping("/delete.do")
	public String delete(String []ids){
		if(ordersService.deleteByIds(ids)>0)
			return "redirect:findAll.do?page=1&&size=3";
		return "error";
	}
}
