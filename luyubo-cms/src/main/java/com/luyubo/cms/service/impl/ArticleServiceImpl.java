package com.luyubo.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luyubo.cms.dao.ArticleDao;
import com.luyubo.cms.dao.ChannelDao;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Channel;
import com.luyubo.cms.service.ArticleService;
/**
 * 文章service层
 * @author 77028
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ChannelDao channelDao;
	
	@Override
	public List<Channel> getChannelList() {
		// TODO Auto-generated method stub
		return channelDao.select(null);
	}

	@Override
	public boolean updateStatus(Integer id, Integer status) {
		// TODO Auto-generated method stub
		return articleDao.updateStatus(id,status)>0;
	}

	@Override
	public PageInfo<Article> getPageInfo(Article article, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Article> articleList = articleDao.select(article);
		return new PageInfo<Article>(articleList);
	}

	@Override
	public boolean addHot(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.addHot(id)>0;
	}

}
