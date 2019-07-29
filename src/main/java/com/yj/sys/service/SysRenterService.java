package com.yj.sys.service;


import com.yj.sys.common.vo.PageObject;
import com.yj.sys.common.vo.RenterCountInfo;

public interface SysRenterService {
	
	/**查询所有租客信息(含预约信息)*/
	PageObject<?> doFindPageObjects(String name,Integer pageCurrent);
	
	/**平台租客信息统计 1*/
	RenterCountInfo doGetRenterCountInfo();
	
	/**查询租客历史订单详情*/
	PageObject<?> doFindPersonOrderHistoryById(Integer id,Integer pageCurrent);

	int doCount();
}
