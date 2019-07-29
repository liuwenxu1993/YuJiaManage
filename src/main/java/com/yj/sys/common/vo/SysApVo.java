package com.yj.sys.common.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

/** 这个vo用来封装公寓信息和公寓照片信息 */
@Data
@ToString
public class SysApVo implements Serializable{

	private static final long serialVersionUID = 1996709356682165368L;
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
	private String picture;
	private String allow;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	private Object records;
}
