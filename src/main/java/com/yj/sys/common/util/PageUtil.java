package com.yj.sys.common.util;

import java.util.List;

import com.yj.sys.common.vo.PageObject;
import com.yj.sys.common.vo.SysApVo;

public class PageUtil {
	public static Integer pageSize = 5;//每页最多显示10条
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static ThreadLocal<PageObject> pageObject = new ThreadLocal() {
		protected PageObject initialValue() {
			return new com.yj.sys.common.vo.PageObject();
		};
	};
	
	public static <T>PageObject<T> pageUtil(Integer pageCurrent, int rowCount, int pageSize, List<T> records) {
		PageObject<T> po = new PageObject<>();
		po.setRowCount(rowCount);
		po.setRecords(records);
		po.setPageSize(pageSize);
		po.setPageCount((rowCount-1)/pageSize+1);
		po.setPageCurrent(pageCurrent);
		return po;
	}
	
	public static  <T>PageObject<T> newPageObject(
			Integer pageCurrent,List<T> records,Integer rowCount) {
		@SuppressWarnings("unchecked")
		PageObject<T> po = pageObject.get();
		
		Integer pageCount = (rowCount-1)/pageSize+1;	//总页数
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		po.setPageCount(pageCount);
		po.setRowCount(rowCount);
		po.setRecords(records);
		return po;
	}
	public static Integer getStartIndex(Integer pageCurrent) {
		return (pageCurrent-1)*pageSize;
	}
	
}
