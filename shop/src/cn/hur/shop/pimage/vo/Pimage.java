package cn.hur.shop.pimage.vo;

import cn.hur.shop.product.vo.Product;

/*
 * ��ƷͼƬģ��ʵ����
 */
public class Pimage {
	
	private Integer piid;//ID
	private String image;//ͼƬ
	//������Ʒ.��ŵ�����Ʒ�Ķ���.
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
