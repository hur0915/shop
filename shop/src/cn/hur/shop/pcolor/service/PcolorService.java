package cn.hur.shop.pcolor.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.pcolor.dao.PcolorDao;
import cn.hur.shop.pcolor.vo.Pcolor;

/*
 * 商品颜色模块业务层
 */
@Transactional
public class PcolorService {
	
	//注入PcolorDao
	private PcolorDao pcolorDao;

	public void setPcolorDao(PcolorDao pcolorDao) {
		this.pcolorDao = pcolorDao;
	}
	
	//业务层根据商品ID查询颜色
	public List<Pcolor> findByPid(Integer pid){
		return pcolorDao.findByPid(pid);
	}

}
