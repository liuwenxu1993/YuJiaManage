package com.yj.sys.service;

import com.yj.sys.common.vo.PageObject;
import com.yj.sys.entity.SysCleanerOrder;

public interface SysCleanerOrderService {
	
	PageObject<SysCleanerOrder> findPageObjects(//Integer order,
			Integer pageCurrent);

}
