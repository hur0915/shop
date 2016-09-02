package cn.hur.shop.pimage.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.pimage.vo.Pimage;

/*
 * 商品图片模块持久层
 */
public class PimageDao extends HibernateDaoSupport{

	//根据商品ID查询图片
	public List<Pimage> findByPid(Integer pid){
		String hql="select pi from Pimage pi where pi.product.pid=?";
		List<Pimage> list=this.getHibernateTemplate().find(hql,pid);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;	
	}
}
