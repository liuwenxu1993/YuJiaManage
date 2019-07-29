package com.yj.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.yj.common.annotation.RequiredLog;
import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.common.util.PageUtil;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.common.vo.SysApVo;
import com.yj.sys.dao.SysApDao;
import com.yj.sys.dao.SysApPicsDao;
import com.yj.sys.entity.SysAp;
import com.yj.sys.entity.SysApPics;
import com.yj.sys.entity.SysStaff;
import com.yj.sys.mapper.SysApMapper;
import com.yj.sys.mapper.SysApPicsMapper;
import com.yj.sys.service.SysApService;

@Service
public class SysApServiceImpl implements SysApService{
	
		@Autowired
		SysApMapper sysApMapper;
		@Autowired
		SysApPicsMapper sysApPicsMapper;
		@Autowired
		SysApDao sysApDao;
		@Autowired
		SysApPicsDao sysApPicsDao;
	
		
		@Override
		public int doCount() {
			return sysApDao.getRowCount(null);
		}
		
		@RequiredLog("新增公寓")
		@Transactional
		@Override
		public int insertObject(SysAp entity,String path) {
			if(entity==null||StringUtils.isEmpty(path)) throw new IllegalArgumentException("上传数据失败");
			SysStaff user=(SysStaff)SecurityUtils.getSubject().getPrincipal();
			if(user==null) throw new UnknownAccountException("请登录后再修改");
			String name = user.getName();
			entity.setCreatedUser(name);
			entity.setStatus("未租");
			int row = sysApMapper.insert(entity);
			if(row==0) throw new ServiceException("新增公寓失败");
			SysApPics pics = new SysApPics();
			pics.setApId(entity.getId());
			pics.setPath(path);
			sysApPicsMapper.insert(pics);
			return row;
		}
		
		//分页显示公寓信息
		@Override
		public PageObject<SysApVo> findPageObejct(String param, Integer pageCurrent) {
			//1.参数校验
			if(pageCurrent==null||pageCurrent<1) throw new IllegalArgumentException("页面参数异常");
			//2.查询总记录数
			int rowCount = sysApDao.getRowCount(param);
			//3.获取起始index
			Integer startIndex = PageUtil.getStartIndex(pageCurrent);
			//4.获取每页条数
			Integer  pageSize=PageUtil.pageSize;
			//5.查询记录
			List<SysApVo> records = sysApDao.findPageObjects(param,startIndex,pageSize);
			System.out.println(records);
			//6.结果校验
			if(records==null||StringUtils.isEmpty(records)) throw new ServiceException("该公寓不存在");
			//7.封装记录
			PageObject<SysApVo> po = PageUtil.newPageObject(pageCurrent,records,rowCount);
			
			return po;
		}
		
		/** 查找单个公寓信息 */
		@Override
		public SysApVo findPageById(Integer id) {
			SysApVo vo = sysApDao.findPageById(id);
			return vo;
		}
		
		@RequiredLog("修改公寓")
		@Transactional
		@Override
		public int updateObject(SysAp entity, String picName) {
			if(entity==null||StringUtils.isEmpty(entity)) throw new ServiceException("公寓信息异常");
			SysStaff user=(SysStaff)SecurityUtils.getSubject().getPrincipal();
			if(user==null) throw new UnknownAccountException("请登录后再修改");
			String name = user.getName();
			entity.setModifiedUser(name);
			entity.setModifiedTime(new Date());
			int row = sysApMapper.updateByPrimaryKey(entity);
			if(picName==null) return row;
			sysApPicsDao.updateApPicById(entity.getId(),picName);
			return row;
		}
}
