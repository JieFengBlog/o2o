package com.imooc.o2o.entity;

import java.util.Date;

/**
 * 头条信息
 * @author yoghourt
 *
 */
public class HeadLine {
	private Long lineId;//头条
	private String lineName;//头条标题
	private String lineLink;//头条对应的链接
	private String lineImg;//头条对应的图片地址
	private Integer priority;//头条的显示的优先级
	//0 不可用 1可用
	private Integer enableStatus;//头条是否显示
	private Date createTime;//创建时间
	private Date lastEditTime;//最后一次更新时间
	
	
	public Long getLineId() {
		return lineId;
	}
	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
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
	public String getLineLink() {
		return lineLink;
	}
	public void setLineLink(String lineLink) {
		this.lineLink = lineLink;
	}
	public String getLineImg() {
		return lineImg;
	}
	public void setLineImg(String lineImg) {
		this.lineImg = lineImg;
	}
	
	
}
