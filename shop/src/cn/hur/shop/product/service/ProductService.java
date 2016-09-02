package cn.hur.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.product.dao.ProductDao;
import cn.hur.shop.product.vo.Product;
import cn.hur.shop.utils.PageBean;

/*
 * 商品模块业务层
 */
@Transactional
public class ProductService {

	//注入ProductDao
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	//业务层查询热门商品
	public List<Product> findHot() {
		return productDao.findHot();
	}
	
	//业务层查询最新商品
	public List<Product> findNew() {
		return productDao.findNew();
	}

	//业务层根据商品ID查询商品
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	//业务层根据一级分类ID查询带有分页的商品
	public PageBean<Product> findByCid(Integer cid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置总记录数
		int totalCount=0;
		totalCount=productDao.findCountByCid(cid);
		pageBean.setTotalCount(totalCount);
		//设置每页显示数
		int limit=9;
		pageBean.setLimit(limit);
		//设置总页数
		int totalPage=0;
		if(totalCount % limit == 0){
			totalPage= totalCount / limit;
		}else{
			totalPage= totalCount / limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置每页显示的数据集合
		int begin=( page-1 ) * limit;
		List<Product> list=productDao.findPageByCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层根据二级分类ID查询带有分页的商品
	public PageBean<Product> findByCsid(Integer csid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置总记录数
		int totalCount=0;
		totalCount=productDao.findCountByCsid(csid);
		pageBean.setTotalCount(totalCount);
		//设置每页显示数
		int limit=9;
		pageBean.setLimit(limit);
		//设置总页数
		int totalPage=0;
		if(totalCount % limit == 0){
			totalPage= totalCount / limit;
		}else{
			totalPage= totalCount / limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置每页显示的数据集合
		int begin=( page-1 ) * limit;
		List<Product> list=productDao.findPageByCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层根据当前页数查询
	public PageBean<Product> findByPage(int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置总记录数
		int totalCount=0;
		totalCount=productDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置每页显示数
		int limit=9;
		pageBean.setLimit(limit);
		//设置总页数
		int totalPage=0;
		if(totalCount % limit == 0){
			totalPage= totalCount / limit;
		}else{
			totalPage= totalCount / limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置每页显示的数据集合
		int begin=( page-1 ) * limit;
		List<Product> list=productDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层保存商品
	public void save(Product product) {
		productDao.save(product);
	}
	
	//业务层删除商品
	public void delete(Product product) {
		productDao.delete(product);
	}
	
	//业务层更新商品
	public void update(Product product) {
		productDao.update(product);	
	}

}
