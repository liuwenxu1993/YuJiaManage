package com.yj.sys.service;

import org.apache.ibatis.annotations.Param;

import com.yj.sys.common.vo.PageObject;
import com.yj.sys.common.vo.SysStaffVo;
import com.yj.sys.entity.SysStaff;

public interface SysStaffService {

	 PageObject<SysStaffVo> findPageObjects(
			 String name,
			 Integer pageCurrent);
	 
	 int getRowCount(@Param("name") String name);

	int doDeleteObjects(Integer... id);
	int updateObject(SysStaff entity,Integer[] id);
	
	/**添加用户
	 * */
	int insertObject(SysStaff staff,Integer... roleIds);

}
