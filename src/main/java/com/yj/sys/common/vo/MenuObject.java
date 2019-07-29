package com.yj.sys.common.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MenuObject<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7731924427673423196L;
//	/**当前页的页码值*/
//	private Integer menuCurrent=1;
//    /**页面大小*/
//    private Integer menuSize=3;
//    /**总行数(通过查询获得)*/
//    private Integer rowCount=0;
//    /**总页数(通过计算获得)*/
//    private Integer menuCount=0;
//    /**当前页记录*/
//    private List<T> records;
//    
    private Integer id;
	/**菜单名称*/
	private String name;
	/**菜单url: log/doFindPageObjects*/
	private String url;
	/**菜单类型(两种:按钮,普通菜单)*/
	private Integer type=1;
	/**排序(序号)*/
	private Integer sort;
	/**备注*/
	private String note;
	/**上级菜单id*/
	private Integer parentId;
	/**菜单对应的权限标识(sys:log:delete)*/
	private String permission;
	/**创建用户*/
	private String createdUser;
	/**修改用户*/
	private String modifiedUser;
	private Date createdTime;
	private Date modifiedTime;
}
