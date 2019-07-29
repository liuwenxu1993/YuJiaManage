package com.yj.sys.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysOwner implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4801038158653256165L;
	/**业主id*/
	private Integer id;
	/**业主姓名*/
	private String name;
	/**业主性别*/
	private String gender;
	/**业主联系电话*/
	private String phone;
	/**业主身份证号*/
	private String idNumber;
	/**业主注册时间*/
	private String registerTime;
	/**公寓总数*/
	private Integer apNumber;
}
