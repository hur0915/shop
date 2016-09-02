package cn.hur.shop.order.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.hur.shop.user.vo.User;

/*
 * 订单实体类
 */
public class Order {
	
	private Integer oid;//ID
	private Double total;//总金额
	private Date ordertime;//订单成交时间
	private String name;//收货人
	private String phone;//收货人号码
	private String addr;//收货人地址
	private Integer state;//订单状态   1:未付款   2:订单已经付款   3:已经发货   4:订单结束
	//所属用户.存的是用户的对象.
	private User user;
	//存放订单项的集合
	private Set<OrderItem> orderItems=new HashSet<OrderItem>();
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
