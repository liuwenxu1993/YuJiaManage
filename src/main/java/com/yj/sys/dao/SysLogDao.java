package com.yj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yj.sys.entity.SysLog;


/*添加了@Mapper注解之后这个接口在编译时会生成相应的实现类*/
@Mapper
public interface SysLogDao {
	
	/**按条件查询总记录数
	 * @param username 查询条件
	 * */
	
	/**
	 * 基于条件执行枫叶查询，获取当前页记录
	 * @param username 查询条件
	 * @param startIndex 起始位置
	 * @param pageSize 页面大小（每个页面显示多少条数据）
	 * @return
	 */
	List<SysLog> findPageObjects(
			@Param("username")String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	
	/*简单sql语句*/
	@Delete("delete from sys_logs where id=#{id}")
	int DeleteObjectById(Integer id);
	
	/* 复杂sql建议将sql写到xml
	 * 基于传入的id值执行动态删除（可能多个）操作*/
	int deleteObjects(@Param("ids")Integer... ids);
	
	/**
     * 对于多个参数来说，每个参数之前都要加上@Param注解，
     * 要不然会找不到对应的参数进而报错
     */
//   public User login(@Param("name")String name, @Param("pwd")String pwd);
	
	
	int getRowCount(@Param("username") String username);


	int insertObject(SysLog log);
	
	
}
