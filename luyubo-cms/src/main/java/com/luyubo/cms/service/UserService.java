package com.luyubo.cms.service;

import com.luyubo.cms.pojo.User;

public interface UserService {
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	
	/**
	 * 根据名字查询用户
	 * @param username
	 * @return
	 */
	public User getByUsername(String username);
	
	/**
	 * 加锁
	 * @param userId
	 * @param locked
	 * @return
	 */
	boolean locked(Integer userId,int locked);
	
	/**
	 * 解锁
	 * @param userId
	 * @param locked
	 * @return
	 */
	boolean unLocked(Integer userId,int locked);
	
	/**
	 * 给用户添加积分,返回用户积分
	 * @param userId
	 * @param score
	 * @return
	 */
	int addScore(Integer userId,int score);
}
