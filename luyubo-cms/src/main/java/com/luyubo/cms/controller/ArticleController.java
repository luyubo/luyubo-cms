package com.luyubo.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bawei.commons.utils.Md5Util;
import com.luyubo.cms.dao.ArticleDao;
import com.luyubo.cms.pojo.Article;

/**
 * 文章控制器
 * @author 77028
 *
 */
@Controller
@RequestMapping("/article/")
public class ArticleController {
	@Autowired
	private ArticleDao articleDao;
	
	/**
	 * 发布文章
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model) {
		Article article = articleDao.selectById(1);
		Md5Util.string2MD5("abc");
		model.addAttribute("article", null);
		
		return "article/add";
	}
	
	/**
	 * 修改文章
	 * @return
	 */
	@RequestMapping("update")
	public String update() {
		return "update";
	}
}
