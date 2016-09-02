package cn.hur.shop.cart.vo;

import cn.hur.shop.product.vo.Product;

/*
 * 购物项对象
 */
public class CartItem {
	
	private Product product;//商品信息
	private int count;//数量
	private double subtotal;//金额
	private String color;//颜色
	private String size;//尺码
	
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
	//金额自动计算
	public double getSubtotal() {
		return count * product.getPrice();
	}	

}
