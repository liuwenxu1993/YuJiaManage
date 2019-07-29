package com.yj.sys.service;

import java.util.List;

import com.yj.sys.common.vo.OwnerCountInfo;
import com.yj.sys.common.vo.OwnerVo;
import com.yj.sys.common.vo.PageObject;

public interface SysOwnerService {
	
	/**查询业主信息及其公寓数量*/
	public PageObject<?> doFindPageObjects(String name, Integer pageCurrent);
	
	/**查询平台业主统计信息*/
	OwnerCountInfo doGetOwnerCountInfo();
	
	/**根据手机号查询业主所有公寓详情*/
	PageObject<?> doFindApByOwnerId(String phone,Integer pageCurrent);
	
	/**根据公寓id删除公寓*/
	Integer doDeleteObject(Integer id);
	
	/**删除业主及其名下公寓*/
	Integer doDeleteOwnerAp(String phone);

	List<OwnerVo> findOwnerPhone(String phone);
}
