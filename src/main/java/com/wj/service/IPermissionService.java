package com.wj.service;

import java.util.List;

import com.wj.entity.Permission;

public interface IPermissionService {

	public List<Permission> findAll(Integer page,Integer size);

	public void save(Permission p);

	public List<Permission> findOtherPermission(String roleid);

}
