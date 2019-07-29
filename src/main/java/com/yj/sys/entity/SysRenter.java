package com.yj.sys.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysRenter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5215605572247949583L;
	/**租客id*/
	private Integer id;
	/**租客姓名*/
	private String name;
	/**租客性别*/
	private String gender;
	/**租客联系电话*/
	private String phone;
	/**租客身份证号*/
	private String idNumber;
	/**租客租住状态*/
	private String status;
    /**租客注册时间*/
	private String registerTime;
}
