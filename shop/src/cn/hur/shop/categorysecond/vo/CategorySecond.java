package cn.hur.shop.categorysecond.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.hur.shop.category.vo.Category;
import cn.hur.shop.product.vo.Product;

/*
 * 二级分类模块实体类
 */
public class CategorySecond implements Serializable{
	
	private Integer csid;
	private String csname;
	//所属一级分类.存的是一级分类的对象.
	private Category category;
	//存放商品的集合
	private Set<Product> products=new HashSet<Product>();
	
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
