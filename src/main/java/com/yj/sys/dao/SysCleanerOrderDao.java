package com.yj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yj.sys.entity.SysCleanerOrder;

@Mapper
public interface SysCleanerOrderDao {
	
	List<SysCleanerOrder> findPageObjects(
			//@Param("order")Integer order,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	int getRowCount(
			//@Param("order")Integer order
			);

}
