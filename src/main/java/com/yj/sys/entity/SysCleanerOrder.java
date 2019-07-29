package com.yj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class SysCleanerOrder implements Serializable {
	
	/**
	 * 服务清单对象
	 */
	private static final long serialVersionUID = -4915949899481222371L;
	private Integer id;
	private Date createdTime;
	private Date serviceTime;
	private String renterName;
	private String renterPhone;
	private String renterAddr;
	private String cleanerName;
	private String money;
	private String status;

}
