package com.yj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yj.sys.common.vo.RenterApOrderVo;
import com.yj.sys.common.vo.RenterOrderHistory;

@Mapper
public interface SysRenterApOrderDao {
	
	/**根据租客id(renter id)以及正在交易状态中的订单信息 
	 * 1) 即已预约租客订单信息
	 */
	/**查询所有租客信息*/
	List<RenterApOrderVo> doFindPageObjects(
			@Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**查询租客历史订单详情*/
	List<RenterOrderHistory> doFindPersonOrderHistoryById(
			@Param("id") Integer id,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	/**根据租客id查询历史订单数*/
	@Select("select count(*) rowCount from sys_aporder where renter_id = #{id}")
	Integer doGetOrderCountById(Integer id);
	/**根据租客id查询历史成功订单数*/
	@Select("select count(*) successRowCount from sys_aporder where renter_id = #{id} and status = '成交'")
	Integer doGetSuccessOrderCountById(Integer id);
}
