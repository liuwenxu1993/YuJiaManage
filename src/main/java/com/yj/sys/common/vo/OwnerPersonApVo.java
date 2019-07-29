package com.yj.sys.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class OwnerPersonApVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 107650269356890627L;
	private List<OwnerPersonAp> ownerPersonAp;
	/**在租公寓数量*/
	private Integer onRentApNumber;
	/**公寓数量*/
	private Integer apNumber;
	/**业主姓名*/
	private String ownerName;
	
	public OwnerPersonApVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OwnerPersonApVo(List<OwnerPersonAp> ownerPersonAp, Integer onRentApNumber, Integer apNumber,String ownerName) {
		super();
		this.ownerPersonAp = ownerPersonAp;
		this.onRentApNumber = onRentApNumber;
		this.apNumber = apNumber;
		this.ownerName = ownerName;
	}
	
}
