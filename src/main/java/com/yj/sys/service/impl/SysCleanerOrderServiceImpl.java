package com.yj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.common.util.PageUtil;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.dao.SysCleanerOrderDao;
import com.yj.sys.entity.SysCleanerOrder;
import com.yj.sys.service.SysCleanerOrderService;


@Service
public class SysCleanerOrderServiceImpl implements SysCleanerOrderService {

	@Autowired
	private SysCleanerOrderDao sysCleanerOrderDao;
	
	@Override
	public PageObject<SysCleanerOrder> 
	findPageObjects(//Integer order, 
			Integer pageCurrent) {
		if (pageCurrent==0||pageCurrent<1) {
			throw new ServiceException("页码不存在");
		}
		int rowCount = sysCleanerOrderDao.getRowCount(//order
				);
		if (rowCount==0) {
			throw new ServiceException("记录不存在");
		}
		int startIndex = PageUtil.getStartIndex(pageCurrent);
		int pageSize = PageUtil.pageSize;
		List<SysCleanerOrder> records = 
				sysCleanerOrderDao.findPageObjects(//order, 
						startIndex, pageSize);
		PageObject<SysCleanerOrder> po = 
				PageUtil.newPageObject(pageCurrent, records,rowCount);
		return po;
	}

}
