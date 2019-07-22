package com.wj.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.wj.entity.Permission;
import com.wj.entity.Role;
import com.wj.entity.User;
import com.wj.service.IPermissionService;
import com.wj.service.IRoleService;
@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired 
	private IRoleService roleService; 
	@Autowired
	private IPermissionService permissionService;
	//查询所有
	@RequestMapping("/findAll.do") 
	public ModelAndView findAll(Integer page,Integer size) throws Exception { 
		List<Role> roleList = roleService.findAll(page,size); 
		ModelAndView mv = new ModelAndView(); 
		
		PageInfo pageInfo=new PageInfo(roleList);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("role-list");
		return mv;
	}
	//添加
	@RequestMapping("/save.do") 
	public String save(Role role) { 
		role.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		roleService.save(role); 
		return "redirect:findAll.do?page=1&&size=3"; 
	}
	//给角色添加权限的显示
	@RequestMapping("/findRoleByIdAndAllPermission.do") 
	public ModelAndView findRoleByIdAndAllPermission(String roleid) throws Exception{ 
		ModelAndView mv = new ModelAndView(); 
		Role role = roleService.findById(roleid); 
		mv.addObject("role", role);
		List<Permission> permissionList =permissionService.findOtherPermission(roleid); 
		mv.addObject("permissionList", permissionList);
		mv.setViewName("role-permission-add");
		return mv;
	}
	//给角色添加权限
	@RequestMapping("/addPermissionToRole.do") 
  	public String addPermissionToRole(String roleId,String[] ids) throws Exception { 
  		roleService.addPermissionToRole(roleId,ids); 
  		return "redirect:findAll.do?page=1&&size=3"; 
  	}
	//显示详情
	@RequestMapping("/findById.do")
	public ModelAndView findById(String id) throws Exception {
		Role roles = roleService.findRoleByUserId(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("role", roles);
		mv.setViewName("role-show");
		return mv;
	 }
}
