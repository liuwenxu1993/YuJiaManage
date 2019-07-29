package com.yj.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.sys.common.vo.JsonResult;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.common.vo.SysStaffVo;
import com.yj.sys.entity.SysStaff;
import com.yj.sys.service.SysStaffService;

@Controller
@RequestMapping("/staff/")
public class SysStaffController {
	@Autowired
	private SysStaffService sysStaffSevice;
	
	/** 用户登录 */
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String name,String password) {
		//用token封装用户信息 将phone替代username
		UsernamePasswordToken ppToken = new UsernamePasswordToken(name,password);
		//默认记住用户
		ppToken.setRememberMe(true);
		//获取一个subject,执行登录
		 Subject subject=SecurityUtils.getSubject();
		 subject.login(ppToken);
		 return new JsonResult("登录成功");
	}
	
	@RequestMapping("doStaffListUI")
	 public String doStaffListUI() {
		 //return "ajax/log";
		 return "sys/user_list";
	 }
	@RequestMapping("getRowCount")
	@ResponseBody
	public JsonResult getRowCount(String name) {
		int rowCount = sysStaffSevice.getRowCount(name);
		return new JsonResult(rowCount)	;
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name,Integer pageCurrent){
	 PageObject<SysStaffVo> pageObject=
			sysStaffSevice.findPageObjects(name,pageCurrent);
	return new JsonResult(pageObject);
	}
	
	 @RequestMapping("doDeleteObjects")
	 @ResponseBody
	 public JsonResult doDeleteObjects(
			 Integer...id) {
		sysStaffSevice.doDeleteObjects(id);
		return new JsonResult("删除成功");
	 }
	 @RequestMapping("doUpdateObject")
		@ResponseBody
		public JsonResult doUpdateObject(SysStaff entity,Integer[]id) {
		 sysStaffSevice.updateObject(entity, id);
			return new JsonResult("修改成功");
		}
	 
	 /**用户添加*/
	 @RequestMapping("doSaveObject")
	@ResponseBody
	 public JsonResult tianjiaObject(SysStaff staff,Integer... roleIds ) {
		 sysStaffSevice.insertObject(staff,roleIds);
		return new JsonResult("添加成功");
		 
	 }
	 
	 @RequestMapping("doStaffUI")
	 public String tianjiaOb() {
		 return"sys/user_edit";
	 }
	
}
