package com.yj.sys.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class RenterApOrderVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7336997049365824520L;
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
	/**租客预约状态*/
	private String status;
    /**租客下订单时间*/
	private String createdTime;
	/**公寓地址*/
	private String addr;
}
