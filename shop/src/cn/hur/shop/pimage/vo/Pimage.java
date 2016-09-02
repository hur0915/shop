package cn.hur.shop.pimage.vo;

import cn.hur.shop.product.vo.Product;

/*
 * 商品图片模块实体类
 */
public class Pimage {
	
	private Integer piid;//ID
	private String image;//图片
	//所属商品.存放的是商品的对象.
	private Product product;
	
	public Integer getPiid() {
		return piid;
	}
	public void setPiid(Integer piid) {
		this.piid = piid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
