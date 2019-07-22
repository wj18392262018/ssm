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
	//��ҳ��ѯ����
	public List<Permission> findAll(Integer page,Integer size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return permissionMapper.findAll();
	}
	//���
	public void save(Permission p) {
		// TODO Auto-generated method stub
		permissionMapper.save(p);
	}
	//ͨ�������ѯȨ��
	public List<Permission> findOtherPermission(String roleid) {
		// TODO Auto-generated method stub
		return permissionMapper.findOtherPermission(roleid);
	}

}
