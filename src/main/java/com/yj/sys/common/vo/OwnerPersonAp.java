package com.yj.sys.common.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class OwnerPersonAp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6177173375042115225L;
	private Integer id;
	private String name;
	private String district;
	private String addr;
	private String type;
	private Integer place;
	private Integer price;
	private String phone;
	private String status;
	private String description;
	//private String picture;
	private String createdTime;
	private String modifiedTime;
	private String createdUser;
	private String modifiedUser;
}
