package cn.hur.shop.query.action;

import com.opensymphony.xwork2.ActionSupport;

/*
 * 查询访问Action类
 */
public class QueryFlowAction extends ActionSupport{
	
	//查询注册流程的执行方法
	public String execute(){
		return "brandRegistFlow";
	}
	
}
