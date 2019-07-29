package com.yj.sys.service;

import com.yj.sys.common.vo.PageObject;
import com.yj.sys.entity.SysWaiter;

public interface SysWaiterService {
	PageObject<SysWaiter> findPageObjects(String chtype, String chtext, Integer pageCurrent);

//	PageObject<SysWaiter> searchObject(String chtype, String chtext);

	int saveObject(SysWaiter entity);

	int updateObject(SysWaiter entity);

	int deleteObject(int id);

	int deleteObjects(Integer... ids);

}
