package cn.hur.shop.psize.vo;

import cn.hur.shop.product.vo.Product;

/*
 * ��Ʒ����ģ��ʵ����
 */
public class Psize {
	
	private Integer psid;//ID
	private String size;//����
	//������Ʒ.��ŵ�����Ʒ�Ķ���.
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
