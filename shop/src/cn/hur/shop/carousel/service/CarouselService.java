package cn.hur.shop.carousel.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.carousel.dao.CarouselDao;
import cn.hur.shop.carousel.vo.Carousel;

/*
 * ��ҳ���ģ��ҵ���
 */
@Transactional
public class CarouselService {
	
	//ע��CarouselDao
	private CarouselDao carouselDao;

	public void setCarouselDao(CarouselDao carouselDao) {
		this.carouselDao = carouselDao;
	}
	
	//ҵ����ѯ���й��
	public List<Carousel> findAll(){
		return carouselDao.findAll();
	}
	
	//ҵ��㱣����
	public void save(Carousel carousel) {
		carouselDao.save(carousel);
	}

	//ҵ������ID��ѯ
	public Carousel findByCaid(Integer caid) {
		return carouselDao.findByCaid(caid);
	}

	//ҵ���ɾ������
	public void delete(Carousel carousel) {
		carouselDao.delete(carousel);
		
	}

	//ҵ�����¹��
	public void update(Carousel carousel) {
		carouselDao.update(carousel);
	}
	
}
