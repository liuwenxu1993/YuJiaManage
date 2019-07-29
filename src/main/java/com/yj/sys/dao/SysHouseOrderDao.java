package com.yj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yj.sys.entity.SysAccount;
import com.yj.sys.entity.SysApOrder;
import com.yj.sys.entity.SysHouseOrder;

@Mapper
public interface SysHouseOrderDao {
	
	List<SysHouseOrder> findPageObjects(
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	int getRowCount();
	
	int updateObject(@Param("id")Integer id,@Param("staffId") Integer staffId);
	
	int updatePutIn(@Param("id")Integer id,@Param("staffId") Integer staffId);
	
	@Select("select ap_id from sys_aporder where id=#{id}")
	int findApIdById(@Param("id")Integer id);
	
	int addAccount(@Param("id")Integer id,@Param("date")String date);
	
	SysApOrder findOrderByApId(Integer apId);

	List<SysAccount> findDoneOrder(@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	@Select("select count(*) from sys_aporder where status='成交'")
	int getDoneRowCount();

	int sumAccount();
}
