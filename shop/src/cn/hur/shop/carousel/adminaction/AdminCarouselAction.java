package cn.hur.shop.carousel.adminaction;


import java.util.List;

import cn.hur.shop.carousel.service.CarouselService;
import cn.hur.shop.carousel.vo.Carousel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 后台首页广告模块Aciton类
 */
public class AdminCarouselAction extends ActionSupport implements ModelDriven<Carousel>{
	
	//用于接收数据的模型驱动
	private Carousel carousel =new Carousel();
	
	public Carousel getModel() {
		return carousel;
	}
	
	//注入CarouselService
	private CarouselService carouselService;

	public void setCarouselService(CarouselService carouselService) {
		this.carouselService = carouselService;
	}
	
	//后台查询所有广告的执行方法
	public String findAll(){
		List<Carousel> caList=carouselService.findAll();
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("caList", caList);
		//页面跳转
		return "findAll";
	}
	
	//后台保存广告的执行方法
	public String save(){
		//调用Service完成保存一级分类
		carouselService.save(carousel);
		//进行页面跳转
		return "saveSuccess";
	}
	
	//后台删除广告的执行方法
	public String delete(){
		// 级联删除一定先查询再删除
		carousel=carouselService.findByCaid(carousel.getCaid());
		carouselService.delete(carousel);
		//页面跳转
		return "deleteSuccess";
	}
	
	//后台编辑广告的执行方法
	public String edit(){
		//根据caid进行查询
		carousel=carouselService.findByCaid(carousel.getCaid());
		//页面跳转
		return "editSuccess";
	}
	
	//后台修改广告的执行方法
	public String update(){
		//使用模型驱动接收前台提交数据
		carouselService.update(carousel);
		//页面跳转
		return "updateSuccess";
	}

}
