package com.yj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Table(name="sys_account")
@Data
@ToString
public class SysAccount implements Serializable {

	private static final long serialVersionUID = 4987944198427364637L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date handledTime;
	private String apName;
	private String apAddr;
	private Integer money;
	private String staffName;
		
}
