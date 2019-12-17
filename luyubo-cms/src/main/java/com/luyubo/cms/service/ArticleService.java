package com.luyubo.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Category;
import com.luyubo.cms.pojo.Channel;

/**
 * 文章service层
 * @author 77028
 *
 */
public interface ArticleService {
	
	/**
	 * 查询频道列表
	 * @return
	 */
	List<Channel> getChannelList();

	/**
	 * 修改状态
	 * @param id
	 * @param status
	 * @return
	 */
	boolean updateStatus(Integer id, Integer status);

	/**
	 * 分页列表
	 * @param article
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Article> getPageInfo(Article article, Integer pageNum, Integer pageSize);

	/**
	 * 加热每次点击热度+1
	 * @param id
	 * @return
	 */
	boolean addHot(Integer id);

	/**
	 * 根据id查询分类列表
	 * @param channelId
	 * @return
	 */
	List<Category> getCateListByChannelId(Integer channelId);

	/**
	 * 根据id查询
	 * @param i
	 * @return
	 */
	Article selectById(int id);

	/**
	 * 保存到数据库
	 * @param article
	 * @return
	 */
	boolean save(Article article);


}
