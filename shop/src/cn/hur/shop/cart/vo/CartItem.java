package cn.hur.shop.cart.vo;

import cn.hur.shop.product.vo.Product;

/*
 * ���������
 */
public class CartItem {
	
	private Product product;//��Ʒ��Ϣ
	private int count;//����
	private double subtotal;//���
	private String color;//��ɫ
	private String size;//����
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	//����Զ�����
	public double getSubtotal() {
		return count * product.getPrice();
	}	

}
