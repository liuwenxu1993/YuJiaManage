package com.yj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 * pojo(普通的java对象)：属性
 * 1)po (持久化对象persistent object)
 * 2)vo (子对象 Value Object)
 * 等等 
 * 借助此对象封装用户的行为日志信息
 */
@Data   /**简化了set和get方法*/
@ToString
public class SysLog implements Serializable{

	private static final long serialVersionUID = 8924387722922123121L;
	private Integer id;
	/**用户名*/
	private String username;
	/**用户操作*/
	private String operation;
	/**请求方法*/
	private String method;
	/**请求参数*/
	private String params;
	/**执行时长(毫秒)*/
	private Long time;
	/**IP地址*/
	private String ip;
	/**创建时间*/
	private Date createdTime;
	
	
}
