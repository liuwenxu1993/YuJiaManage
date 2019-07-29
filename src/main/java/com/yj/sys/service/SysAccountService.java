package com.yj.sys.service;

import com.yj.sys.common.vo.PageObject;
import com.yj.sys.entity.SysAccount;

public interface SysAccountService {
		PageObject<SysAccount> doFindPageObjects(Integer pageCurrent);

		int doAccountAmount();
}
