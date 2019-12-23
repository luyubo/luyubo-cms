package com.luyubo.cms.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luyubo.cms.dao.ArticleDao;
import com.luyubo.cms.dao.TousuDao;
import com.luyubo.cms.pojo.Article;
import com.luyubo.cms.pojo.Tousu;
import com.luyubo.cms.service.TousuService;

@Service
public class TousuServiceImpl implements TousuService {
	@Autowired
	private TousuDao tousuDao;
	@Autowired
	private ArticleDao articleDao;

	@Override
	public boolean add(Tousu tousu) {
		// TODO Auto-generated method stub
		tousu.setCreated(new Date());
		Article article = articleDao.selectById(tousu.getArticleId());
		System.out.println(article+"=================");
		int i=tousuDao.add(tousu);
		if(i>0) {
			i = articleDao.updateTousuCnt(article);
		}
		return i>0;
	}
}
