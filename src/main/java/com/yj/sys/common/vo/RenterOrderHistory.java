package com.yj.sys.common.vo;

import lombok.Data;

@Data
public class RenterOrderHistory{
	/**租客姓名*/
	private String username;
	private String  phone;
	/**订单id*/
	private Integer orderId;
	/**订单生成时间*/
	private String createdTime;
	/**预约公寓id*/
	private Integer apId;
	/**租客id*/
	private Integer renterId;
	/**交易状态*/
	private String status;
	/**经办人id*/
	private Integer staffId;
	/**公寓地址*/
	private String addr;
	/**公寓类型*/
	private String type;
	/**公寓面积*/
	private Integer place;
	/**租金*/
	private Integer price;
	/**公寓名称*/
	private String apname;
}
