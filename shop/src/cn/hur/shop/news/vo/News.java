package cn.hur.shop.news.vo;

import java.util.Date;

/*
 * ��Ѷģ��ʵ����
 */
public class News {

	private Integer nid;//ID
	private String title;//����
	private Date time;//ʱ��
	private String content;//����
	
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
