package com.wj.entity;

import java.util.List;

public class User {
	private String id;//编号
	private String username;//用户名
	private String email;//电子邮箱
	private String password;//密码
	private String phoneNum;//手机号
	private int status;//状态 0未开启 1开启
	private String statusStr;//显示状态
	private List<Role> roles;//主外键
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusStr() {
		if(this.status==0)
			return "未开启";
		return "开启";
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
