package cn.hur.shop.news.action;

import java.util.List;

import cn.hur.shop.news.service.NewsService;
import cn.hur.shop.news.vo.News;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 资讯模块Action类
 */
public class NewsAction extends ActionSupport implements ModelDriven<News>{

	//用于接收数据的模型驱动
	private News news =new News();
	
	public News getModel() {
		return news;
	}
	
	//注入NewsService
	private NewsService newsService;

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	
	//查询所有资讯的执行方法
	public String findAll(){
		List<News> neList=newsService.findAll();
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("neList", neList);
		//页面跳转
		return "findAll";
	}
}
