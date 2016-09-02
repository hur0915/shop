package cn.hur.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import cn.hur.shop.cart.vo.Cart;
import cn.hur.shop.cart.vo.CartItem;
import cn.hur.shop.product.service.ProductService;
import cn.hur.shop.product.vo.Product;

import com.opensymphony.xwork2.ActionSupport;

/*
 * ���ﳵAction��
 */
public class CartAction extends ActionSupport{
	
	//����pid
	private Integer pid;

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	//����count
	private int count;

	public void setCount(int count) {
		this.count = count;
	}
	
	//����color
	private String color;

	public void setColor(String color) {
		this.color = color;
	}
	
	//����size
	private String size;

	public void setSize(String size) {
		this.size = size;
	}
	
	//ע��ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//��ӹ�������ﳵ��ִ�з���
	public String addCart(){
		//��װһ��cartItem����
		CartItem cartItem=new CartItem();
		//����pid��ѯ��Ʒ
		Product product=productService.findByPid(pid);
		//������Ʒ
		cartItem.setProduct(product);
		//��������
		cartItem.setCount(count);
		//������ɫ
		cartItem.setColor(color);
		//���ó���
		cartItem.setSize(size);
		//����������ӵ����ﳵ�����ﳵ��Ҫ�����session�У�
		Cart cart=getCart();
		cart.addCart(cartItem);
		return "addcart";
	}
	
	//�ӹ��ﳵ��ɾ��ĳ�������ִ�з���
	public String removeCart(){
		//��ù��ﳵ����
		Cart cart=getCart();
		//���ù��ﳵ���Ƴ�����
		cart.removeCart(pid);
		return "removecart";
	}
	
	//��չ��ﳵ��ִ�з���
	public String clearCart(){
		//��ù��ﳵ����
		Cart cart=getCart();
		//���ù��ﳵ����շ���
		cart.clearCart();
		return "clearcart";
	}
	
	// �ҵĹ��ﳵ��ִ�з���
	public String myCart(){
		return "mycart";
	}

	/*
	 * ��ù��ﳵ��������session�л�ȡ��
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
