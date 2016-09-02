package cn.hur.shop.psize.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.psize.vo.Psize;

/*
 * 商品尺码模块持久层
 */
public class PsizeDao extends HibernateDaoSupport{

	//根据商品ID查询尺码
	public List<Psize> findByPid(Integer pid){
		String hql="select ps from Psize ps where ps.product.pid=?";
		List<Psize> list=this.getHibernateTemplate().find(hql,pid);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;	
	}
}
