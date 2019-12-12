package com.luyubo.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章控制器
 * @author 77028
 *
 */
@Controller
@RequestMapping("/article/")
public class ArticleController {
	/**
	 * 发布文章
	 * @return
	 */
	@RequestMapping("add")
	public String add() {
		return "article/add";
	}
	
	/**
	 * 修改文章
	 * @return
	 */
	@RequestMapping("update")
	public String update() {
		return "article/update";
	}
}
