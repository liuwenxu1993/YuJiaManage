package com.yj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysApOrder implements Serializable{

	private static final long serialVersionUID = -2622144764244643325L;
	private String renterName;
	private String renterPhone;
	private Date createdTime;
	private String status;
	private Date handlerTime;
	private String staffName;
	
	
}
