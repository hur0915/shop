package cn.hur.shop.order.vo;

import cn.hur.shop.product.vo.Product;

/*
 * 订单项实体类
 */
public class OrderItem {
	
	private Integer itemid;//ID
	private Integer count;//数量
	private Double subtotal;//金额
	//所属商品. 存放的是商品的对象.
	private Product product;
	//所属订单. 存放的是订单的对象.
	private Order order;
	
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
