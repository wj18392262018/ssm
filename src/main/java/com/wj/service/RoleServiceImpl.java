package com.wj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wj.entity.Role;
import com.wj.mapper.IRoleMapper;
@Service("roleService")
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleMapper roleMapper;
	//分页显示所有
	public List<Role> findAll(Integer page,Integer size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return roleMapper.findAll();
	}
	//添加
	public void save(Role role) {
		// TODO Auto-generated method stub
		roleMapper.save(role);
	}
	//显示添加角色
	public List<Role> findOtherRole(String userid) {
		// TODO Auto-generated method stub
		return roleMapper.findOtherRole(userid);
	}
	//通过ID查数据
	public Role findById(String roleid) {
		// TODO Auto-generated method stub
		return roleMapper.findById(roleid);
	}
	//给角色添加权限（中间表）
	public void addPermissionToRole(String roleId, String[] ids) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ids.length; i++) {
			roleMapper.addPermissionToRole(roleId,ids[i]);
		}
	}
	public Role findRoleByUserId(String roleId) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleById(roleId);
	}

}
