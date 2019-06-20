package com.yj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yj.sys.entity.SysAp;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("ap")
@Slf4j
public class SysApController {
	
	/** 请求新增公寓 */
	@RequestMapping("doShowApUI")
	public String doShowAP() {
		log.info("doShowApUI");
		return "sys/ap_edit";
	}
	
	/** 新增公寓 */
	@RequestMapping("doSaveObject")
	public String doSaveObject(@RequestParam("picture") MultipartFile file,SysAp entity) {
		log.info(entity.toString());
		log.info(file.getName());
		log.info(file.getOriginalFilename());
		log.info("doSaveObject");
		return "sys/index";
	}
	
	/** 请求公寓列表 */
	@RequestMapping("doApListUI")
	public String doApListUI() {
		
		return null;
	}
}
