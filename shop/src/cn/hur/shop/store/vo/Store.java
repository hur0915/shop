package cn.hur.shop.store.vo;

import java.util.HashSet;
import java.util.Set;

import cn.hur.shop.product.vo.Product;

/*
 * ����ģ��ʵ����
 */
public class Store {
	
	private Integer sid;//ID
	private String sname;//����
	private String sdesc;//���
	private String slogo;//logo
	//�����Ʒ�ļ���
	private Set<Product> products=new HashSet<Product>();
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSdesc() {
		return sdesc;
	}
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	public String getSlogo() {
		return slogo;
	}
	public void setSlogo(String slogo) {
		this.slogo = slogo;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
