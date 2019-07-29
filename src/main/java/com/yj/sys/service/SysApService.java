package com.yj.sys.service;

import com.yj.sys.common.vo.PageObject;
import com.yj.sys.common.vo.SysApVo;
import com.yj.sys.entity.SysAp;

public interface SysApService {
		int insertObject(SysAp entity,String path);
		PageObject<SysApVo> findPageObejct(String param,Integer pageCurrent);
		SysApVo findPageById(Integer id);
		int updateObject(SysAp entity, String picName);
		int doCount();
}
