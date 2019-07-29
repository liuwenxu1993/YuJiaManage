package com.yj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.sys.common.vo.JsonResult;
import com.yj.sys.service.SysOwnerService;

@Controller
@RequestMapping("/owner/")
public class SysOwnerController {
	
	@Autowired
	private SysOwnerService sysOwnerService;
	
	@RequestMapping("doOwnerListUI")
	public String doOwenerListUI() {
		return "sys/owner_list";
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name,Integer pageCurrent) {
		return new JsonResult(sysOwnerService.doFindPageObjects(name, pageCurrent)) ;
	}
	
	@RequestMapping("doGetOwnerCountInfo")
	@ResponseBody
	public JsonResult doGetOwnerCountInfo() {
		return new JsonResult(sysOwnerService.doGetOwnerCountInfo());
	}
	
	/**加载个人公寓详情*/
	@RequestMapping("doLoadPersonApListUI")
	public String doLoadPersonApListUI() {
		return "sys/personOwnerAp_list";
	}
	
	/**查询业主个人公寓详情*/
	@RequestMapping("doFindPersonApList")
	@ResponseBody
	public JsonResult doFindPersonApList(String phone,Integer pageCurrent){
		return new JsonResult(sysOwnerService.doFindApByOwnerId(phone,pageCurrent));
	}
	
	/**根据公寓id删除公寓*/
	@RequestMapping("doDeleteAp")
	@ResponseBody
	public JsonResult doDeleteAp(Integer id) {
		return new JsonResult(sysOwnerService.doDeleteObject(id));
	}
	@RequestMapping("doDeleteOwnerAp")
	@ResponseBody
	public JsonResult doDeleteOwnerAp(String phone) {
		return new JsonResult(sysOwnerService.doDeleteOwnerAp(phone));
	}
	
	/** 查找业主的电话号码和姓名 */
	@RequestMapping("findOwnerPhone")
	@ResponseBody
	public JsonResult findOwnerPhone(String phone) {
		return new JsonResult(sysOwnerService.findOwnerPhone(phone));
	}
}
