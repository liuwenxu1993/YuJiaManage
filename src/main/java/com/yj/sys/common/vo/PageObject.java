package com.yj.sys.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.ToString;

/** 负责封装业务层当前页记录以及分页信息 */
@Data
@ToString
public class PageObject<T> implements Serializable{
	
	
	private static final long serialVersionUID = 5329636685297080372L;
	/**当前页的页码值*/
	private Integer pageCurrent;
	/**页面大小*/
    private Integer pageSize;
    /**总行数(通过查询获得)*/
    private Integer rowCount;
    /**总页数(通过计算获得)*/
    private Integer pageCount;
    /**当前页记录*/
    private List<T> records;
}
