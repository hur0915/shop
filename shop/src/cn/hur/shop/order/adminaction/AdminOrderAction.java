package cn.hur.shop.order.adminaction;

import java.util.List;

import cn.hur.shop.order.service.OrderService;
import cn.hur.shop.order.vo.Order;
import cn.hur.shop.order.vo.OrderItem;
import cn.hur.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 后台订单Action类
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{

	//用于接收数据的模型驱动
	private Order order=new Order();

	@Override
	public Order getModel() {
		return order;
	}
	
	//注入OrderService
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//接收page
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	//后台查询所有订单的执行方法
	public String findAll(){
		PageBean<Order> pageBean = orderService.findAll(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//后台修改订单状态的执行方法
	public String updateState(){
		//根据id查询订单
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(3);
		orderService.update(currOrder);
		//页面跳转
		return "updateStateSuccess";
	}
	
	//后台根据订单ID查询订单项的执行方法
	public String findOrderItem(){
		//根据订单id查询订单项
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOrderItem";
	}

}
