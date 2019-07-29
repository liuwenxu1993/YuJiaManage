package com.yj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.sys.common.vo.JsonResult;
import com.yj.sys.entity.SysWaiter;
import com.yj.sys.service.SysWaiterService;

@Controller
@RequestMapping("/arc/")
public class SysWaiterController {
	@Autowired
	private SysWaiterService sysWaiterService;

	/** 加载服务人员档案列表页面 */
	@RequestMapping("doLogWaiterUI")
	public String doLogWaiterUI() {
		return "sys/waiter_list";
	}

	/** 加载上下页导航 */
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}

	/** 加载服务人员档案编辑页面 */
	@RequestMapping("doEditUI")
	public String doAEditUI() {
		return "sys/waiter_edit";
	}

	/** 返回数据到列表页面 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String chtype, String chtext, Integer pageCurrent) {
		return new JsonResult(sysWaiterService.findPageObjects(chtype, chtext, pageCurrent));
	}

	/** 增加一条数据 */
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysWaiter entity) {
		sysWaiterService.saveObject(entity);
		return new JsonResult("提交成功!");
	}

	/** 修改一条数据 */
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysWaiter entity) {
		sysWaiterService.updateObject(entity);
		return new JsonResult("修改成功!");
	}

	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		sysWaiterService.deleteObject(id);
		return new JsonResult("delete ok");
	}

	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids) {// 1,2,3,4
		int rows = sysWaiterService.deleteObjects(ids);
		return new JsonResult("删除了 " + rows + " 条数据.");
	}

}
