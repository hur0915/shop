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
 * 后台商品模块Action类
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{

	//用于接收数据的模型驱动
	private Product product=new Product();
	
	public Product getModel() {
		return product;
	}

	//注入ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//接收当前页数
	private int page;

	public void setPage(int page) {
		this.page = page;
	}
	
	//注入CategorySecondService
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//文件上传需要的三个属性
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
	
	//后台查询所有商品的执行方法
	public String findAll(){
		PageBean<Product> pageBean=productService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//后台跳转至添加商品的执行方法
	public String addPage(){
		//查询所有二级分类
		List<CategorySecond> csList=categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "addPage";
	}
	
	//后台保存商品的执行方法
	public String save() throws IOException{
		product.setDate(new Date());
		if(upload !=null){
			//将商品图片上传到服务器上
			//获得上传图片的服务器端路径
			String path=ServletActionContext.getServletContext().getRealPath("/products");
			//创建文件类型对象
			File diskFile=new File(path+"//"+uploadFileName);
			//文件上传
			FileUtils.copyFile(upload,diskFile);
			
			product.setImg("product/"+uploadFileName);
		}
		productService.save(product);
		return "saveSuccess";
	}
	
	//后台删除商品的执行方法
	public String delete(){
		//查询商品
		product=productService.findByPid(product.getPid());
		//删除商品的图片
		String delpath = ServletActionContext.getServletContext().getRealPath(
				"/" + product.getImg());
		File file = new File(delpath);
		file.delete();
		//删除数据库中商品记录
		productService.delete(product);
		//页面跳转
		return "deleteSuccess";
		
	}
	//后台编辑商品的执行方法
	public String edit(){
		product=productService.findByPid(product.getPid());
		//查询所有二级分类
		List<CategorySecond> csList=categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "editSuccess";
		
	}

	//后台修改商品的执行方法
	public String update() throws IOException{
		//将信息修改到数据库
		product.setDate(new Date());
		//上传
		if(upload != null ){
			//删除原图片
			String delPath = ServletActionContext.getServletContext().getRealPath(
					"/" + product.getImg());
			File file = new File(delPath);
			file.delete();
			//上传新图片
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
