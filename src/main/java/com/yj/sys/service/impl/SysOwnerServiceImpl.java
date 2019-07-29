package com.yj.sys.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.yj.sys.common.exception.ServiceException;
import com.yj.sys.common.util.PageUtil;
import com.yj.sys.common.vo.OwnerCountInfo;
import com.yj.sys.common.vo.OwnerPersonAp;
import com.yj.sys.common.vo.OwnerPersonApVo;
import com.yj.sys.common.vo.OwnerVo;
import com.yj.sys.common.vo.PageObject;
import com.yj.sys.dao.SysOwnerDao;
import com.yj.sys.entity.SysOwner;
import com.yj.sys.service.SysOwnerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SysOwnerServiceImpl implements SysOwnerService{
	@Autowired
	private SysOwnerDao sysOwnerDao;
	/**查询业主信息及其公寓数量*/
	@Override
	public PageObject<?> doFindPageObjects(String name, Integer pageCurrent) {
		//1.参数校验
		if(pageCurrent==null || pageCurrent<1) {
			throw new IllegalArgumentException("页码错误!");
		}
		/**获取每页显示数目*/
		Integer  pageSize = 5;
		/**获取分页起始索引*/
		Integer startIndex = (pageCurrent-1) * pageSize;
		List<SysOwner> po = sysOwnerDao.doFindPageObjects(name, startIndex, pageSize);	
		if(po==null) {
			throw new ServiceException("无数据记录!");
		}
		log.info(po.toString());
		/**查询业主总数*/
		Integer rowCount = sysOwnerDao.getRowCounts(name);
		PageObject<SysOwner> rs = PageUtil.newPageObject(pageCurrent,po, rowCount);
		return rs;
	} 
	/**查询平台业主统计信息*/
	@Override
	public OwnerCountInfo doGetOwnerCountInfo() {
		/**查询平台公寓总数量*/
		Integer apCount= sysOwnerDao.doFindAllApNumber();
		/**查询平台业主数量*/
		Integer ownerCount = sysOwnerDao.doFindAllOwnerNumber();
		/**查询平台在租公寓数量*/
		Integer onRentApCount = sysOwnerDao.doFindOnRentApNumber();
		/**本月新增注册业主数量*/
		Integer riseOwnerNumber = sysOwnerDao.doFindRiseOwnerNumber();
		OwnerCountInfo po = new OwnerCountInfo(ownerCount, apCount, onRentApCount, riseOwnerNumber);
		return po;
	}

	/**根据手机号查询业主所有公寓详情*/
	@Override
	public PageObject<?> doFindApByOwnerId(String phone,Integer pageCurrent) {
		//1.参数校验
		if(pageCurrent==null || pageCurrent<1) {
			throw new IllegalArgumentException("页码错误!");
		}
		/**获取每页显示数目*/
		Integer  pageSize = 5;
		/**获取分页起始索引*/
		Integer startIndex = (pageCurrent-1) * pageSize;
		if(phone.length()!=11 || phone==null) {
			throw new ServiceException("无效租客id!");
		}
		List<OwnerPersonAp> rs = sysOwnerDao.doFindApByOwnerPhone(phone,startIndex,pageSize);
		log.info("pojo:"+rs.toString());
		Integer onRentApNumber = sysOwnerDao.doFindOnRentApNumberByOwnerPhone(phone);
		Integer apNumber = sysOwnerDao.doFindApNumberByOwnerPhone(phone);
		String ownerName = sysOwnerDao.doFindOwnerNameByPhone(phone);
		//if( po == null) {
		//	throw new ServiceException("无公寓信息");
		//}
		OwnerPersonApVo po = new OwnerPersonApVo(rs, onRentApNumber, apNumber,ownerName);
		LinkedList<OwnerPersonApVo> list = new LinkedList<>();
		list.add(po);
		return PageUtil.newPageObject(pageCurrent, list,apNumber);
	}

	/**根据公寓id删除公寓*/
	@Override
	public Integer doDeleteObject(Integer id) {
		if(id<1 || id==null) {
			throw new ServiceException("无效id!");
		}
		Integer rows = sysOwnerDao.doDeleteObject(id);
		if(rows == 0) {
			throw new ServiceException("删除失败!公寓可能不存在");
		}
		return rows;
	}

	/**删除业主及其名下公寓*/
	@Transactional
	@Override
	public Integer doDeleteOwnerAp(String phone) {
		if(phone.length()!=11 || phone==null) {
			throw new ServiceException("无效租客id!");
		}
		Integer row1 = sysOwnerDao.doDeleteOwner(phone);
		sysOwnerDao.doDeleteApByOwnerPhone(phone);
		if(row1<0) {
			throw new ServiceException("删除失败！可能业主不存在！");
		}
		return row1;
	}
	
	/** 通过数字模糊查找用户电话和姓名 */
	@Override
	public List<OwnerVo> findOwnerPhone(String phone) {
		if(phone==null) throw new ServiceException("请输入查询数字");
		List<OwnerVo> np=sysOwnerDao.findOwnerPhone(phone);
		if(np==null||StringUtils.isEmpty(np)) throw new ServiceException("查询结果为空");
		return np;
	}
}
