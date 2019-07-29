package com.yj.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysApPicsDao {
		@Select("select path from sys_ap_pics where ap_id=#{ApId}")
		String findApPicsByApId(Integer ApId);
		
		int updateApPicById(@Param("apId")Integer id,@Param("path") String path);
}
