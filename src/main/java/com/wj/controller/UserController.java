package com.wj.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.wj.entity.Role;
import com.wj.entity.User;
import com.wj.service.IRoleService;
import com.wj.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	 //分页显示
    @RequestMapping("/findAll.do")
    //配置权限
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView findAll(Integer page,Integer size) throws Exception {
		List<User> users = userService.findAll(page,size);
		ModelAndView mv = new ModelAndView();
		//使用封装
		PageInfo pages=new PageInfo(users);
		mv.addObject("pageInfo", pages);
		mv.setViewName("user-list");
		return mv;
	 }
    //添加
  	 @RequestMapping("/save.do")
  	 public String save(User user) throws Exception {
  		 user.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
  		 userService.save(user);
  		 return "redirect:findAll.do?page=1&&size=3";
  	 }
  	 //用户详情
  	@RequestMapping("/findById.do")
	public ModelAndView findById(String id) throws Exception {
		User users = userService.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", users);
		mv.setViewName("user-show");
		return mv;
	 }
  	//显示添加角色
  	@RequestMapping("/findUserByIdAndAllRole.do") 
  	public ModelAndView findUserByIdAndAllRole(String userid) throws Exception { 
	  	User user = userService.findById(userid); 
	  	List<Role> roleList = roleService.findOtherRole(userid); 
	  	ModelAndView mv = new ModelAndView(); 
	  	mv.addObject("user", user);
	  	mv.addObject("roleList", roleList);
	  	mv.setViewName("user-role-add");
	  	return mv;
  	}
  	//添加角色
  	@RequestMapping("/addRoleToUser.do") 
  	public String addRoleToUser(String userId,String[] ids) throws Exception { 
  		userService.addRoleToUser(userId,ids); 
  		return "redirect:findAll.do?page=1&&size=3"; 
  	}
}
