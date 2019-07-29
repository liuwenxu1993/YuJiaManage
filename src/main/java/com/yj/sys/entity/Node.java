package com.yj.sys.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Node implements Serializable {

	private static final long serialVersionUID = -2909252578106156339L;
	private Integer id;
	private String name;
	private Integer parentId;
	
}
