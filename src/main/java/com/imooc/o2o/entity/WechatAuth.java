package com.imooc.o2o.entity;

import java.util.Date;

public class WechatAuth {
	private Long wechatAuthId; //ID
	private String openId;	//和微信公众号绑定的唯一标识
	private Date createTime;//创建时间
	private PersonInfo personInfo;//微信账号和个人信息进行绑定
	
	public Long getWechatAuthId() {
		return wechatAuthId;
	}
	public void setWechatAuthId(Long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	
	
}
