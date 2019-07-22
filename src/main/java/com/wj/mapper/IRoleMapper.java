package com.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wj.entity.Role;

public interface IRoleMapper {
	//Ȩ��
	@Select("select * from role where id in( select roleId from users_role where userId=#{userId})") 
	@Results({ 
			@Result(id=true,column="id",property="id"), 
			@Result(column="roleName",property="roleName"), 
			@Result(column="roleDesc",property="roleDesc"), 
			@Result(column="id",property="permissions",javaType=List.class,many=@Many(select="com.wj.mapper.IPermissionMapper.findByRoleId")) 
			})
	public List<Role> findRoleByUserId(String userId);
	//��ѯ����
	@Select("select * from role")
	public List<Role> findAll();
	//���
	@Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
	public void save(Role role);
	//��ʾ��ӽ�ɫ
	@Select("select * from role where id not in( select roleId from users_role where userId=#{userId})") 
	public List<Role> findOtherRole(String userid);
	//ͨ��ID������
	@Select("select * from role where id=#{roleid}")
	public Role findById(String roleid);
	////����ɫ���Ȩ�ޣ��м��
	@Insert("insert into role_permission value (#{permissionId},#{roleId})")
	public void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
	//��ʾ��ɫ������
	@Select("select * from role where id =#{roleId}") 
	@Results({ 
			@Result(id=true,column="id",property="id"), 
			@Result(column="roleName",property="roleName"), 
			@Result(column="roleDesc",property="roleDesc"), 
			@Result(column="id",property="permissions",javaType=List.class,many=@Many(select="com.wj.mapper.IPermissionMapper.findByRoleId")) 
			})
	public Role findRoleById(String roleId);
	
}
