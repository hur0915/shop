package cn.hur.shop.pcolor.vo;

import cn.hur.shop.product.vo.Product;

/*
 * ��Ʒ��ɫģ��ʵ����
 */
public class Pcolor {
	
	private Integer pcid;//ID
	private String color;//��ɫ
	//������Ʒ.��ŵ�����Ʒ�Ķ���.
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
