package com.yj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PageController {
	
	@RequestMapping("/")
	public String doStartUI() {
		log.info("starter");
		return "starter";
	}
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		log.info("doIndexUI");
		return "sys/index";
	}
	
	@RequestMapping("doLogout")
	public String doLogout() {
		return "sys/login";
	}
}
