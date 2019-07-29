package com.yj.sys.service;

import com.yj.sys.common.vo.PageObject;
import com.yj.sys.entity.SysHouseOrder;

public interface SysHouseOrderService {
	
	PageObject<SysHouseOrder> findPageObjects(Integer pageCurrent);
	int updateObject(Integer id);
	int updatePutIn(Integer id,String renterPhone);
	int doCount();

}
