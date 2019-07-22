package com.wj.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.wj.entity.Permission;
import com.wj.service.IPermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	@Autowired 
	private IPermissionService permissionService; 
	//分页查询所有
	@RequestMapping("/findAll.do") 
	public ModelAndView findAll(Integer page,Integer size) throws Exception { 
		List<Permission> permissionList = permissionService.findAll(page,size); 
		ModelAndView mv = new ModelAndView(); 
		
		PageInfo pageInfo=new PageInfo(permissionList);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("permission-list");
		return mv;
	}
	//添加
	@RequestMapping("/save.do") 
	public String save(Permission p) throws Exception { 
		p.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		permissionService.save(p); 
		return "redirect:findAll.do?page=1&&size=3"; 
	}
}
