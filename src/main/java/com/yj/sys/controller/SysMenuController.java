package com.yj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.sys.common.vo.JsonResult;
import com.yj.sys.entity.SysMenu;
import com.yj.sys.service.SysMenuService;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/menu/")
@Slf4j
public class SysMenuController {
	
	@Autowired
	private SysMenuService sysMenuService;
	
	/**返回加载菜单页面*/
	@RequestMapping("doMenuListUI")
	public String doMenuListUI() {
		
		return "sys/menu_list";
	}
	
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
		return new JsonResult(sysMenuService.findObjects());
	}
	
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		int deleteObjectRows = sysMenuService.deleteObject(id);
		return new JsonResult("成功删除，受影响的行数为： " + deleteObjectRows);
	}
	
	@RequestMapping("doMenuEditUI")
	public String doMenuEditUI() {
		log.info("点击后运行dao了这一行");
		return "sys/menu_edit";
	}
	
	@RequestMapping("doFindZtreeMenuNodes")
	@ResponseBody
	public JsonResult doFindZtreeMenuNodes() {
		return new JsonResult(sysMenuService.findZtreeMenuNodes());
	}
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysMenu entity) {
		sysMenuService.saveObject(entity);
		log.info("点击后运行dao了这一行2");
		return new JsonResult("保存成功！");
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult upDataObject(SysMenu entity) {
		sysMenuService.upDataObject(entity);
		log.info("点击后运行dao了这一行2");
		return new JsonResult("保存成功！");
	}
	
}
