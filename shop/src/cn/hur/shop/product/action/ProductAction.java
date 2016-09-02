package cn.hur.shop.product.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.hur.shop.pcolor.service.PcolorService;
import cn.hur.shop.pcolor.vo.Pcolor;
import cn.hur.shop.pimage.service.PimageService;
import cn.hur.shop.pimage.vo.Pimage;
import cn.hur.shop.product.service.ProductService;
import cn.hur.shop.product.vo.Product;
import cn.hur.shop.psize.service.PsizeService;
import cn.hur.shop.psize.vo.Psize;
import cn.hur.shop.store.service.StoreService;
import cn.hur.shop.store.vo.Store;
import cn.hur.shop.utils.PageBean;

/*
 * 商品模块Action类
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	//用于接收数据的模型驱动
	private Product product=new Product();
	
	public Product getModel() {
		return product;
	}
	
	//接收一级分类ID
	private Integer cid;
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Integer getCid() {
		return cid;
	}
	
	//接收二级分类ID
	private Integer csid;
	
	
	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	//接收当前页数
	private int page;

	public void setPage(int page) {
		this.page = page;
	}

	//注入ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//注入StoreService
	private StoreService storeService;

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	//注入PimageService
	private PimageService pimageService;

	public void setPimageService(PimageService pimageService) {
		this.pimageService = pimageService;
	}
	
	//注入PcolorService
	private PcolorService pcolorService;

	public void setPcolorService(PcolorService pcolorService) {
		this.pcolorService = pcolorService;
	}
	
	//注入PsizeService
	private PsizeService psizeService;

	public void setPsizeService(PsizeService psizeService) {
		this.psizeService = psizeService;
	}
	
	//访问首页的执行方法
	public String shop(){
		//查询所有店铺
		List<Store> sList=storeService.findAll();
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("sList", sList);
		//查询热门商品
		List<Product> hList=productService.findHot();
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("hList", hList);
		//查询最新商品
		List<Product> nList=productService.findNew();
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "shop";
	}
		
	//根据商品ID查询的执行方法
	public String findByPid(){
		//查询所有图片
		List<Pimage> piList=pimageService.findByPid(product.getPid());
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("piList", piList);
		//查询所有颜色
		List<Pcolor> pcList=pcolorService.findByPid(product.getPid());
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("pcList", pcList);
		//查询所有尺码
		List<Psize> psList=psizeService.findByPid(product.getPid());
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("psList", psList);
		//查询商品详情
		product=productService.findByPid(product.getPid());
		return "findbypid";
	}

	//根据一级分类ID查询的执行方法
	public String findByCid(){
		PageBean<Product> pageBean=productService.findByCid(cid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findbycid";
	}
	
	//根据二级分类ID查询的执行方法
	public String findByCsid(){
		PageBean<Product> pageBean=productService.findByCsid(csid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findbycsid";
	}
}
