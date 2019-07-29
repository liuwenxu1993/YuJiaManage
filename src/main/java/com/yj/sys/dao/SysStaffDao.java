package com.yj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yj.sys.common.vo.SysStaffVo;
import com.yj.sys.entity.SysDept;
import com.yj.sys.entity.SysStaff;
@Mapper
public interface SysStaffDao {
	
	List<SysStaffVo> findPageObjects(@Param("name") String name, @Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);

	/**
	 * 基于条件查询总记录数
	 * 
	 * @param username 查询条件(例如查询哪个用户的日志信息)
	 * @return 总记录数(基于这个结果可以计算总页数) 说明：假如如下方法没有使用注解修饰，在基于名字进行查询 时候会出现There is no
	 *         getter for property named 'username' in 'class java.lang.String'
	 */
	
	int getRowCount(@Param("name") String name);
	
	@Select("select * from sys_depts where id=#{deptId}")
	SysDept findDeptByStaffDeptId(@Param("deptId")Integer deptId);
	
	 int doDeleteObjects(
		        @Param("id")Integer... id);
	 
	 int updateObject(SysStaff entity);
	 
	 int tianjiaObject(@Param("id")Integer id,
				@Param("name")String name,
				@Param("parentId")Integer parentId);

	 
	int insertObject(SysStaff entity);
}
