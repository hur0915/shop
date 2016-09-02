package cn.hur.shop.psize.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.psize.dao.PsizeDao;
import cn.hur.shop.psize.vo.Psize;

/*
 * 商品尺码模块业务层
 */
@Transactional
public class PsizeService {
	
	//注入PsizeDao
	private PsizeDao psizeDao;

	public void setPsizeDao(PsizeDao psizeDao) {
		this.psizeDao = psizeDao;
	}
	
	//业务层根据商品ID查询尺码
	public List<Psize> findByPid(Integer pid){
		return psizeDao.findByPid(pid);
	}

}
