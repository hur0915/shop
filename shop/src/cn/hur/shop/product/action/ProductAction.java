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
 * ��Ʒģ��Action��
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	//���ڽ������ݵ�ģ������
	private Product product=new Product();
	
	public Product getModel() {
		return product;
	}
	
	//����һ������ID
	private Integer cid;
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Integer getCid() {
		return cid;
	}
	
	//���ն�������ID
	private Integer csid;
	
	
	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	//���յ�ǰҳ��
	private int page;

	public void setPage(int page) {
		this.page = page;
	}

	//ע��ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//ע��StoreService
	private StoreService storeService;

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	//ע��PimageService
	private PimageService pimageService;

	public void setPimageService(PimageService pimageService) {
		this.pimageService = pimageService;
	}
	
	//ע��PcolorService
	private PcolorService pcolorService;

	public void setPcolorService(PcolorService pcolorService) {
		this.pcolorService = pcolorService;
	}
	
	//ע��PsizeService
	private PsizeService psizeService;

	public void setPsizeService(PsizeService psizeService) {
		this.psizeService = psizeService;
	}
	
	//������ҳ��ִ�з���
	public String shop(){
		//��ѯ���е���
		List<Store> sList=storeService.findAll();
		//������ֵջ��
		ActionContext.getContext().getValueStack().set("sList", sList);
		//��ѯ������Ʒ
		List<Product> hList=productService.findHot();
		//������ֵջ��
		ActionContext.getContext().getValueStack().set("hList", hList);
		//��ѯ������Ʒ
		List<Product> nList=productService.findNew();
		//������ֵջ��
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "shop";
	}
		
	//������ƷID��ѯ��ִ�з���
	public String findByPid(){
		//��ѯ����ͼƬ
		List<Pimage> piList=pimageService.findByPid(product.getPid());
		//������ֵջ��
		ActionContext.getContext().getValueStack().set("piList", piList);
		//��ѯ������ɫ
		List<Pcolor> pcList=pcolorService.findByPid(product.getPid());
		//������ֵջ��
		ActionContext.getContext().getValueStack().set("pcList", pcList);
		//��ѯ���г���
		List<Psize> psList=psizeService.findByPid(product.getPid());
		//������ֵջ��
		ActionContext.getContext().getValueStack().set("psList", psList);
		//��ѯ��Ʒ����
		product=productService.findByPid(product.getPid());
		return "findbypid";
	}

	//����һ������ID��ѯ��ִ�з���
	public String findByCid(){
		PageBean<Product> pageBean=productService.findByCid(cid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findbycid";
	}
	
	//���ݶ�������ID��ѯ��ִ�з���
	public String findByCsid(){
		PageBean<Product> pageBean=productService.findByCsid(csid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findbycsid";
	}
}
