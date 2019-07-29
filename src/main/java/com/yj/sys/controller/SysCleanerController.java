package com.yj.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.sys.common.vo.JsonResult;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.entity.SysCleanerOrder;
import com.yj.sys.service.SysCleanerOrderService;


@Controller
@RequestMapping("/cleaner/")
public class SysCleanerController {
	
	@Autowired
	private SysCleanerOrderService sysCleanerOrderService;

	@RequestMapping("doCleanerListUI")
	public String doCleanerListUI() {
		return "sys/cleaner_list";
	}
	
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Integer pageCurrent) {
		//Integer a = Integer.parseInt(order);
		//System.out.println(a);
		//log.info(""+a);
		PageObject<SysCleanerOrder> po = 
				sysCleanerOrderService.findPageObjects(pageCurrent);
		return new JsonResult(po);
	}
	
}
