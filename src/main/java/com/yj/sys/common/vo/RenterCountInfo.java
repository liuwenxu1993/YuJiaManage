package com.yj.sys.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class RenterCountInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3009886600102218839L;
	/**平台租客总量*/
	private Integer allRenterNumber;
	/**在租租客数量*/
	private Integer onRenterNumber;
	/**预约租客数量*/
	private Integer orderRenterNumber;
	/**本月新增租客数量*/
	private Integer riseRenterNumber;
	public RenterCountInfo(Integer allRenterNumber, Integer onRenterNumber, Integer orderRenterNumber,
			Integer riseRenterNumber) {
		super();
		this.allRenterNumber = allRenterNumber;
		this.onRenterNumber = onRenterNumber;
		this.orderRenterNumber = orderRenterNumber;
		this.riseRenterNumber = riseRenterNumber;
	}
	
}
