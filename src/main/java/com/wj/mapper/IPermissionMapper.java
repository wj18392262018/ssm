package com.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.wj.entity.Permission;

public interface IPermissionMapper {
	//�����ѯ
	@Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})") 
	public List<Permission> findByRoleId(String roleId);
	//��ѯ����
	@Select("select * from permission")
	public List<Permission> findAll();
	//���
	@Insert("insert into permission values(#{id},#{permissionName},#{url})")
	public void save(Permission p);
	//ͨ����ɫ��ѯ�ý�ɫʣ���Ȩ��
	@Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
	public List<Permission> findOtherPermission(String roleId);
	
}
