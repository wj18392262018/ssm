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
	//��ҳ��ʾ����
	public List<Role> findAll(Integer page,Integer size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return roleMapper.findAll();
	}
	//���
	public void save(Role role) {
		// TODO Auto-generated method stub
		roleMapper.save(role);
	}
	//��ʾ��ӽ�ɫ
	public List<Role> findOtherRole(String userid) {
		// TODO Auto-generated method stub
		return roleMapper.findOtherRole(userid);
	}
	//ͨ��ID������
	public Role findById(String roleid) {
		// TODO Auto-generated method stub
		return roleMapper.findById(roleid);
	}
	//����ɫ���Ȩ�ޣ��м��
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
