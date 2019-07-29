package com.yj.sys.common.vo;

import java.io.Serializable;
import java.util.Date;

import com.yj.sys.entity.SysDept;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysStaffVo implements Serializable{
	private static final long serialVersionUID = -3615188326023743467L;
	private Integer id;
	private String name;
	private String password;
	private String salt;//盐值
	private String email;
	private String mobile;
	private Integer valid=1;
	private SysDept sysDept;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
}
