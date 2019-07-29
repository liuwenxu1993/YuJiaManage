package com.yj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yj.sys.common.vo.OwnerPersonAp;
import com.yj.sys.common.vo.OwnerVo;
import com.yj.sys.entity.SysOwner;

@Mapper
public interface SysOwnerDao {
	
	/**查询业主信息及其公寓数量*/
	List<SysOwner> doFindPageObjects(
				@Param("name")String name,
				@Param("startIndex")Integer startIndex,
				@Param("pageSize")Integer pageSize);
	
	/**查询业主总数*/
	Integer getRowCounts(@Param("name")String name);
	
	/**查询平台业主数量*/
	@Select("select count(*) from sys_owner")
	Integer doFindAllOwnerNumber();
	/**查询平台公寓总量*/
	@Select("select count(*) from sys_ap")
	Integer doFindAllApNumber();
	/**查询平台在租公寓数量*/
	@Select("select count(*) from sys_ap where status='已租'")
	Integer doFindOnRentApNumber();
	/**查询本月新增注册业主*/
	@Select("select count(*) from sys_owner where month(register_time)=month(now())")
	Integer doFindRiseOwnerNumber();
	
	/**根据手机号查询业主所有公寓详情*/
	@Select("select * from sys_ap where phone=#{phone} limit #{startIndex},#{pageSize}")
	List<OwnerPersonAp> doFindApByOwnerPhone(
			@Param("phone")String phone,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**个人业主名下公寓数量*/
	@Select("select count(*) from sys_ap where phone=#{phone}")
	Integer doFindApNumberByOwnerPhone(String phone);
	/**个人业主名下在租公寓数量*/
	@Select("select count(*) from sys_ap where phone=#{phone} and status='已租' ")
	Integer doFindOnRentApNumberByOwnerPhone(String phone);
	/**获取业主姓名*/
	@Select("select name from sys_owner where phone=#{phone}")
	String doFindOwnerNameByPhone(String phone);
	
	/**根据公寓id删除公寓*/
	@Delete("delete from sys_ap where id=#{id}")
	Integer doDeleteObject(Integer id);
	
	/**根据手机号删除业主及其公寓*/
	@Delete("delete from sys_owner where phone=#{phone}")
	Integer doDeleteOwner(String phone);
	@Delete("delete from sys_ap where phone=#{phone}")
	Integer doDeleteApByOwnerPhone(String phone);

	@Select("select phone,name from sys_owner where phone like concat('%',#{phone},'%') limit 0,4")
	List<OwnerVo> findOwnerPhone(@Param("phone")String phone);
}
