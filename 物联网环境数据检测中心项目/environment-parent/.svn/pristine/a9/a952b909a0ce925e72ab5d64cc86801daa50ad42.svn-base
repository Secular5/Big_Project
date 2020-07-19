package com.briup.bean;

import java.io.Serializable;
import java.sql.Date;

public class Environment implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 发送端的id
	 */
	private String srcId;
	
	/**
	 * 树莓派id
	 */
	private String devId;
	
	/**
	 * 实验箱的区域id
	 */
	private Long regionId;
	
	/**
	 * 数据名称
	 */
	private String name;
	
	/**
	 * 传感器个数
	 */
	private Long count;
	
	/**
	 * 数据状态  3代表发送数据  6代表接收数据
	 */
	private Integer state;
	
	/** 
	 * 具体数据
	 */
	private Double data;
	
	
	/**
	 * 数据接收状态   1代表接收成功
	 */
	private Integer reviceState;
	
	/**
	 * 采集数据的时间
	 */
	private Date gatheDate;

	public Environment() {
	}

	public Environment(String srcId, String devId, Long regionId, String name, Long count, Integer state, Double data,
			Integer reviceState, Date gatheDate) {
		this.srcId = srcId;
		this.devId = devId;
		this.regionId = regionId;
		this.name = name;
		this.count = count;
		this.state = state;
		this.data = data;
		this.reviceState = reviceState;
		this.gatheDate = gatheDate;
	}

	public String getSrcId() {
		return srcId;
	}

	public void setSrcId(String srcId) {
		this.srcId = srcId;
	}

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Double getData() {
		return data;
	}

	public void setData(Double data) {
		this.data = data;
	}

	public Integer getReviceState() {
		return reviceState;
	}

	public void setReviceState(Integer reviceState) {
		this.reviceState = reviceState;
	}

	public Date getGatheDate() {
		return gatheDate;
	}

	public void setGatheDate(Date gatheDate) {
		this.gatheDate = gatheDate;
	}

	@Override
	public String toString() {
		return "Enviroment [srcId=" + srcId + ", devId=" + devId + ", regionId=" + regionId + ", name=" + name
				+ ", count=" + count + ", state=" + state + ", data=" + data + ", reviceState=" + reviceState
				+ ", gatheDate=" + gatheDate + "]";
	}
	
	

	
}
