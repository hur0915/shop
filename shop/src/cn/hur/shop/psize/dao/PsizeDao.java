package cn.hur.shop.psize.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.psize.vo.Psize;

/*
 * ��Ʒ����ģ��־ò�
 */
public class PsizeDao extends HibernateDaoSupport{

	//������ƷID��ѯ����
	public List<Psize> findByPid(Integer pid){
		String hql="select ps from Psize ps where ps.product.pid=?";
		List<Psize> list=this.getHibernateTemplate().find(hql,pid);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;	
	}
}
