package com.yj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.dao.SysMenuDao;
import com.yj.sys.entity.Node;
import com.yj.sys.entity.SysMenu;
import com.yj.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;

//	@Autowired 
//	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> list = sysMenuDao.findObjects();
		if (list == null || list.size()==0) {
			throw new ServiceException("没有对应数据");
		}
		return list;
	}


	@Override
	public int deleteObject(Integer id) {
		//1.验证数据的合法性
		if (id == null || id == 0 ) {
			throw new IllegalArgumentException("请选择要删除的记录信息");
		}
		//2.基于id经行子元素查询
		int count = sysMenuDao.getChildCount(id);
		if (count > 0) {
			throw new ServiceException("请先删除菜单下的子菜单！");
		}
		//3.删除菜单元素
		int rows = sysMenuDao.deleteObject(id);
		if (rows == 0) {
			throw new IllegalArgumentException("该菜单可能已经不存在");
		}
		sysMenuDao.deleteObjectsByMenuId(id);
		return rows;
	}




	@Override
	public int getChildCount(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int deleteObjectsByMenuId(Integer id) {
		int rows = sysMenuDao.deleteObjectsByMenuId(id);
		return rows;
	}


	@Override
	public List<Node> findZtreeMenuNodes() {
		return sysMenuDao.findZtreeMenuNodes();
	}


	@Override
	public int saveObject(SysMenu entity) {
		/**添加插入数据的功能，用于将数据插入dao数据库中*/
		
		if (entity == null) {
			throw new ServiceException("保存对象不能为空");
		}
		if (StringUtils.isEmpty(entity.getName())) {
			throw new ServiceException("菜单名不能为空！");
		}
		int rows = sysMenuDao.insertObject(entity);
		return rows;
	}


	@Override
	public int upDataObject(SysMenu entity) {
/**添加插入数据的功能，用于将数据插入dao数据库中*/
		
		if (entity == null) {
			throw new ServiceException("保存对象不能为空");
		}
		if (StringUtils.isEmpty(entity.getName())) {
			throw new ServiceException("菜单名不能为空！");
		}
		int rows = sysMenuDao.upDataObject(entity);
		return rows;
	}





}
