package com.yj.sys.service.impl;


import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.common.util.PageUtil;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.common.vo.RenterApOrderVo;
import com.yj.sys.common.vo.RenterCountInfo;
import com.yj.sys.common.vo.RenterOrderHistory;
import com.yj.sys.common.vo.RenterOrderHistoryVo;
import com.yj.sys.dao.SysRenterApOrderDao;
import com.yj.sys.dao.SysRenterDao;
import com.yj.sys.service.SysRenterService;

@Service
public class SysRenterServiceImpl implements SysRenterService{
	@Autowired
	private SysRenterApOrderDao sysRenterApOrderDao;
	@Autowired
	private SysRenterDao sysRenterDao;
	
	/** 统计租客数量 */ 
	@Override
	public int doCount() {
		return sysRenterDao.getRowCounts(null);
	}
	
	/**查询所有租客信息(含预约信息)*/
	@Override
	public PageObject<?> doFindPageObjects(String name, Integer pageCurrent) {
		//1.参数校验
		if(pageCurrent==null || pageCurrent<1) {
			throw new IllegalArgumentException("页码错误!");
		}
		/**获取每页显示数目*/
		Integer  pageSize =5;
		/**获取分页起始索引*/
		Integer startIndex = (pageCurrent-1) * pageSize;
		List<RenterApOrderVo> po = sysRenterApOrderDao.doFindPageObjects(name, startIndex, pageSize);
		//2.查询记录总数并进行校验
		int rowCount = sysRenterDao.getRowCounts(name);
		if(rowCount == 0) {
			throw new ServiceException("记录不存在");
		}
		/**封装结果并返回*/
		PageObject<RenterApOrderVo> rs = 
				PageUtil.newPageObject(pageCurrent , po,rowCount);
		//log.info(rs.getRecords().toString());
		return rs;
	} 

	/**查询平台租客统计信息 1*/
	@Override
	public RenterCountInfo doGetRenterCountInfo() {
		/**查询平台租客总量*/
		Integer allRenterNumber = sysRenterDao.doFindAllRenterNumber();
		/**查询在租租客数量*/
		Integer onRenterNumber = sysRenterDao.doFindOnRenterNumber();
		/**查询预约订单数量*/
		Integer orderRenterNumber = sysRenterDao.doFindOrderRenterNumber();
		/**查询本月新注册租客数量*/
		Integer riseRenterNumber = sysRenterDao.doFindRiseRenterNumber();
		System.out.println("Onrenter:"+onRenterNumber);
		return new RenterCountInfo(allRenterNumber, onRenterNumber,orderRenterNumber,riseRenterNumber);
	}

	/**查询租客历史订单详情
	 * @return */
	@Override
	public PageObject<?> doFindPersonOrderHistoryById(Integer id,Integer pageCurrent) {
		//1.参数校验
		if(pageCurrent==null || pageCurrent<1) {
			throw new IllegalArgumentException("页码错误!");
		}
		/**获取每页显示数目*/
		Integer  pageSize = PageUtil.pageSize*0+3;
		/**获取分页起始索引*/
		Integer startIndex = (pageCurrent-1) * pageSize;
		if(id<1 || id==null) {
			throw new ServiceException("无效租客id!");
		}
		/**查询历史订单详情*/
		List<RenterOrderHistory> po = sysRenterApOrderDao.doFindPersonOrderHistoryById(id,startIndex, pageSize);
		if(po==null) {
			throw new ServiceException("无历史订单信息!");
		}
		/**根据id查询订单数量*/
		Integer rowCount = sysRenterApOrderDao.doGetOrderCountById(id);
		if(rowCount==0) {
			throw new ServiceException("无历史订单信息!");
		}
		/**根据id查询成交订单数量*/
		Integer successOrderCount = sysRenterApOrderDao.doGetSuccessOrderCountById(id);
		/**封装结果集并返回*/
		RenterOrderHistoryVo vo = new RenterOrderHistoryVo();
		vo.setOrderInfo(po);
		vo.setOrderCount(rowCount);
		vo.setSuccessOrderCount(successOrderCount);
		LinkedList<RenterOrderHistoryVo> list = new LinkedList<>();
		list.add(vo);
		return PageUtil.newPageObject(pageCurrent, list, rowCount);
	}
}
