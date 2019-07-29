package com.yj.sys.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.yj.common.annotation.RequiredLog;
import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.common.vo.SysStaffVo;
import com.yj.sys.dao.SysStaffDao;
import com.yj.sys.entity.SysStaff;
import com.yj.sys.service.SysStaffService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SysStaffServiceImpl implements SysStaffService {

	@Autowired
	private SysStaffDao sysStaffDao;

	@Override
	public PageObject<SysStaffVo> findPageObjects(String name, Integer pageCurrent) {
		// 1.验证参数合法性
		// 1.1验证pageCurrent的合法性，
		// 不合法抛出IllegalArgumentException异常
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		// 2.基于条件查询总记录数
		// 2.1) 执行查询
		int rowCount = sysStaffDao.getRowCount(name);
		// 2.2) 验证查询结果，假如结果为0不再执行如下操作
		if (rowCount == 0)
			throw new ServiceException("系统没有查到对应记录");
		// 3.基于条件查询当前页记录(pageSize定义为2)
		// 3.1)定义pageSize
		int pageSize = 5;
		// 3.2)计算startIndex
		int startIndex = (pageCurrent - 1) * pageSize;
		// 3.3)执行当前数据的查询操作
		List<SysStaffVo> records = sysStaffDao.findPageObjects(name, startIndex, pageSize);
		// 4.对分页信息以及当前页记录进行封装
		// 4.1)构建PageObject对象
		PageObject<SysStaffVo> pageObject = new PageObject<>();
		// 4.2)封装数据
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount - 1) / pageSize + 1);
		// 5.返回封装结果。
		return pageObject;
	}

	@Override
	public int getRowCount(String name) {

		return sysStaffDao.getRowCount(name);
	}

	@RequiredLog("删除用户")
	@Override
	public int doDeleteObjects(Integer... id) {
		int rows = sysStaffDao.doDeleteObjects(id);
		if (rows > 0) {
			log.info("成功删除了=" + rows);
		}
		return rows;
	}

	@RequiredLog("修改用户")
	@Override
	public int updateObject(SysStaff entity, Integer[] id) {
		// 1.参数校验
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("角色名不能为空");
		// 2.保存角色自身信息
		int rows = sysStaffDao.updateObject(entity);
		// 3.返回结果
		return rows;
	}

	@RequiredLog("新增用户")
	@Transactional
	@Override
	public int insertObject(SysStaff entity,Integer... roleIds) {
		//1.验证数据合法性
		if(entity==null)
		throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
	    throw new ServiceException("用户名不能为空");
		if(StringUtils.isEmpty(entity.getPassword()))
		throw new ServiceException("密码不能为空");
        
        String salt = UUID.randomUUID().toString();
        SimpleHash sh = new SimpleHash("MD5",entity.getPassword(), salt, 1);
        entity.setPassword(sh.toHex());
        entity.setSalt(salt);
        int rows = sysStaffDao.insertObject(entity);
        
		return 	rows;
		
	}



	

}
