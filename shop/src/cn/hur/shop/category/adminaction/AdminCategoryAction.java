package cn.hur.shop.category.adminaction;

import java.util.List;

import cn.hur.shop.category.service.CategoryService;
import cn.hur.shop.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * ��̨һ������ģ��Action��
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{

	//���ڽ������ݵ�ģ������
	private Category category =new Category();
	
	public Category getModel() {
		return category;
	}
	
	//ע��CategoryService
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//��̨��ѯ����һ�������ִ�з���
	public String findAll(){
		List<Category> cList=categoryService.findAll();
		//������ֵջ��
		ActionContext.getContext().getValueStack().set("cList", cList);
		//ҳ����ת
		return "findAll";
	}
	
	//��̨����һ�������ִ�з���
	public String save(){
		//����Service��ɱ���һ������
		categoryService.save(category);
		// ����ҳ����ת
		return "saveSuccess";
	}
	
	//��̨ɾ��һ�������ִ�з���
	public String delete(){
		// ����ɾ��һ���Ȳ�ѯ��ɾ��
		category=categoryService.findByCid(category.getCid());
		categoryService.delete(category);
		//ҳ����ת
		return "deleteSuccess";
	}
	
	//��̨�༭һ�������ִ�з���
	public String edit(){
		//����cid���в�ѯ
		category=categoryService.findByCid(category.getCid());
		//ҳ����ת
		return "editSuccess";
	}
	
	//��̨�޸�һ�������ִ�з���
	public String update(){
		//ʹ��ģ����������ǰ̨�ύ����
		categoryService.update(category);
		//ҳ����ת
		return "updateSuccess";
	}

}
