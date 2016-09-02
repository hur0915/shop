package cn.hur.shop.order.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.hur.shop.cart.vo.Cart;
import cn.hur.shop.cart.vo.CartItem;
import cn.hur.shop.order.service.OrderService;
import cn.hur.shop.order.vo.Order;
import cn.hur.shop.order.vo.OrderItem;
import cn.hur.shop.user.vo.User;
import cn.hur.shop.utils.PageBean;
import cn.hur.shop.utils.PaymentUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 订单Action类
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	
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
	
	//接收支付通道编码
	private String pd_FrpId;

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	
	//接收付款成功后的参数
	private String r3_Amt;
	private String r6_Order;
	
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	//生成订单的执行方法
	public String saveOrder(){
		//从session中获取购物车信息
		Cart cart=(Cart) ServletActionContext.getRequest().
				getSession().getAttribute("cart");
		if(cart == null){
			this.addActionMessage("亲，您还没有购物！");
			return "msg";
		}
		//设置总金额
		order.setTotal(cart.getTotal());
		//设置订单成交时间
		order.setOrdertime(new Date());	
		//设置状态（未付款）
		order.setState(1);
		//设置用户
		User existUser=(User) ServletActionContext.getRequest().
				getSession().getAttribute("existUser");
		if(existUser == null){
			this.addActionMessage("亲，您还没有登录！");
			return "login";
		}
		order.setUser(existUser);
		//设置订单项集合
		for(CartItem cartItem:cart.getCartItems()){
			OrderItem orderItem=new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			
			order.getOrderItems().add(orderItem);	
		}
		orderService.save(order);
		//清空购物车
		cart.clearCart();
		return "saveorder";		
	}
	
	//查询我的订单的执行方法
	public String findByUid(){
		//获取存在session中的用户
		User existUser=(User) ServletActionContext.getRequest().
				getSession().getAttribute("existUser");
		PageBean<Order> pageBean=orderService.findByUid(existUser.getUid(), page);
		//保存于值栈中，用于页面的显示
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findbyuid";
	}
	
	//根据订单ID查询订单的执行方法
	public String findByOid(){
		order=orderService.findByOid(order.getOid());
		return "findbyoid";
	}
	
	//为订单付款的执行方法
	public String payOrder() throws IOException {
		//1.修改数据
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setAddr(order.getAddr());
		currOrder.setName(order.getName());
		currOrder.setPhone(order.getPhone());
		//修改订单
		orderService.update(currOrder);
		
		//2.完成付款
		//付款需要的参数
		String p0_Cmd = "Buy";//业务类型
		String p1_MerId = "10001126856";//商户编号
		String p2_Order = order.getOid().toString();//订单编号
		String p3_Amt = "0.01";//付款金额
		String p4_Cur = "CNY";//交易币种
		String p5_Pid = "";//商品名称
		String p6_Pcat = "";//商品种类
		String p7_Pdesc = "";//商品描述
		String p8_Url = "http://192.168.0.100:8080/shop/order_callBack.action";//商户接收支付成功数据的地址
		String p9_SAF = "";//送货地址
		String pa_MP = "";//商户扩展信息
		String pd_FrpId = this.pd_FrpId;//支付通道编码
		String pr_NeedResponse = "1";//应答机制
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";//秘钥
		String hmac = PaymentUtils.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); //hmac
		//向易宝发送请求
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		// 重定向:向易宝出发
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}
	
	//付款成功后跳转回来的执行方法
	public String callBack(){
		//修改订单的状态
		Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		//修改订单状态为2:已经付款
		currOrder.setState(2);
		orderService.update(currOrder);
		this.addActionMessage("支付成功!订单编号为: "+r6_Order +" 付款金额为: "+r3_Amt);
		return "msg";
	}

}
