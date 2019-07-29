package com.yj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;
/*
 * houseOrder 数据类
 */

@Data
@ToString
public class SysHouseOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6602632307581161214L;
	private Integer id;
	private Date createdTime;
	private String apName;
	private String apAddr;
	private String apType;
	private Integer apPlace;
	private Integer apPrice;
	private String ownerName;
	private String ownerPhone;
	private String renterName;
	private String renterPhone;
}
