package cn.hur.shop.news.service;

import java.util.List;

import cn.hur.shop.news.dao.NewsDao;
import cn.hur.shop.news.vo.News;

/*
 * ��Ѷģ��ҵ���
 */
public class NewsService {

	//ע��NewsDao
	private NewsDao newsDao;

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	
	//ҵ����ѯ������Ѷ
	public List<News> findAll(){
		return newsDao.findAll();
	}
}
