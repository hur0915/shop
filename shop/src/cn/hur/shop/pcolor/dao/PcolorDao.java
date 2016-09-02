package cn.hur.shop.pcolor.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.pcolor.vo.Pcolor;

/*
 * 商品颜色模块持久层
 */
public class PcolorDao extends HibernateDaoSupport{

	//根据商品ID查询颜色
	public List<Pcolor> findByPid(Integer pid){
		String hql="select pc from Pcolor pc where pc.product.pid=?";
		List<Pcolor> list=this.getHibernateTemplate().find(hql,pid);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;	
	}
}
