package cn.hur.shop.store.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.store.vo.Store;

/*
 * 店铺模块持久层
 */
public class StoreDao extends HibernateDaoSupport{

	//查询所有店铺
	public List<Store> findAll(){
		String hql="from Store";
		List<Store> list=this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;	
	}
}
