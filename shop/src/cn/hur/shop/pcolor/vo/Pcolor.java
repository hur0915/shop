package cn.hur.shop.pcolor.vo;

import cn.hur.shop.product.vo.Product;

/*
 * 商品颜色模块实体类
 */
public class Pcolor {
	
	private Integer pcid;//ID
	private String color;//颜色
	//所属商品.存放的是商品的对象.
	private Product product;
	
	public Integer getPcid() {
		return pcid;
	}
	public void setPcid(Integer pcid) {
		this.pcid = pcid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
