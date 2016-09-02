package cn.hur.shop.product.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.hur.shop.categorysecond.vo.CategorySecond;
import cn.hur.shop.pcolor.vo.Pcolor;
import cn.hur.shop.pimage.vo.Pimage;
import cn.hur.shop.psize.vo.Psize;
import cn.hur.shop.store.vo.Store;
import cn.hur.shop.utils.PageBean;

/*
 * ��Ʒģ��ʵ����
 */
public class Product {
	
	private Integer pid;//ID
	private String pname;//����
	private Double price;//�۸�
	private String img;//ͼƬ
	private String preco;//�Ƽ�����
	private String pdesc;//����
	private Integer is_reco;//�Ƿ��Ƽ�      0:�����Ƽ���Ʒ. 1:�����Ƽ���Ʒ.
	private Integer is_hot;//�Ƿ�����      0:����������Ʒ. 1:����������Ʒ.
	private Date date;//�ϴ�ʱ��
	//������������.��ŵ��Ƕ�������Ķ���.
	private CategorySecond categorySecond;
	//��������.��ŵ��ǵ��̵Ķ���.
	private Store store;
	//�����ƷͼƬ�ļ���
	private Set<Pimage> pimages=new HashSet<Pimage>();
	//�����Ʒ��ɫ�ļ���
	private Set<Pcolor> pcolors=new HashSet<Pcolor>();
	//�����Ʒ����ļ���
	private Set<Psize> psizes=new HashSet<Psize>();
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getIs_reco() {
		return is_reco;
	}
	public void setIs_reco(Integer is_reco) {
		this.is_reco = is_reco;
	}
	public Integer getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public CategorySecond getCategorySecond() {
		return categorySecond;
	}
	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Set<Pimage> getPimages() {
		return pimages;
	}
	public void setPimages(Set<Pimage> pimages) {
		this.pimages = pimages;
	}
	public Set<Pcolor> getPcolors() {
		return pcolors;
	}
	public void setPcolors(Set<Pcolor> pcolors) {
		this.pcolors = pcolors;
	}
	public Set<Psize> getPsizes() {
		return psizes;
	}
	public void setPsizes(Set<Psize> psizes) {
		this.psizes = psizes;
	}
	
}
