package cn.hur.shop.categorysecond.adminaction;

import java.util.List;

import cn.hur.shop.category.service.CategoryService;
import cn.hur.shop.category.vo.Category;
import cn.hur.shop.categorysecond.service.CategorySecondService;
import cn.hur.shop.categorysecond.vo.CategorySecond;
import cn.hur.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 后台二级分类模块Action类
 */
public class AdminCategorySecondAction extends ActionSupport 
	implements ModelDriven<CategorySecond>{

	//用于接收数据的模型驱动
	private CategorySecond categorySecond=new CategorySecond();
	
	public CategorySecond getModel() {
		return categorySecond;
	}
	
	//注入CategorySecondService
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//注入CategoryService
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	//接收page
	private int page;

	public void setPage(int page) {
		this.page = page;
	}
	
	//后台查询所有二级分类的执行方法
	public String findAll(){
		PageBean<CategorySecond> pageBean=categorySecondService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//后台跳转至添加二级分类的执行方法
	public String addPage(){
		//查询所有一级分类
		List<Category> cList=categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPage";
	}
	
	//后台保存二级分类的执行方法
	public String save(){
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}
	
	//后台删除二级分类的执行方法
	public String delete(){
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	//后台编辑二级分类的执行方法
	public String edit(){
		categorySecond=categorySecondService.fingByCsid(categorySecond.getCsid());
		//查询所有一级分类
		List<Category> cList=categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editSuccess";
	}

	//后台修改二级分类的执行方法
	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
	
}
