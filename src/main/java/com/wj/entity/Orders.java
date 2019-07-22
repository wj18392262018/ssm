package com.wj.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Orders {
	private String id;//无意义、主键uuid
	private String orderNum;//订单编号 不为空 唯一
	private Date orderTime;//下单时间
	private String orderTimeStr;//格式化日期用的(下单时间)
	private int orderStatus;//订单状态(0 未支付 1 已支付)
	private int peopleCount;//出行人数
	private Product product;//主外键关系（product表）外键
	private List<Traveller> travellers;//主外键关系（travellers表）外键
	private Member member;//主外键关系（member表）外键
	private Integer payType;//支付方式(0 支付宝 1 微信 2其它)
	private String payTypeStr;//格式化支付方式将payType中的 0,1,2 改成支付宝，微信，其他
	private String orderDesc;//订单描述(其它信息)
	private String orderStatusStr;//格式化订单描述
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderTimeStr() {
		//格式化日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return sdf.format(this.orderTime);
	}
	public void setOrderTimeStr(String orderTimeStr) {
		this.orderTimeStr = orderTimeStr;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Traveller> getTravellers() {
		return travellers;
	}
	public void setTravellers(List<Traveller> travellers) {
		this.travellers = travellers;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	//支付方式(0 支付宝 1 微信 2其它)
	public String getPayTypeStr() {
		if(this.payType==0) {
			return "微信";
		}else if(this.payType==1) {
			return "支付宝";
		}else {
			return "其他";
		}
	}
	public void setPayTypeStr(String payTypeStr) {
		this.payTypeStr = payTypeStr;
	}
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	public String getOrderStatusStr() {
		if(this.orderStatus==0)
			return "未支付";
		return "已支付";
	}
	public void setOrderStatusStr(String orderStatusStr) {
		this.orderStatusStr = orderStatusStr;
	}
	 
}
