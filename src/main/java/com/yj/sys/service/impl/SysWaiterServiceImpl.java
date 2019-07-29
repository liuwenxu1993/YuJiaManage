package com.yj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.common.util.PageUtil;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.dao.SysWaiterDao;
import com.yj.sys.entity.SysWaiter;
import com.yj.sys.service.SysWaiterService;

@Service
public class SysWaiterServiceImpl implements SysWaiterService {

	@Autowired
	SysWaiterDao sysWaiterDao;

	public PageObject<SysWaiter> findPageObjects(String chtype, String chtext, Integer pageCurrent) {
		// 1.参数校验
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("页码不正确");
		// 2.查询总记录数并进行校验
		int rowCount = sysWaiterDao.getRowCount(chtype, chtext);
		if (rowCount == 0)
			throw new ServiceException("记录不存在");
		// 3.查询当前页要呈现的记录
		// 3.1页面大小,例如每页最多显示10条
		int pageSize = PageUtil.pageSize;
		// 3.2当前页起始位置
		int startIndex = PageUtil.getStartIndex(pageCurrent);
		List<SysWaiter> records = sysWaiterDao.findPageObjects(chtype, chtext, startIndex, pageSize);
		// 4.对查询结果进行计算和封装并返回
		return PageUtil.newPageObject(pageCurrent, records,rowCount);
	}

	@Override
	public int saveObject(SysWaiter entity) {
		// 1.参数校验
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("菜单名不能为空");
//		if (StringUtils.isEmpty(entity.getPermission()))
//			throw new IllegalArgumentException("权限标识不能为空");
		// 2.持久化数据
		int rows = sysWaiterDao.insertObject(entity);
		// 3.返回结果
		return rows;
	}

	@Override
	public int updateObject(SysWaiter entity) {
		// 1.参数校验
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("菜单名不能为空");
//    	if(StringUtils.isEmpty(entity.getPermission()))
//    		throw new IllegalArgumentException("权限标识不能为空");
		// 2.持久化数据
		int rows = sysWaiterDao.updateObject(entity);
		// 3.返回结果
		return rows;
	}

	@Override
	public int deleteObject(int id) {
		int rows = sysWaiterDao.deleteObject(id);
		return rows;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		for (int i = 0; i < ids.length; i++) {
			sysWaiterDao.deleteObject(ids[i]);
		}
		return ids.length;
	}

}
