package com.yj.sys.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class RenterOrderHistoryVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4649561201906974911L;
	/**历史订单详情*/
	private List<RenterOrderHistory> orderInfo;
	/**订单总数*/
	private Integer orderCount=0;
	/**成功订单数*/
	private Integer successOrderCount=0;
}
