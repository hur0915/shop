package cn.hur.shop.carousel.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.carousel.vo.Carousel;

/*
 * ��ҳ���ģ��־ò�
 */
public class CarouselDao extends HibernateDaoSupport{
	
	//��ѯ���й��
	public List<Carousel> findAll(){
		String hql="from Carousel";
		List<Carousel> list=this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;	
	}
	
	//������
	public void save(Carousel carousel) {
		this.getHibernateTemplate().save(carousel);
	}

	//����ID��ѯ
	public Carousel findByCaid(Integer caid) {
		return this.getHibernateTemplate().get(Carousel.class, caid);
	}

	//ɾ�����
	public void delete(Carousel carousel) {
		this.getHibernateTemplate().delete(carousel);	
	}

	//���¹��
	public void update(Carousel carousel) {
		this.getHibernateTemplate().update(carousel);	
	}

}
