package com.luyubo.cms.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * User控制器
 * @author 77028
 *
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {
	@RequestMapping("/")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "admin/home";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
	
	@RequestMapping("/settings")
	public String settings() {
		return "admin/settings";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "admin/welcome";
	}
	
	@RequestMapping("/article")
	public String article() {
		return "admin/article";
	}
}
