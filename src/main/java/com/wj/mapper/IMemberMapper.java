package com.wj.mapper;

import org.apache.ibatis.annotations.Select;

import com.wj.entity.Member;

public interface IMemberMapper {
	//�����ѯ(orders)
	//ͨ��������ѯ�û��ͻ�Ա
	@Select("select * from member where id=#{id}")
	public Member findById(String id);
}
