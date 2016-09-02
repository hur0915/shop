package cn.hur.shop.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * ���ﳵ����
 */
public class Cart implements Serializable{
	
	//Map��key����Ʒpid,value�ǹ�����.
	private Map<Integer,CartItem> map=new LinkedHashMap<Integer,CartItem>();//�������
	private double total;//���ﳵ�ܽ��
	
	public double getTotal() {
		return total;
	}
	
	//Cart����һ��cartItems����
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	/*
	 * ���ﳵ����
	 */
	//1.���ĳ��������ﳵ
	public void addCart(CartItem cartItem){
		//�жϴ˹������Ƿ��Ѿ��ڹ��ﳵ��
		  /*
		   * �������
		   *    *��������
		   *    *�ܽ��=�ܽ��+��������
		   * ���������
		   *    *��map����ӹ�����
		   *    *�ܽ������=�ܽ��+��������
		   */
		//�����ƷID
		Integer pid=cartItem.getProduct().getPid();
		//������ƷID�жϹ��ﳵ���Ƿ���ڹ�����
		if(map.containsKey(pid)){
			//����
			CartItem _cartItem=map.get(pid);//��ù��ﳵ��ԭ���Ĺ�����
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());//��������
		}else{
			//������
			map.put(pid, cartItem);
		}
		total+=cartItem.getSubtotal();//�����ܽ��	
	}
	
	//2.�ӹ��ﳵ��ɾ��ĳ������
	public void removeCart(Integer pid){
		//��������ӹ��ﳵ���Ƴ�
		CartItem cartItem=map.remove(pid);
		//�ܽ��=�ܽ��-�Ƴ�������Ľ��
		total-=cartItem.getSubtotal();	
	}
	
	//3.��չ��ﳵ
	public void clearCart(){
		//�����������
		map.clear();
		//���ܽ������Ϊ0
		total=0;
	}
	
}
