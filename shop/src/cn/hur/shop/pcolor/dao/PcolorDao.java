package cn.hur.shop.pcolor.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.pcolor.vo.Pcolor;

/*
 * ��Ʒ��ɫģ��־ò�
 */
public class PcolorDao extends HibernateDaoSupport{

	//������ƷID��ѯ��ɫ
	public List<Pcolor> findByPid(Integer pid){
		String hql="select pc from Pcolor pc where pc.product.pid=?";
		List<Pcolor> list=this.getHibernateTemplate().find(hql,pid);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;	
	}
}
