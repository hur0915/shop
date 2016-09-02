package cn.hur.shop.carousel.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.carousel.dao.CarouselDao;
import cn.hur.shop.carousel.vo.Carousel;

/*
 * 首页广告模块业务层
 */
@Transactional
public class CarouselService {
	
	//注入CarouselDao
	private CarouselDao carouselDao;

	public void setCarouselDao(CarouselDao carouselDao) {
		this.carouselDao = carouselDao;
	}
	
	//业务层查询所有广告
	public List<Carousel> findAll(){
		return carouselDao.findAll();
	}
	
	//业务层保存广告
	public void save(Carousel carousel) {
		carouselDao.save(carousel);
	}

	//业务层根据ID查询
	public Carousel findByCaid(Integer caid) {
		return carouselDao.findByCaid(caid);
	}

	//业务层删除光广告
	public void delete(Carousel carousel) {
		carouselDao.delete(carousel);
		
	}

	//业务层更新广告
	public void update(Carousel carousel) {
		carouselDao.update(carousel);
	}
	
}
