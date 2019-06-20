package com.yj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysAp implements Serializable{

		private static final long serialVersionUID = 3541683845606852673L;
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
		private Date createdTime;
		private Date modifiedTime;
		private String createdUser;
		private String modifiedUser;
}
