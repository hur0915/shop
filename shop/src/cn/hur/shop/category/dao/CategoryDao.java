package cn.hur.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.category.vo.Category;

/*
 * 一级分类模块持久层
 */
public class CategoryDao extends HibernateDaoSupport{
	
	//查询所有一级分类
	public List<Category> findAll(){
		String hql="from Category";
		List<Category> list=this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;	
	}
	
	//保存一级份分类
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

	//根据一级分类ID查询
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	//删除一级分类
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);	
	}

	//更新一级分类
	public void update(Category category) {
		this.getHibernateTemplate().update(category);	
	}

}
