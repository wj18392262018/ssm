package com.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.wj.entity.Permission;

public interface IPermissionMapper {
	//链表查询
	@Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})") 
	public List<Permission> findByRoleId(String roleId);
	//查询所有
	@Select("select * from permission")
	public List<Permission> findAll();
	//添加
	@Insert("insert into permission values(#{id},#{permissionName},#{url})")
	public void save(Permission p);
	//通过角色查询该角色剩余的权限
	@Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
	public List<Permission> findOtherPermission(String roleId);
	
}
