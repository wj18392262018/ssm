package com.wj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wj.entity.Permission;
import com.wj.mapper.IPermissionMapper;
@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {
	@Autowired
	private IPermissionMapper permissionMapper;
	//分页查询所有
	public List<Permission> findAll(Integer page,Integer size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return permissionMapper.findAll();
	}
	//添加
	public void save(Permission p) {
		// TODO Auto-generated method stub
		permissionMapper.save(p);
	}
	//通过链表查询权限
	public List<Permission> findOtherPermission(String roleid) {
		// TODO Auto-generated method stub
		return permissionMapper.findOtherPermission(roleid);
	}

}
