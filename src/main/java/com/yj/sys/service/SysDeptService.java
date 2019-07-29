package com.yj.sys.service;

import java.util.List;
import java.util.Map;

import com.yj.sys.entity.Node;
import com.yj.sys.entity.SysDept;


public interface SysDeptService {
	
	List<Map<String, Object>>findObjects();
	/**根据id删除部门信息*/
	int deleteObject(Integer id);
	
	List<Node> findZtreeDeptNodes();
	
	int saveObject(SysDept sysDept);
	
	int updateObject(SysDept sysDept);
}
