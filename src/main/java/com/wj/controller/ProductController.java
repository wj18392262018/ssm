package com.wj.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.wj.entity.Product;
import com.wj.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	@RequestMapping("/findAll.do")
	public String findAll(Integer page,Integer size, ModelMap model){
		List<Product> list=productService.findAll(page,size);
		//使用pageInfo工具类进行封装，可以得该表总页数，总记录数等等。
		PageInfo pageInfo=new PageInfo(list);
		model.put("pageInfo", pageInfo);
		return "product-list";
	}
	@RequestMapping("/save.do")
	public String save(Product product){
		//生成UUID,并去掉其中的"-"
		product.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		if(productService.save(product)>0)
			return "redirect:findAll.do?page=1&&size=3";
		return "error";
	}
	//删除
	@RequestMapping("/delete.do")
	public String save(String[] ids) {
		if(productService.deleteByIds(ids)>0)
			return "redirect:findAll.do?page=1&&size=3";
		return "error";
	}
	
}
