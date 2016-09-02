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
 * ��̨��������ģ��Action��
 */
public class AdminCategorySecondAction extends ActionSupport 
	implements ModelDriven<CategorySecond>{

	//���ڽ������ݵ�ģ������
	private CategorySecond categorySecond=new CategorySecond();
	
	public CategorySecond getModel() {
		return categorySecond;
	}
	
	//ע��CategorySecondService
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//ע��CategoryService
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	//����page
	private int page;

	public void setPage(int page) {
		this.page = page;
	}
	
	//��̨��ѯ���ж��������ִ�з���
	public String findAll(){
		PageBean<CategorySecond> pageBean=categorySecondService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//��̨��ת����Ӷ��������ִ�з���
	public String addPage(){
		//��ѯ����һ������
		List<Category> cList=categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPage";
	}
	
	//��̨������������ִ�з���
	public String save(){
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}
	
	//��̨ɾ�����������ִ�з���
	public String delete(){
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	//��̨�༭���������ִ�з���
	public String edit(){
		categorySecond=categorySecondService.fingByCsid(categorySecond.getCsid());
		//��ѯ����һ������
		List<Category> cList=categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editSuccess";
	}

	//��̨�޸Ķ��������ִ�з���
	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
	
}
