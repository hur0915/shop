package cn.hur.shop.order.vo;

import cn.hur.shop.product.vo.Product;

/*
 * ������ʵ����
 */
public class OrderItem {
	
	private Integer itemid;//ID
	private Integer count;//����
	private Double subtotal;//���
	//������Ʒ. ��ŵ�����Ʒ�Ķ���.
	private Product product;
	//��������. ��ŵ��Ƕ����Ķ���.
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
