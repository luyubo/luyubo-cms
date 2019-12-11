package com.luyubo.cms.service.impl;

import org.springframework.stereotype.Service;

import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean locked(Integer userId, int locked) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unLocked(Integer userId, int locked) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addScore(Integer userId, int score) {
		// TODO Auto-generated method stub
		return 0;
	}

}
