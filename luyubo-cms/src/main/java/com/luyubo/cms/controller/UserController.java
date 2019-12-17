package com.luyubo.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.commons.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import com.luyubo.cms.common.CmsConstant;
import com.luyubo.cms.common.CmsMd5Util;
import com.luyubo.cms.common.JsonResult;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Channel;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.ArticleService;
import com.luyubo.cms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 用户登录界面
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public Object login() {
		return "/user/login";
	}
	
	/**
	 * 用户登录接口
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public Object login(User user,HttpSession session) {
		boolean blank = StringUtil.isBlank(user.getUsername());
		boolean blank1 = StringUtil.isBlank(user.getPassword());
		if(blank==false || blank1==false) {
			System.out.println("登录用户名和密码为空失败--------");
			return JsonResult.fail(1000, "用户名和密码不能为空");
		}
		//查询用户
		User userInfo = userService.getByUsername(user.getUsername());
		System.out.println(userInfo);
		//判断是否管理员
		if(userInfo==null) {
			return JsonResult.fail(1000, "用户名或密码错误");
		}

		//判断密码
		String string2md5 = CmsMd5Util.string2MD5(user.getPassword());
		if(string2md5.equals(userInfo.getPassword())) {
			session.setAttribute(CmsConstant.UserSessionKey, userInfo);
			return JsonResult.success();
		}
		return JsonResult.fail(1000, "未知错误");
	}
	
	/**
	 * 退出登录
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public Object logout(HttpServletResponse response,HttpSession session) {
		session.removeAttribute(CmsConstant.UserSessionKey);
		return "redirect:/";
	}
	
	/**
	 * @Title: register   
	 * @Description: 用户注册页面   
	 * @param: @return      
	 * @return: Object      
	 * @throws
	 */
	@RequestMapping(value="register",method=RequestMethod.GET)
	public Object register() {
		return "/user/register";
	}
	/**
	 * @Title: register   
	 * @Description: 用户注册接口   
	 * @param: @param user
	 * @param: @param session
	 * @param: @return      
	 * @return: Object      
	 * @throws
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public @ResponseBody Object register(User user,HttpSession session) {
		return JsonResult.fail(500, "未知错误");
	}
	
	
	@RequestMapping("center")
	public String center(HttpServletResponse response,HttpSession session) {
		return "user/center";
	}
	
	
	@RequestMapping("settings")
	public String settings(HttpServletResponse response,HttpSession session) {
		return "user/settings";
	}
	
	@RequestMapping("comment")
	public String comment(HttpServletResponse response,HttpSession session) {
		return "user/comment";
	}
	
	@RequestMapping("article")
	public String article(Article article,Model model,HttpSession session,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum,@RequestParam(value="pageSize",defaultValue="3") int pageSize) {
		//设置用户Id
		User userInfo = (User)session.getAttribute(CmsConstant.UserSessionKey);
		article.setUserId(userInfo.getId());
		//查询文章
		PageInfo<Article> pageInfo = articleService.getPageInfo(article,pageNum,pageSize);
		model.addAttribute("pageInfo", pageInfo);
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		return "user/article";
	}
}
