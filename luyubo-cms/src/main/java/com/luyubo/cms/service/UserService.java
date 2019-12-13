package com.luyubo.cms.service;

import com.github.pagehelper.PageInfo;
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
	 * @return
	 */
	boolean locked(Integer userId);
	
	/**
	 * 解锁
	 * @param userId
	 * @return
	 */
	boolean unLocked(Integer userId);
	
	/**
	 * 给用户添加积分,返回用户积分
	 * @param userId
	 * @param score
	 * @return
	 */
	int addScore(Integer userId,int score);

	/**
	 * 查询分页
	 * @param user
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<User> getPageInfo(User user, Integer pageNum, Integer pageSize);

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public boolean login(User user);
	
	
}
