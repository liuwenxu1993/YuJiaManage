package com.yj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Table(name="sys_ap")
public class SysAp implements Serializable{

		private static final long serialVersionUID = 3541683845606852673L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
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
		private String allow="上架";
		private Date createdTime;
		private Date modifiedTime;
		private String createdUser;
		private String modifiedUser;
}
