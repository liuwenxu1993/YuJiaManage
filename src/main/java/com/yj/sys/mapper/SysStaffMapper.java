package com.yj.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yj.sys.entity.SysStaff;

@Mapper
public interface SysStaffMapper extends MapperUtil<SysStaff>{

	@Select("select * from sys_staff where name=#{name}")
	SysStaff findUserByName(String name);

}
