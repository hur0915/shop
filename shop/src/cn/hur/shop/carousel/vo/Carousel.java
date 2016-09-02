package cn.hur.shop.carousel.vo;

import java.io.Serializable;
import java.util.Date;

/*
 * 首页广告模块实体类
 */
public class Carousel implements Serializable{
	
	private Integer caid;//ID
	private String image;//图片
	private String title;//标题
	private String subtitle;//副标题
	private Date cadate;//发布日期
	
	public Integer getCaid() {
		return caid;
	}
	public void setCaid(Integer caid) {
		this.caid = caid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public Date getCadate() {
		return cadate;
	}
	public void setCadate(Date cadate) {
		this.cadate = cadate;
	}

}
