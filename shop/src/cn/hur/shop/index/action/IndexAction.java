package cn.hur.shop.index.action;

import java.util.List;

import cn.hur.shop.carousel.service.CarouselService;
import cn.hur.shop.carousel.vo.Carousel;
import cn.hur.shop.category.service.CategoryService;
import cn.hur.shop.category.vo.Category;
import cn.hur.shop.categorysecond.service.CategorySecondService;
import cn.hur.shop.categorysecond.vo.CategorySecond;
import cn.hur.shop.product.service.ProductService;
import cn.hur.shop.product.vo.Product;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * ��ҳ����Action��
 */
public class IndexAction extends ActionSupport{
	
	//ע��CategoryService
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//ע��CarouselService
	private CarouselService carouselService;

	public void setCarouselService(CarouselService carouselService) {
		this.carouselService = carouselService;
	}
	
	//ע��ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//������ҳ��ִ�з���
	public String execute(){
		//��ѯ���
		List<Carousel> caList=carouselService.findAll();
		//�������뵽Session
		ActionContext.getContext().getSession().put("caList", caList);
				
		//��ѯһ������
		List<Category> cList=categoryService.findAll();
		// ��һ��������뵽Session
		ActionContext.getContext().getSession().put("cList", cList);
		
		//��ѯ������Ʒ
		List<Product> hList=productService.findHot();
		//������ֵջ��
		ActionContext.getContext().getValueStack().set("hList", hList);
		
		//��ѯ������Ʒ
		List<Product> nList=productService.findNew();
		//������ֵջ��
		ActionContext.getContext().getValueStack().set("nList", nList);
		
		return "index";
	}
	
}
