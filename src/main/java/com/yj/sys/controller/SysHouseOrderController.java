package com.yj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.sys.common.vo.JsonResult;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.entity.SysHouseOrder;
import com.yj.sys.service.SysHouseOrderService;


@Controller
@RequestMapping("/houseOrder/")
public class SysHouseOrderController {
	
	@Autowired
	private SysHouseOrderService sysHouseOrderService;

	@RequestMapping("doHouseOrderListUI")
	public String doHouseOrderListUI() {
		return "sys/houseOrder_list";
	}
	
	@RequestMapping("doCount")
	@ResponseBody
	public JsonResult doCount() {
		return new JsonResult(sysHouseOrderService.doCount());
	}
	
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Integer pageCurrent) {
		PageObject<SysHouseOrder> po = 
				sysHouseOrderService.findPageObjects(pageCurrent);
		return new JsonResult(po);
		}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(Integer id) {
		sysHouseOrderService.updateObject(id);
		return new JsonResult("已经作废");
		}
	@RequestMapping("doUpdatePutIn")
	@ResponseBody
	public JsonResult doUpdatePutIn(Integer id,String renterPhone) {
		sysHouseOrderService.updatePutIn(id,renterPhone);
		return new JsonResult("提交成功");
		}
}
