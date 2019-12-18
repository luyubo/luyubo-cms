package com.luyubo.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Category;
import com.luyubo.cms.pojo.Channel;
import com.luyubo.cms.pojo.Slide;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.ArticleService;
import com.luyubo.cms.service.SlideService;
import com.luyubo.cms.service.UserService;

@Controller
public class IndexController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Autowired
	private SlideService slideService;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		return index(1,model);
	}
	
	@RequestMapping(value="/hot/{pageNum}.html")
	public String index(@PathVariable Integer pageNum,Model model) {
		//频道
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		//分类
		List<Slide> slideList=slideService.getAll();
		model.addAttribute("slideList", slideList);
		//热点文章
		if (pageNum==null) {
			pageNum=1;
		}
		PageInfo<Article> pageInfo=articleService.getHotList(pageNum);
		model.addAttribute("pageInfo", pageInfo);
		return "index";
	}
	
	@RequestMapping("/{channelId}/{cateId}/{pageNo}.html")
	public String channel(@PathVariable Integer channelId,@PathVariable Integer cateId,
			Model model,@PathVariable Integer pageNo) {
		//频道
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		//分类
		List<Category> cateList = articleService.getCateListByChannelId(channelId);
		model.addAttribute("cateList", cateList);
		//查询相关文章
		PageInfo<Article> pageInfo=articleService.getListByChannelIdAndCateId(channelId,cateId,pageNo);
		model.addAttribute("pageInfo",pageInfo);
		return "index";
	}
	
	@RequestMapping("article/{id}.html")
	public String articleDetail(@PathVariable Integer id,Model model) {
		//查询文章
		Article article = articleService.selectById(id);
		model.addAttribute("article", article);
		//查询用户
		User user=userService.getById(article.getUserId());
		model.addAttribute("user", user);
		//查询相关文章
		List<Article> articleList=articleService.getListByChannelId(article.getChannelId(),id,10);
		model.addAttribute("articleList", articleList);
		return "article/detail";
	}
}
