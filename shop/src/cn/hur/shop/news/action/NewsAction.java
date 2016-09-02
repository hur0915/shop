package cn.hur.shop.news.action;

import java.util.List;

import cn.hur.shop.news.service.NewsService;
import cn.hur.shop.news.vo.News;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * ��Ѷģ��Action��
 */
public class NewsAction extends ActionSupport implements ModelDriven<News>{

	//���ڽ������ݵ�ģ������
	private News news =new News();
	
	public News getModel() {
		return news;
	}
	
	//ע��NewsService
	private NewsService newsService;

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	
	//��ѯ������Ѷ��ִ�з���
	public String findAll(){
		List<News> neList=newsService.findAll();
		//������ֵջ��
		ActionContext.getContext().getValueStack().set("neList", neList);
		//ҳ����ת
		return "findAll";
	}
}
