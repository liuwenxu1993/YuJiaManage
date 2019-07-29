package com.yj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.sys.common.vo.JsonResult;
import com.yj.sys.service.SysLogService;

@Controller
@RequestMapping("/log/")
public class SysLogController {

	@RequestMapping("doLogListUI")
	public String doLogListUI() {
		return "sys/log_inner_list";
	}

	// spring按属性类型查找bean，然后经行DI注入
	@Autowired
	private SysLogService sysLogService;

	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids) {
		// 调用实现了sysLogService接口的实现类去实现该接口里面的deleteObjects方法
		int rows = sysLogService.deleteObjects(ids);
		return new JsonResult("成功删除,受影响的行数为：" + rows);
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
		return new JsonResult(sysLogService.findPageObjects(username, pageCurrent));
	}
	
}
