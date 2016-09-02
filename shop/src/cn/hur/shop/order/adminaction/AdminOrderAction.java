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
 * ��̨����Action��
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{

	//���ڽ������ݵ�ģ������
	private Order order=new Order();

	@Override
	public Order getModel() {
		return order;
	}
	
	//ע��OrderService
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//����page
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	//��̨��ѯ���ж�����ִ�з���
	public String findAll(){
		PageBean<Order> pageBean = orderService.findAll(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//��̨�޸Ķ���״̬��ִ�з���
	public String updateState(){
		//����id��ѯ����
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(3);
		orderService.update(currOrder);
		//ҳ����ת
		return "updateStateSuccess";
	}
	
	//��̨���ݶ���ID��ѯ�������ִ�з���
	public String findOrderItem(){
		//���ݶ���id��ѯ������
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOrderItem";
	}

}
