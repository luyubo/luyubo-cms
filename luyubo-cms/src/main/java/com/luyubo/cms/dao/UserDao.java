package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.User;
/**
 * 用户表Dao层接口
 * @author 77028
 *
 */
public interface UserDao {
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	User selectById(@Param("id") Integer id);
	/**
	 * 查询user集合
	 * @param user
	 * @return
	 */
	List<User> select(@Param("user") User user);
	/**
	 * 查询多少条
	 * @param user
	 * @return
	 */
	int count(@Param("user") User user);
	
	/**
	 * 插入一条记录
	 * @param user
	 * @return
	 */
	int insert(@Param("user") User user);
	
	/**
	 * 根据id更新记录
	 * @param user
	 * @return
	 */
	int update(@Param("user") User user);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	int deleteById(@Param("id") Integer id);
	
	/**
	 *根据id集合删除 
	 * @param ids
	 * @return
	 */
	int deleteByIds(@Param("ids") String ids);
}
