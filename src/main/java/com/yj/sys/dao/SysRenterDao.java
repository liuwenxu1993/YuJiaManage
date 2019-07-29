package com.yj.sys.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yj.sys.entity.SysRenter;


@Mapper
public interface SysRenterDao {
	/**查询总租客数目*/
	Integer getRowCounts(@Param("name")String name);
	
	/**按条件查询所有租客信息*/
	List<SysRenter> doFindPageObjects(
			@Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	/**查询平台租客总量*/
	@Select("select count(*) allRenterNumber from sys_renter")
	Integer doFindAllRenterNumber();
	/**查询平台在租租客数量*/
	@Select("select count(*) onRenterNumber from sys_renter where status = '已租'")
	Integer doFindOnRenterNumber();
	/**查询本月新增租客数量*/
	@Select("select count(*) riseRenterNumber from sys_renter where month(register_time)=month(now())")
	Integer doFindRiseRenterNumber();
	/**查询平台预约租客数量*/
	@Select("select count(*) orderRenterNumber from sys_aporder where status = '预约'")
	Integer doFindOrderRenterNumber();

	/** 更改租客状态为成交*/
	@Update("update sys_renter set status='已租' where phone=#{renterPhone}")
	int updateStatus(@Param("renterPhone")String renterPhone);
}
