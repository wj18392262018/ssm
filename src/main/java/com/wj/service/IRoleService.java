package com.wj.service;

import java.util.List;

import com.wj.entity.Role;

public interface IRoleService {

	public List<Role> findAll(Integer page,Integer size);

	public void save(Role role);

	public List<Role> findOtherRole(String userid);

	public Role findById(String roleid);

	public void addPermissionToRole(String roleId, String[] ids);

	public Role findRoleByUserId(String id);

}
