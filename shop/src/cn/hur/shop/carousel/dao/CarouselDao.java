package cn.hur.shop.carousel.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.carousel.vo.Carousel;

/*
 * 首页广告模块持久层
 */
public class CarouselDao extends HibernateDaoSupport{
	
	//查询所有广告
	public List<Carousel> findAll(){
		String hql="from Carousel";
		List<Carousel> list=this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;	
	}
	
	//保存广告
	public void save(Carousel carousel) {
		this.getHibernateTemplate().save(carousel);
	}

	//根据ID查询
	public Carousel findByCaid(Integer caid) {
		return this.getHibernateTemplate().get(Carousel.class, caid);
	}

	//删除广告
	public void delete(Carousel carousel) {
		this.getHibernateTemplate().delete(carousel);	
	}

	//更新广告
	public void update(Carousel carousel) {
		this.getHibernateTemplate().update(carousel);	
	}

}
