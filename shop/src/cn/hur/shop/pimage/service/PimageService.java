package cn.hur.shop.pimage.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.pimage.dao.PimageDao;
import cn.hur.shop.pimage.vo.Pimage;

/*
 * 商品图片模块业务层
 */
@Transactional
public class PimageService {
	
	//注入PimageDao
	private PimageDao pimageDao;

	public void setPimageDao(PimageDao pimageDao) {
		this.pimageDao = pimageDao;
	}
	
	//业务层根据商品ID查询图片
	public List<Pimage> findByPid(Integer pid){
		return pimageDao.findByPid(pid);
	}

}
