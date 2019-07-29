package com.yj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yj.sys.entity.SysAccount;

@Mapper
public interface SysAccountDao {
	List<SysAccount> doFindPageObjects();
}
