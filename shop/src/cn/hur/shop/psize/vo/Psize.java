package cn.hur.shop.psize.vo;

import cn.hur.shop.product.vo.Product;

/*
 * 商品尺码模块实体类
 */
public class Psize {
	
	private Integer psid;//ID
	private String size;//尺码
	//所属商品.存放的是商品的对象.
	private Product product;
	
	public Integer getPsid() {
		return psid;
	}
	public void setPsid(Integer psid) {
		this.psid = psid;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
