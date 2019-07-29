package com.yj.sys.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yj.common.annotation.RequiredLog;
import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.common.util.PageUtil;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.dao.SysApDao;
import com.yj.sys.dao.SysHouseOrderDao;
import com.yj.sys.dao.SysRenterDao;
import com.yj.sys.entity.SysHouseOrder;
import com.yj.sys.entity.SysStaff;
import com.yj.sys.service.SysHouseOrderService;

@Service
public class SysHouseOrderServiceImpl implements SysHouseOrderService {
	
	@Autowired
	private SysHouseOrderDao sysHouseOrderDao;
	
	@Autowired
	private SysApDao sysApDao;
	
	@Autowired
	SysRenterDao sysRenterDao;
	
	@Override
	public int doCount() {
		int rowCount = sysHouseOrderDao.getRowCount();
		return rowCount;
	}
	
	@Override
	public PageObject<SysHouseOrder> findPageObjects(Integer pageCurrent) {
		if (pageCurrent==null||pageCurrent<1) {
			throw new ServiceException("页码不正确");
		}
		int rowCount = sysHouseOrderDao.getRowCount();
		if (rowCount==0) {
			throw new ServiceException("暂无业务数据");
		}
		int pageSize = PageUtil.pageSize;
		int startIndex = PageUtil.getStartIndex(pageCurrent);
		List<SysHouseOrder> records = 
				sysHouseOrderDao.findPageObjects(startIndex, pageSize);
		PageObject<SysHouseOrder> po = 
				PageUtil.newPageObject(pageCurrent, records,rowCount);
		return po;
	}

	@RequiredLog("作废预约订单")
	@Transactional
	@Override
	public int updateObject(Integer id) {
		SysStaff staff=(SysStaff)SecurityUtils.getSubject().getPrincipal();
		if(staff==null) throw new UnknownAccountException("请登录后再操作");
		//将预约订单状态修改为作废
		int rows = sysHouseOrderDao.updateObject(id,staff.getId());
		return rows;
	}

	@Transactional
	@RequiredLog("成交预约订单")
	@Override
	public int updatePutIn(Integer id,String renterPhone) {
		SysStaff staff=(SysStaff)SecurityUtils.getSubject().getPrincipal();
		if(staff==null) throw new UnknownAccountException("请登录后再操作");
		//修改公寓状态为已租
		int apId = sysHouseOrderDao.findApIdById(id);
		sysApDao.updateStatus(apId);
		
		//修改租客状态为已租
		sysRenterDao.updateStatus(renterPhone);
		
		int rows = sysHouseOrderDao.updatePutIn(id,staff.getId());
		return rows;
	}

}
