package com.yj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.sys.common.vo.JsonResult;
import com.yj.sys.service.SysAccountService;

@Controller
@RequestMapping("account")
public class SysAccountController {

	@Autowired
	SysAccountService service;
	
	@RequestMapping("doAccountListUI")
	public String doAccountList() {
		return "sys/account_list";
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Integer pageCurrent) {
		return new JsonResult(service.doFindPageObjects(pageCurrent));
	}
	
	@RequestMapping("doAccountAmount")
	@ResponseBody
	public JsonResult doAccountAmount() {
		return new JsonResult(service.doAccountAmount());
	}
}
