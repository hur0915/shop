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
 * 首页访问Action类
 */
public class IndexAction extends ActionSupport{
	
	//注入CategoryService
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//注入CarouselService
	private CarouselService carouselService;

	public void setCarouselService(CarouselService carouselService) {
		this.carouselService = carouselService;
	}
	
	//注入ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//访问首页的执行方法
	public String execute(){
		//查询广告
		List<Carousel> caList=carouselService.findAll();
		//将广告存入到Session
		ActionContext.getContext().getSession().put("caList", caList);
				
		//查询一级分类
		List<Category> cList=categoryService.findAll();
		// 将一级分类存入到Session
		ActionContext.getContext().getSession().put("cList", cList);
		
		//查询热门商品
		List<Product> hList=productService.findHot();
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("hList", hList);
		
		//查询最新商品
		List<Product> nList=productService.findNew();
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("nList", nList);
		
		return "index";
	}
	
}
