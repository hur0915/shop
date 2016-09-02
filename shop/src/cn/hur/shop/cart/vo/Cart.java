package cn.hur.shop.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 购物车对象
 */
public class Cart implements Serializable{
	
	//Map的key是商品pid,value是购物项.
	private Map<Integer,CartItem> map=new LinkedHashMap<Integer,CartItem>();//购物项集合
	private double total;//购物车总金额
	
	public double getTotal() {
		return total;
	}
	
	//Cart中有一个cartItems属性
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	/*
	 * 购物车功能
	 */
	//1.添加某购物项到购物车
	public void addCart(CartItem cartItem){
		//判断此购物项是否已经在购物车中
		  /*
		   * 如果存在
		   *    *数量增加
		   *    *总金额=总金额+购物项金额
		   * 如果不存在
		   *    *向map中添加购物项
		   *    *总金额增加=总金额+购物项金额
		   */
		//获得商品ID
		Integer pid=cartItem.getProduct().getPid();
		//根据商品ID判断购物车中是否存在购物项
		if(map.containsKey(pid)){
			//存在
			CartItem _cartItem=map.get(pid);//获得购物车中原来的购物项
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());//设置数量
		}else{
			//不存在
			map.put(pid, cartItem);
		}
		total+=cartItem.getSubtotal();//设置总金额	
	}
	
	//2.从购物车中删除某购物项
	public void removeCart(Integer pid){
		//将购物项从购物车中移除
		CartItem cartItem=map.remove(pid);
		//总金额=总金额-移除购物项的金额
		total-=cartItem.getSubtotal();	
	}
	
	//3.清空购物车
	public void clearCart(){
		//将购物项清空
		map.clear();
		//将总金额设置为0
		total=0;
	}
	
}
