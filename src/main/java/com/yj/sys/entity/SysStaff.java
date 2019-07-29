package com.yj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Table(name="sys_staff")
public class SysStaff  implements Serializable{
	
	private static final long serialVersionUID = 7889595942603328963L;
	@Id
	private Integer id;
	private String name;
	private String password;
	private String salt;//盐值
	private String email;
	private String mobile;
	private Integer valid=1;
	@Column(name="deptId")
	private Integer deptId;
	@Column(name="createdTime")
	private Date createdTime;
	@Column(name="modifiedTime")
	private Date modifiedTime;
	@Column(name="createdUser")
	private String createdUser;
	@Column(name="modifiedUser")
	private String modifiedUser;
	
	
	
}	
