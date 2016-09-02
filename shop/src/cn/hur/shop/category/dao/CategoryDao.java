package cn.hur.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.category.vo.Category;

/*
 * һ������ģ��־ò�
 */
public class CategoryDao extends HibernateDaoSupport{
	
	//��ѯ����һ������
	public List<Category> findAll(){
		String hql="from Category";
		List<Category> list=this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;	
	}
	
	//����һ���ݷ���
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

	//����һ������ID��ѯ
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	//ɾ��һ������
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);	
	}

	//����һ������
	public void update(Category category) {
		this.getHibernateTemplate().update(category);	
	}

}
