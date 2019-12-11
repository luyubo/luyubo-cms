package com.luyubo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luyubo.cms.pojo.User;

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
	int insert(@Param("user") User user);
	int update(@Param("user") User user);
	int deleteById(@Param("id") Integer id);
	int deleteByIds(@Param("ids") String ids);
}
