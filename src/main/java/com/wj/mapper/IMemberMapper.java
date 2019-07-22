package com.wj.mapper;

import org.apache.ibatis.annotations.Select;

import com.wj.entity.Member;

public interface IMemberMapper {
	//链表查询(orders)
	//通过订单查询用户和会员
	@Select("select * from member where id=#{id}")
	public Member findById(String id);
}
