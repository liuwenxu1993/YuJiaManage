package com.yj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.common.util.PageUtil;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.dao.SysHouseOrderDao;
import com.yj.sys.entity.SysAccount;
import com.yj.sys.service.SysAccountService;

@Service
public class SysAccountServiceImpl implements SysAccountService{
	
	@Autowired
	SysHouseOrderDao sysHouseOrderDao;
	
	@Override
	public PageObject<SysAccount> doFindPageObjects(Integer pageCurrent) {
		if(pageCurrent<1)throw new ServiceException("页码参数不正确");
		int rowCount = sysHouseOrderDao.getDoneRowCount();
		Integer startIndex = PageUtil.getStartIndex(pageCurrent);
		Integer pageSize=PageUtil.pageSize;
		List<SysAccount> doneOrder = sysHouseOrderDao.findDoneOrder(startIndex,pageSize);
		if(doneOrder==null||StringUtils.isEmpty(doneOrder)) throw new ServiceException("暂无业务数据");
		PageObject<SysAccount> po = PageUtil.newPageObject(pageCurrent,doneOrder,rowCount);
		System.out.println("业务数据:"+po);
		return po;
	}
	
	@Override
	public int doAccountAmount() {
		int sum = sysHouseOrderDao.sumAccount();
		return sum;
	}
	
}
