package com.imooc.o2o.entity;

import java.util.Date;

public class Area {
	private Integer areaId;//ID
	private String  areaName;//地区名
	private Integer priority;//权重，意思就是优先显示
	private Date    createTime;//创建时间
	private Date 	lastEditTime;//更新时间
	/**
	 * 不使用基本数据类型而使用引用类型的原因是：
	 * 		基本数据类型会默认赋值0,或者其他。引用类型则为null，不希望赋初始值，
	 * 		有就是有，没有就是没有，不能默认为0，防止出现莫名bug。
	 */
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	
	
}
