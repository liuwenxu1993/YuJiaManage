package com.yj.sys.service;

import com.yj.sys.common.vo.PageObject;
import com.yj.sys.entity.SysLog;

public interface SysLogService {
	/**
	 * 基于用户传入的多个id执行日志删除业务
	 * @param ids
	 * @return
	 */
	int deleteObjects(Integer... ids);
	
	
	/**
	 * 执行分页查询
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	PageObject<SysLog> findPageObjects(
			String username,
			Integer pageCurrent);
	
}
