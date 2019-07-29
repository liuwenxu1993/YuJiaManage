package com.yj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yj.sys.entity.SysWaiter;

@Mapper
public interface SysWaiterDao {
	int getRowCount(
			@Param("chtype")String chtype, 
			@Param("chtext")String chtext);

	List<SysWaiter> findPageObjects(
			@Param("chtype")String chtype, 
			@Param("chtext")String chtext, 
			@Param("startIndex")int startIndex, 
			@Param("pageSize")int pageSize);

	int insertObject(SysWaiter entity);

	int updateObject(SysWaiter entity);
	
	int deleteObject(Integer id);
	
	int deleteObjects(Integer... ids);
}
