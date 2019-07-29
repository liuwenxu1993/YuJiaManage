package com.yj.sys.common.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OwnerVo implements Serializable{
	private static final long serialVersionUID = -6575611019012299414L;
	private String name;
	private String phone;

}
