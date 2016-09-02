package cn.hur.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import cn.hur.shop.cart.vo.Cart;
import cn.hur.shop.cart.vo.CartItem;
import cn.hur.shop.product.service.ProductService;
import cn.hur.shop.product.vo.Product;

import com.opensymphony.xwork2.ActionSupport;

/*
 * 购物车Action类
 */
public class CartAction extends ActionSupport{
	
	//接收pid
	private Integer pid;

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	//接收count
	private int count;

	public void setCount(int count) {
		this.count = count;
	}
	
	//接收color
	private String color;

	public void setColor(String color) {
		this.color = color;
	}
	
	//接收size
	private String size;

	public void setSize(String size) {
		this.size = size;
	}
	
	//注入ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//添加购物项到购物车的执行方法
	public String addCart(){
		//封装一个cartItem对象
		CartItem cartItem=new CartItem();
		//根据pid查询商品
		Product product=productService.findByPid(pid);
		//设置商品
		cartItem.setProduct(product);
		//设置数量
		cartItem.setCount(count);
		//设置颜色
		cartItem.setColor(color);
		//设置尺码
		cartItem.setSize(size);
		//将购物项添加到购物车（购物车需要存放在session中）
		Cart cart=getCart();
		cart.addCart(cartItem);
		return "addcart";
	}
	
	//从购物车中删除某购物项的执行方法
	public String removeCart(){
		//获得购物车对象
		Cart cart=getCart();
		//调用购物车中移除方法
		cart.removeCart(pid);
		return "removecart";
	}
	
	//清空购物车的执行方法
	public String clearCart(){
		//获得购物车对象
		Cart cart=getCart();
		//调用购物车中清空方法
		cart.clearCart();
		return "clearcart";
	}
	
	// 我的购物车的执行方法
	public String myCart(){
		return "mycart";
	}

	/*
	 * 获得购物车方法（从session中获取）
	 */
	private Cart getCart() {
		Cart cart=(Cart) ServletActionContext.getRequest().
				getSession().getAttribute("cart");
		if(cart == null){
			cart=new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	
}
