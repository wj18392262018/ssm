package com.wj.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.wj.entity.User;


public interface IUserService extends UserDetailsService{
	//��ҳ��ʾ
	public List<User> findAll(Integer page,Integer size);
	//���
	public void save(User user) throws Exception;
	//��ʾ����
	public User findById(String id);
	//�û���ӽ�ɫ
	public void addRoleToUser(String userId, String[] ids);
}
