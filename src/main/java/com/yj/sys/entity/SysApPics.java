package com.yj.sys.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Table(name="sys_ap_pics")
public class SysApPics implements Serializable{
		private static final long serialVersionUID = 741342887210341835L;
		@Id
		private Integer id;
		private Integer apId; //对应公寓编号
		private String path;
}
