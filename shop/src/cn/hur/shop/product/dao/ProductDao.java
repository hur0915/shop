package cn.hur.shop.product.dao;

import java.util.List;










import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.categorysecond.vo.CategorySecond;
import cn.hur.shop.product.vo.Product;
import cn.hur.shop.utils.PageHibernateCallback;

/*
 * 商品模块持久层
 */
public class ProductDao extends HibernateDaoSupport{

	//查询热门商品
	public List<Product> findHot() {
		//离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//查询热门商品，条件是is_hot=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//按时间倒序输出
		criteria.addOrder(Order.asc("date"));
		//执行查询
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 4);
		return list;
	}
	
	//查询最新商品
	public List<Product> findNew(){
		//离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//按时间倒序输出
		criteria.addOrder(Order.desc("date"));
		//执行查询
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 4);
		return list;
		//
	}

	//根据商品ID查询
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	//根据一级分类ID查询商品记录数
	public int findCountByCid(Integer cid) {
		String hql="select count(*) from Product p where p.categorySecond.category.cid=?";
		List<Long> list=this.getHibernateTemplate().find(hql, cid);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//根据一级分类ID查询带分页的商品
	public List<Product> findPageByCid(Integer cid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
		List<Product> list=this.getHibernateTemplate().
				execute(new PageHibernateCallback(hql, new Object[]{cid}, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	//根据二级分类ID查询商品记录数
	public int findCountByCsid(Integer csid) {
		String hql="select count(*) from Product p where p.categorySecond.csid=?";
		List<Long> list=this.getHibernateTemplate().find(hql, csid);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//根据二级分类ID查询带分页的商品
	public List<Product> findPageByCsid(Integer csid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs where cs.csid=?";
		List<Product> list=this.getHibernateTemplate().
				execute(new PageHibernateCallback(hql, new Object[]{csid}, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	//统计商品数量
	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//分页查询
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql, null, begin,limit));
		return list;
	}

	//保存商品
	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

	//删除商品
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}

	//更新商品
	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}
	
}
