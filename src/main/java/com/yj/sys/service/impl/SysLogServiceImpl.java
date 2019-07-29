package com.yj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.common.annotation.RequiredLog;
import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.common.util.PageUtil;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.dao.SysLogDao;
import com.yj.sys.entity.SysLog;
import com.yj.sys.service.SysLogService;

import lombok.extern.slf4j.Slf4j;

@Service  //==map.put("sysLogServiceImpl", );
@Slf4j
public class SysLogServiceImpl implements SysLogService{

	
	@Autowired //spring 按属性类型查找bean，然后经行DI注入
	private SysLogDao sysLogDao;
	
	@RequiredLog("删除日志")
	@Override
	public int deleteObjects(Integer... ids) {
		//1.参数效验
		if (ids == null || ids.length==0) {
			throw new IllegalArgumentException("请选择一个记录");
		}
		//2.执行删除
		int rows = sysLogDao.deleteObjects(ids);
		//3.验证并返回结果
		if (rows==0) {
			throw new ServiceException("记录可能不存在");
		}
		return rows;
	}

	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		
		log.info(username);
		//1.参数效验
		if (pageCurrent == null || pageCurrent < 1) {
			//抛出异常  
			throw new IllegalArgumentException("当前页码不正确");
		}
		//2.执行查询总记录数
		log.info("123");
		int rowCount;
			rowCount=sysLogDao.getRowCount(username);
		log.info("321");
		System.out.println(rowCount);
		if (rowCount == 0) {
			throw new ServiceException("系统没有查到对应记录");
		}
		//3.查询当前页要呈现的记录
		int pageSize = 4; //每页显示最多4条信息
		int startIndex = (pageCurrent-1)*pageSize;//当前页起始位置
		List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
		//4.对结果经行计算和封装
		PageObject<SysLog> po = PageUtil.pageUtil(
								pageCurrent, 
								rowCount, 
								pageSize, 
								records);
		//5.返回结果
		return po;
	}


	

}
