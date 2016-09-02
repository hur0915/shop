package cn.hur.shop.utils;

import java.util.List;

/*
 * ��ҳ�Ĺ�����
 */
public class PageBean<T>{
	
	private int page;//��ǰҳ��
	private int totalCount;//�ܼ�¼��
	private int limit;//ÿҳ��ʾ��¼��
	private int totalPage;//��ҳ��
	private List<T> list;//ÿҳ��ʾ�����ݼ���
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

}
