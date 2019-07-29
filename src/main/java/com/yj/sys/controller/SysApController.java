package com.yj.sys.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.common.util.UploadUtil;
import com.yj.sys.common.vo.JsonResult;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.common.vo.SysApVo;
import com.yj.sys.entity.SysAp;
import com.yj.sys.service.SysApService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("ap")
@Slf4j
public class SysApController {
	
	private HashMap<String,SysApVo> map = new HashMap<>();
	
	@Autowired
	SysApService service;
	
	/** 首页请求公寓数量统计 */
	@RequestMapping("doCount")
	@ResponseBody
	public JsonResult doCount() {
		return new JsonResult(service.doCount());
	}
	
	/** 请求新增公寓 */
	@RequestMapping("doShowApUI")
	public String doShowAP() {
		log.info("doShowApUI");
		return "sys/ap_edit";
	}
	
	/** 新增公寓 
	 * @throws IOException 
	 * @throws IllegalStateException */
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(@RequestParam("picture") MultipartFile file,SysAp entity,HttpServletRequest request) throws IllegalStateException, IOException {
		if(file.isEmpty()) throw new ServiceException("图片传输异常");
		log.info("图片大小"+file.getSize());
		String uid = UUID.randomUUID().toString().replace("-","");
		String picName =uid+file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
		service.insertObject(entity,picName);
		//获取图片保存地址
		File filedir = UploadUtil.getImgDirFile();
		log.info(filedir.getAbsolutePath());
		File picDir = new File(filedir.getAbsolutePath()+"/"+picName);
		//保存图片
		try {
			//file.transferTo(picDir); 这是简单方法
			InputStream in = file.getInputStream();
			FileOutputStream out = new FileOutputStream(picDir);
			byte[] b = new byte[8192];
			while(in.read(b)!=-1) {
				out.write(b);
			}
			out.flush();
			out.close();
		}catch (Exception e) {
			throw new ServiceException("图片上传异常,请重试");
		}
		return new JsonResult("添加公寓成功");
	}
	
	/** 请求公寓列表 */
	@RequestMapping("doApListUI")
	public String doApListUI() {
		return "sys/ap_list";
	}
	
	/** 请求公寓列表数据 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String search,Integer pageCurrent) {
		log.info("search:"+search+" pageCurrent:"+pageCurrent);
		PageObject<SysApVo> po = service.findPageObejct(search,pageCurrent);
		log.info(po.toString());
		return new JsonResult(po);
	}
	
	/** 查看公寓 */
	@RequestMapping("doFindApById")
	public String doFindApById(Integer id) {
		//1.参数校验
		if(id==null||StringUtils.isEmpty(id)) throw new ServiceException("id参数不正确");
		//2.执行查询
		SysApVo vo = service.findPageById(id);
		//3.结果校验
		if(vo==null||StringUtils.isEmpty(vo)) throw new ServiceException("公寓记录不存在");
		//暂时将值放入map中
		map.put("ap",vo);
		return "sys/ap_content";
	}
	
	@RequestMapping("doGetAp")
	@ResponseBody
	public JsonResult getApData() {
		SysApVo vo = map.remove("ap");
		return new JsonResult(vo);
	}
	
	/** 查看需要修改的公寓  */
	@RequestMapping("doFindPageById")
	@ResponseBody
	public JsonResult doFindPageById(Integer id) {
		//1.参数校验
		if(id==null||StringUtils.isEmpty(id)) throw new ServiceException("id参数不正确");
		SysApVo vo = service.findPageById(id);
		return new JsonResult(vo);
	}
	
	/** 保存修改的公寓数据 */
	@RequestMapping("doSaveUpdateObject")
	@ResponseBody
	public JsonResult doSaveUpdateObject(@RequestParam("picture") MultipartFile file,SysAp entity,HttpServletRequest request) {
		String picName = null;
		if(!file.isEmpty()) {
			log.info("图片大小"+file.getSize());
			String uid = UUID.randomUUID().toString().replace("-","");
			picName =uid+file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
			//获取图片保存地址
			File filedir = UploadUtil.getImgDirFile();
			log.info(filedir.getAbsolutePath());
			File picDir = new File(filedir.getAbsolutePath()+"/"+picName);
			//保存图片
			try {
				file.transferTo(picDir);
			}catch (Exception e) {
				throw new ServiceException("图片上传异常,请重试");
			}
		}
		service.updateObject(entity,picName);
		return new JsonResult("修改公寓成功");
	}
	
	
}
