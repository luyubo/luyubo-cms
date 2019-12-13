package com.luyubo.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.UserService;

@Controller
@RequestMapping("/admin")
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public boolean login(User user) {
		boolean flag=userService.login(user);
		return flag;
	}
}
