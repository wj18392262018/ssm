package com.wj.entity;

public class Traveller {
	private String id;//�����塢����uuid
	private String name;//����
	private String sex;//�Ա�
	private String phoneNum;//�绰����
	private Integer credentialsType;//֤������ 0���֤ 1���� 2����֤
	private String credentialsTypeStr;//��ʽ��֤������ 0���֤ 1���� 2����֤
	private String credentialsNum;//֤������
	private Integer travellerType;//�ÿ�����(��Ⱥ) 0 ���� 1 ��ͯ
	private String travellerTypeStr;//��ʽ���ÿ�����(��Ⱥ) 0 ���� 1 ��ͯ
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Integer getCredentialsType() {
		return credentialsType;
	}
	public void setCredentialsType(Integer credentialsType) {
		this.credentialsType = credentialsType;
	}
	//֤������ 0���֤ 1���� 2����֤
	public String getCredentialsTypeStr() {
		if(this.credentialsType==0) {
			return "���֤";
		}else if(this.credentialsType==1) {
			return "����";
		}else {
			return "����֤";
		}
	}
	public void setCredentialsTypeStr(String credentialsTypeStr) {
		this.credentialsTypeStr = credentialsTypeStr;
	}
	public String getCredentialsNum() {
		return credentialsNum;
	}
	public void setCredentialsNum(String credentialsNum) {
		this.credentialsNum = credentialsNum;
	}
	public Integer getTravellerType() {
		return travellerType;
	}
	public void setTravellerType(Integer travellerType) {
		this.travellerType = travellerType;
	}
	//�ÿ�����(��Ⱥ) 0 ���� 1 ��ͯ
	public String getTravellerTypeStr() {
		if(this.travellerType==0)
			return "����";
		return "��ͯ";
	}
	public void setTravellerTypeStr(String travellerTypeStr) {
		this.travellerTypeStr = travellerTypeStr;
	}
	
}
