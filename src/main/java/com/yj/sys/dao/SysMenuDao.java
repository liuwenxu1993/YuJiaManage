package com.yj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yj.sys.entity.Node;
import com.yj.sys.entity.SysMenu;


@Mapper
public interface SysMenuDao {
	
	/**查询所有记录，一条记录用map接受，多条则将map添加到list集合中*/
	List<Map<String,Object>> findObjects();
	
	
	/**
	  * 根据菜单id统计子菜单的个数
	  * @param id
	  * @return
	  */
	 int getChildCount(Integer id);
	 /**
	  * 根据id 删除菜单
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
	 int deleteObjectsByMenuId(Integer menuId);
	 
	 List<Node> findZtreeMenuNodes();
	 
	 /**添加插入数据的功能，用于将数据插入dao数据库中*/
	 int insertObject(SysMenu entity);
	 int saveObject(SysMenu entity);
	 int upDataObject(SysMenu entity);
	 
	 /* 基于菜单id查找权限标识信息 */
	 List<String> findPermisssions(@Param("menuIds")Integer[] menuIds);
	 
}
