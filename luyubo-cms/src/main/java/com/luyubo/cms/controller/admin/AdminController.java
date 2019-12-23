package com.luyubo.cms.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.luyubo.cms.common.JsonResult;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Channel;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.ArticleService;
import com.luyubo.cms.service.UserService;
/**
 * User控制器
 * @author 77028
 *
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "admin/home";
	}
	
	/**
	 * 后台管理首页
	 * @param user
	 * @param m
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/user")
	public String user(User user,Model m,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
					@RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize) {
			PageInfo<User> pageInfo=userService.getPageInfo(user,pageNum,pageSize);
			m.addAttribute("pageInfo", pageInfo);
		return "admin/user";
	}
	
	/**
	 * 启用状态
	 * @param userId
	 * @return
	 */
	@RequestMapping("/user/locked")
	@ResponseBody
	public boolean locked(Integer userId) {
		boolean locked=userService.locked(userId);
		return locked;
	}
	
	/**
	 * 禁用状态
	 * @param userId
	 * @return
	 */
	@RequestMapping("/user/unLocked")
	@ResponseBody
	public boolean unLocked(Integer userId) {
		boolean locked=userService.unLocked(userId);
		return locked;
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "admin/welcome";
	}
	
	/**
	 * 文章管理
	 * @param article
	 * @param m
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/article")
	public String article(Article article,Model m,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
			@RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize) {
		PageInfo<Article> pageInfo=articleService.getPageInfo(article,pageNum,pageSize);
		m.addAttribute("pageInfo", pageInfo);
		List<Channel> channelList = articleService.getChannelList();
		m.addAttribute("channelList", channelList);
		return "admin/article";
	}
	
	/**
	 * 修改文章状态
	 * @param article
	 * @return
	 */
	@RequestMapping("/article/update/status")
	@ResponseBody
	public boolean updateArticleStatus(Article article) {
		return articleService.updateStatus(article.getId(),article.getStatus());
	}
	
	/**
	 * 文章加热
	 * @param article
	 * @return
	 */
	@RequestMapping("/article/addHot")
	@ResponseBody
	public boolean addHot(Article article) {
		return articleService.addHot(article.getId());
	}
	
	/**
	 * 修改文章状态为禁用
	 * @param article
	 * @return
	 */
	@RequestMapping("/article/update/status3")
	@ResponseBody
	public JsonResult updateArticleStatus3(Integer id) {
		System.out.println(id+"====================");
		boolean flag = articleService.updateStatus3(id);
		System.out.println(flag);
		if (flag) {
			return JsonResult.success();
		}
		return JsonResult.fail(5000, "修改失败");
	}
}
