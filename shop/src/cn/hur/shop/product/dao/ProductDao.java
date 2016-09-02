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
 * ��Ʒģ��־ò�
 */
public class ProductDao extends HibernateDaoSupport{

	//��ѯ������Ʒ
	public List<Product> findHot() {
		//����������ѯ
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//��ѯ������Ʒ��������is_hot=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//��ʱ�䵹�����
		criteria.addOrder(Order.asc("date"));
		//ִ�в�ѯ
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 4);
		return list;
	}
	
	//��ѯ������Ʒ
	public List<Product> findNew(){
		//����������ѯ
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//��ʱ�䵹�����
		criteria.addOrder(Order.desc("date"));
		//ִ�в�ѯ
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 4);
		return list;
		//
	}

	//������ƷID��ѯ
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	//����һ������ID��ѯ��Ʒ��¼��
	public int findCountByCid(Integer cid) {
		String hql="select count(*) from Product p where p.categorySecond.category.cid=?";
		List<Long> list=this.getHibernateTemplate().find(hql, cid);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//����һ������ID��ѯ����ҳ����Ʒ
	public List<Product> findPageByCid(Integer cid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
		List<Product> list=this.getHibernateTemplate().
				execute(new PageHibernateCallback(hql, new Object[]{cid}, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	//���ݶ�������ID��ѯ��Ʒ��¼��
	public int findCountByCsid(Integer csid) {
		String hql="select count(*) from Product p where p.categorySecond.csid=?";
		List<Long> list=this.getHibernateTemplate().find(hql, csid);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//���ݶ�������ID��ѯ����ҳ����Ʒ
	public List<Product> findPageByCsid(Integer csid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs where cs.csid=?";
		List<Product> list=this.getHibernateTemplate().
				execute(new PageHibernateCallback(hql, new Object[]{csid}, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	//ͳ����Ʒ����
	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//��ҳ��ѯ
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql, null, begin,limit));
		return list;
	}

	//������Ʒ
	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

	//ɾ����Ʒ
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}

	//������Ʒ
	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}
	
}
