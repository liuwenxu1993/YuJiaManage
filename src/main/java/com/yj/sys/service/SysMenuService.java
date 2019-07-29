package com.yj.sys.service;

import java.util.List;
import java.util.Map;

import com.yj.sys.entity.Node;
import com.yj.sys.entity.SysMenu;



public interface SysMenuService {
	
	
	List<Map<String,Object>> findObjects();
	
	/**根据ID删除菜单*/
	int deleteObject(Integer id);
	
	/**根据菜单id删除记录*/
	int deleteObjectsByMenuId(Integer id);
	/**根据id统计子菜单数*/
	int getChildCount(Integer id);
//	/**根据id删除对应记录信息*/
//	int doDeleteObjects(Integer id);
	
	/**查询所有菜单信息，并且呈现在treegrid中*/
	
	/**查询所有菜单id,name,parentID,并且呈现在zTree中*/
	List<Node> findZtreeMenuNodes();
	
	/**添加插入数据的功能，用于将数据插入dao数据库中*/
	int saveObject(SysMenu entity);
	
	int upDataObject(SysMenu entity);
}
