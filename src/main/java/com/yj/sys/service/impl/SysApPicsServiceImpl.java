package com.yj.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.entity.SysApPics;
import com.yj.sys.mapper.SysApPicsMapper;
import com.yj.sys.service.SysApPicsService;

@Service
public class SysApPicsServiceImpl implements SysApPicsService{
	@Autowired
	SysApPicsMapper sysAppicMapper;
	
	@Override
	public int insertObject(SysApPics entity) {
		int row = sysAppicMapper.insert(entity);
		if(row==0) throw new ServiceException("新增公寓图片失败");
		return row;
	}
}
