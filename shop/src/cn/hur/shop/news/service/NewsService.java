package cn.hur.shop.news.service;

import java.util.List;

import cn.hur.shop.news.dao.NewsDao;
import cn.hur.shop.news.vo.News;

/*
 * 资讯模块业务层
 */
public class NewsService {

	//注入NewsDao
	private NewsDao newsDao;

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	
	//业务层查询所有资讯
	public List<News> findAll(){
		return newsDao.findAll();
	}
}
