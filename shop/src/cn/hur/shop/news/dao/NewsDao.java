package cn.hur.shop.news.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.news.vo.News;


/*
 * 资讯模块持久层
 */
public class NewsDao extends HibernateDaoSupport{
	
	//查询所有资讯
	public List<News> findAll(){
		String hql="from News";
		List<News> list=this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;	
	}

}
