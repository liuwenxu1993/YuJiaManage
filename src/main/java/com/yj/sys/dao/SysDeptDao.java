package com.yj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.yj.sys.entity.Node;
import com.yj.sys.entity.SysDept;


@Mapper
public interface SysDeptDao {
	/**查询部门所有信息，只显示id和名字以及上一级信息*/
	List<Map<String,Object>> findObjects();
	List<SysDept> findById(Integer id);
	
	/**基于id查询是否有子元素*/
	int getChildCount(Integer id);
	/**根据id删除部门*/
	int deleteObject(Integer id);
	
	/**数据库对应的部门表中的所有部门信息*/
	List<Node> findZtreeDeptNodes();
	/**将部门信息写入到数据库*/
	int insertObject(SysDept sysDept);
	/**实现数据库中部门信息的修改*/
	int updateObject(SysDept sysDept);
}
