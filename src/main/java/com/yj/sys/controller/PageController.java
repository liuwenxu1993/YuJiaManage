package com.yj.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
public class PageController {
	
	@RequestMapping("/doIndexUI")
	public String doStartUI() {
		return "starter";
	}
	
	@RequestMapping("doIndex")
	public String doIndexUI() {
		return "sys/index";
	}
	
	@RequestMapping("doLogout")
	public String doLogout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "sys/login";
	}
	
	@RequestMapping("/doLoginUI")
	public String doLogin() {
		return "sys/login";
	}
	
	
	@RequestMapping("doPageUI")
	public String doPageUI(){
		 return "common/page";
	 }
	
}
