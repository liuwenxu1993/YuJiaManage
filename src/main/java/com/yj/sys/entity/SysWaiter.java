package com.yj.sys.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysWaiter implements Serializable {

	private static final long serialVersionUID = -5636955534958722264L;

	private Integer id;
	private String name;
	private String gender;
	private Integer age;
	private String phone;
	private String carno;
	private String scope;
	private String status;
	private Date regtime;
	private Integer ability;

	public SysWaiter(int id, String name, String gender, int age, String phone, String carno, String scope,
			String status, Date regtime, int ability) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.carno = carno;
		this.scope = scope;
		this.status = status;
		this.ability = ability;
		this.regtime = regtime;
	}

	public SysWaiter() {
	}
	
}
