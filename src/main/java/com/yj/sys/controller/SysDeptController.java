package com.yj.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.sys.common.vo.JsonResult;
import com.yj.sys.entity.SysDept;
import com.yj.sys.service.SysDeptService;

/**
 * 部门管理页面
 * @author UID
 *
 */
@Controller
@RequestMapping("/dept/")
public class SysDeptController {
	
	//private static final Logger log = LoggerFactory.getLogger(SysLogServiceImpl.class);
	
	@Autowired
	private SysDeptService sysDeptService;
	
	/**返回部门管理页面*/
	@RequestMapping("doDeptListUI")
	public String doDeptListUI() {
		return "sys/dept_list";
	}
	
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
		List<Map<String, Object>> fo = sysDeptService.findObjects();
		for (int i = 0; i < fo.size(); i++) {
			
		}
		return new JsonResult(fo);
	}
	
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		sysDeptService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("doDeptEditUI")
	 public String doDeptEditUI(){
		 return "sys/dept_edit";
	 }
	
	@RequestMapping("doFindZTreeNodes")
	@ResponseBody
	public JsonResult doFindZtreeDeptNodes() {
		System.out.println("tree");
		return new JsonResult(sysDeptService.findZtreeDeptNodes());
	}
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysDept entity) {
		sysDeptService.saveObject(entity);
		return new JsonResult("保存成功");
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysDept entity) {
		sysDeptService.updateObject(entity);
		return new JsonResult("修改成功");
	}
	
}
