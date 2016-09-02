package cn.hur.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.product.dao.ProductDao;
import cn.hur.shop.product.vo.Product;
import cn.hur.shop.utils.PageBean;

/*
 * ��Ʒģ��ҵ���
 */
@Transactional
public class ProductService {

	//ע��ProductDao
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	//ҵ����ѯ������Ʒ
	public List<Product> findHot() {
		return productDao.findHot();
	}
	
	//ҵ����ѯ������Ʒ
	public List<Product> findNew() {
		return productDao.findNew();
	}

	//ҵ��������ƷID��ѯ��Ʒ
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	//ҵ������һ������ID��ѯ���з�ҳ����Ʒ
	public PageBean<Product> findByCid(Integer cid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//�����ܼ�¼��
		int totalCount=0;
		totalCount=productDao.findCountByCid(cid);
		pageBean.setTotalCount(totalCount);
		//����ÿҳ��ʾ��
		int limit=9;
		pageBean.setLimit(limit);
		//������ҳ��
		int totalPage=0;
		if(totalCount % limit == 0){
			totalPage= totalCount / limit;
		}else{
			totalPage= totalCount / limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//����ÿҳ��ʾ�����ݼ���
		int begin=( page-1 ) * limit;
		List<Product> list=productDao.findPageByCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//ҵ�����ݶ�������ID��ѯ���з�ҳ����Ʒ
	public PageBean<Product> findByCsid(Integer csid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//�����ܼ�¼��
		int totalCount=0;
		totalCount=productDao.findCountByCsid(csid);
		pageBean.setTotalCount(totalCount);
		//����ÿҳ��ʾ��
		int limit=9;
		pageBean.setLimit(limit);
		//������ҳ��
		int totalPage=0;
		if(totalCount % limit == 0){
			totalPage= totalCount / limit;
		}else{
			totalPage= totalCount / limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//����ÿҳ��ʾ�����ݼ���
		int begin=( page-1 ) * limit;
		List<Product> list=productDao.findPageByCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//ҵ�����ݵ�ǰҳ����ѯ
	public PageBean<Product> findByPage(int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//�����ܼ�¼��
		int totalCount=0;
		totalCount=productDao.findCount();
		pageBean.setTotalCount(totalCount);
		//����ÿҳ��ʾ��
		int limit=9;
		pageBean.setLimit(limit);
		//������ҳ��
		int totalPage=0;
		if(totalCount % limit == 0){
			totalPage= totalCount / limit;
		}else{
			totalPage= totalCount / limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//����ÿҳ��ʾ�����ݼ���
		int begin=( page-1 ) * limit;
		List<Product> list=productDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//ҵ��㱣����Ʒ
	public void save(Product product) {
		productDao.save(product);
	}
	
	//ҵ���ɾ����Ʒ
	public void delete(Product product) {
		productDao.delete(product);
	}
	
	//ҵ��������Ʒ
	public void update(Product product) {
		productDao.update(product);	
	}

}
