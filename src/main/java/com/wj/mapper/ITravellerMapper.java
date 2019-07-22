package com.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wj.entity.Traveller;

public interface ITravellerMapper {
	//链表查询(orders)
	//通过订单查询用户和会员
	@Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{orderId})")
	public List<Traveller> findByOrdersId(String orderId);
}
