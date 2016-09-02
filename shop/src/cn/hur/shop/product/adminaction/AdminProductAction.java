package cn.hur.shop.product.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.hur.shop.categorysecond.service.CategorySecondService;
import cn.hur.shop.categorysecond.vo.CategorySecond;
import cn.hur.shop.product.service.ProductService;
import cn.hur.shop.product.vo.Product;
import cn.hur.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * ��̨��Ʒģ��Action��
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{

	//���ڽ������ݵ�ģ������
	private Product product=new Product();
	
	public Product getModel() {
		return product;
	}

	//ע��ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//���յ�ǰҳ��
	private int page;

	public void setPage(int page) {
		this.page = page;
	}
	
	//ע��CategorySecondService
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//�ļ��ϴ���Ҫ����������
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
	//��̨��ѯ������Ʒ��ִ�з���
	public String findAll(){
		PageBean<Product> pageBean=productService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//��̨��ת�������Ʒ��ִ�з���
	public String addPage(){
		//��ѯ���ж�������
		List<CategorySecond> csList=categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "addPage";
	}
	
	//��̨������Ʒ��ִ�з���
	public String save() throws IOException{
		product.setDate(new Date());
		if(upload !=null){
			//����ƷͼƬ�ϴ�����������
			//����ϴ�ͼƬ�ķ�������·��
			String path=ServletActionContext.getServletContext().getRealPath("/products");
			//�����ļ����Ͷ���
			File diskFile=new File(path+"//"+uploadFileName);
			//�ļ��ϴ�
			FileUtils.copyFile(upload,diskFile);
			
			product.setImg("product/"+uploadFileName);
		}
		productService.save(product);
		return "saveSuccess";
	}
	
	//��̨ɾ����Ʒ��ִ�з���
	public String delete(){
		//��ѯ��Ʒ
		product=productService.findByPid(product.getPid());
		//ɾ����Ʒ��ͼƬ
		String delpath = ServletActionContext.getServletContext().getRealPath(
				"/" + product.getImg());
		File file = new File(delpath);
		file.delete();
		//ɾ�����ݿ�����Ʒ��¼
		productService.delete(product);
		//ҳ����ת
		return "deleteSuccess";
		
	}
	//��̨�༭��Ʒ��ִ�з���
	public String edit(){
		product=productService.findByPid(product.getPid());
		//��ѯ���ж�������
		List<CategorySecond> csList=categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "editSuccess";
		
	}

	//��̨�޸���Ʒ��ִ�з���
	public String update() throws IOException{
		//����Ϣ�޸ĵ����ݿ�
		product.setDate(new Date());
		//�ϴ�
		if(upload != null ){
			//ɾ��ԭͼƬ
			String delPath = ServletActionContext.getServletContext().getRealPath(
					"/" + product.getImg());
			File file = new File(delPath);
			file.delete();
			//�ϴ���ͼƬ
			String path = ServletActionContext.getServletContext().getRealPath(
					"/products");
			File diskFile = new File(path + "//" + uploadFileName);
			FileUtils.copyFile(upload, diskFile);

			product.setImg("products/" + uploadFileName);
		}
		productService.update(product);
		return "updateSuccess";
	}
}
