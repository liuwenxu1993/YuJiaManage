package com.yj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.yj.sys.common.vo.SysApVo;

@Mapper
public interface SysApDao {
		int getRowCount(@Param("param")String param);
		List<SysApVo> findPageObjects(@Param("param")String param,
														 @Param("startIndex")Integer startIndex,
														 @Param("pageSize")Integer pageSize);
		
		//SysApVo findApById(@Param("id")Integer id);
		
		SysApVo findPageById(@Param("id")Integer id);
		
		@Update("update sys_ap set status='已租' where id=#{apId}")
		int updateStatus(@Param("apId")int apId);
}
