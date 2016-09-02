package cn.hur.shop.pimage.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.pimage.dao.PimageDao;
import cn.hur.shop.pimage.vo.Pimage;

/*
 * ��ƷͼƬģ��ҵ���
 */
@Transactional
public class PimageService {
	
	//ע��PimageDao
	private PimageDao pimageDao;

	public void setPimageDao(PimageDao pimageDao) {
		this.pimageDao = pimageDao;
	}
	
	//ҵ��������ƷID��ѯͼƬ
	public List<Pimage> findByPid(Integer pid){
		return pimageDao.findByPid(pid);
	}

}
