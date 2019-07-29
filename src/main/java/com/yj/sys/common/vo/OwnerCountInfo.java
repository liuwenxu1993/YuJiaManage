package com.yj.sys.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class OwnerCountInfo implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -3414622196803227060L;
	/**平台业主总量*/
	private Integer ownerCount;
	/**平台公寓总量*/
	private Integer apCount;
	/**平台在租公寓总量*/
	private Integer onRentApCount;
	/**本月新增注册业主*/
	private Integer riseOwnerNumber;
	
	public OwnerCountInfo(Integer ownerCount, Integer apCount, Integer onRentApCount, Integer riseOwnerNumber) {
		super();
		this.ownerCount = ownerCount;
		this.apCount = apCount;
		this.onRentApCount = onRentApCount;
		this.riseOwnerNumber = riseOwnerNumber;
	}

	public OwnerCountInfo() {
		super();
	}
	
}
