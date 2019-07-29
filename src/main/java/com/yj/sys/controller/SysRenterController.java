package com.yj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.sys.common.vo.JsonResult;
import com.yj.sys.service.SysRenterService;


@Controller
@RequestMapping("/renter/")
public class SysRenterController {
	@Autowired
	private SysRenterService sysRenterService;
	@RequestMapping("doRenterListUI")
	public String doRenterListUI() {
		return "sys/renter_list";
	}
	
	/** 首页的租客统计信息 */ 
	@RequestMapping("doCount")
	@ResponseBody
	public JsonResult doCount() {
		return new JsonResult(sysRenterService.doCount());
	}
	
	
	/**加载个人订单详情*/
	@RequestMapping("doLoadPersonOrderListUI")
	public String doLoadPersonOrderListUI() {
		return "sys/personOrder_list";
	}
	/**查询所有租客信息(含预约信息)*/
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name,Integer pageCurrent){
		System.out.println("find");
		return new JsonResult(sysRenterService.doFindPageObjects(name, pageCurrent));
	}
	
	/**查询平台租客统计信息*/
	@RequestMapping("doGetRenterCountInfo")
	@ResponseBody
	public JsonResult doGetRenterCountInfo(){	
		return new JsonResult(sysRenterService.doGetRenterCountInfo());
	}
	
	@RequestMapping("doFindPersonOrderHistoryById")
	@ResponseBody
	public JsonResult doFindPersonOrderHistoryById(Integer id,Integer pageCurrent) {
		return new JsonResult(sysRenterService.doFindPersonOrderHistoryById(id,pageCurrent));
	}
}
