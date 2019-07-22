package com.wj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wj.entity.Role;
import com.wj.mapper.IUserMapper;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserMapper userMapper;
	//配置加密
	@Autowired
	private PasswordEncoder passwordEncoder;
	//使用spring security用户登陆验证
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.wj.entity.User db_user=userMapper.findByUsername(username);
		User user=new User(db_user.getUsername(),db_user.getPassword(),db_user.getStatus()==1?true:false,true,true,true,this.getAuthority(db_user.getRoles()));
		return user;
	}
	public List<GrantedAuthority> getAuthority(List<Role> roles){
		List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			list.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return list;
	}
	//分页显示
	public List<com.wj.entity.User> findAll(Integer page,Integer size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return userMapper.findAll();
	}
	//添加
	public void save(com.wj.entity.User user) throws Exception {
		// TODO Auto-generated method stub
		//配置加密
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userMapper.save(user);
	}
	//显示详情
	public com.wj.entity.User findById(String id) {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}
	//用户添加角色
	public void addRoleToUser(String userId, String[] ids) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ids.length; i++) {
			userMapper.addRoleToUser(userId, ids[i]);
		}
	}
}
