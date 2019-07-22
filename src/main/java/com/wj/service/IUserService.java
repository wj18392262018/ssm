package com.wj.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.wj.entity.User;


public interface IUserService extends UserDetailsService{
	//分页显示
	public List<User> findAll(Integer page,Integer size);
	//添加
	public void save(User user) throws Exception;
	//显示详情
	public User findById(String id);
	//用户添加角色
	public void addRoleToUser(String userId, String[] ids);
}
