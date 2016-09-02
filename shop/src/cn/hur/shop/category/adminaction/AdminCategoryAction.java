package cn.hur.shop.category.adminaction;

import java.util.List;

import cn.hur.shop.category.service.CategoryService;
import cn.hur.shop.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 后台一级分类模块Action类
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{

	//用于接收数据的模型驱动
	private Category category =new Category();
	
	public Category getModel() {
		return category;
	}
	
	//注入CategoryService
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//后台查询所有一级分类的执行方法
	public String findAll(){
		List<Category> cList=categoryService.findAll();
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("cList", cList);
		//页面跳转
		return "findAll";
	}
	
	//后台保存一级分类的执行方法
	public String save(){
		//调用Service完成保存一级分类
		categoryService.save(category);
		// 进行页面跳转
		return "saveSuccess";
	}
	
	//后台删除一级分类的执行方法
	public String delete(){
		// 级联删除一定先查询再删除
		category=categoryService.findByCid(category.getCid());
		categoryService.delete(category);
		//页面跳转
		return "deleteSuccess";
	}
	
	//后台编辑一级分类的执行方法
	public String edit(){
		//根据cid进行查询
		category=categoryService.findByCid(category.getCid());
		//页面跳转
		return "editSuccess";
	}
	
	//后台修改一级分类的执行方法
	public String update(){
		//使用模型驱动接收前台提交数据
		categoryService.update(category);
		//页面跳转
		return "updateSuccess";
	}

}
