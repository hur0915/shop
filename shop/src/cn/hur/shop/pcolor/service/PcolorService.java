package cn.hur.shop.pcolor.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.pcolor.dao.PcolorDao;
import cn.hur.shop.pcolor.vo.Pcolor;

/*
 * ��Ʒ��ɫģ��ҵ���
 */
@Transactional
public class PcolorService {
	
	//ע��PcolorDao
	private PcolorDao pcolorDao;

	public void setPcolorDao(PcolorDao pcolorDao) {
		this.pcolorDao = pcolorDao;
	}
	
	//ҵ��������ƷID��ѯ��ɫ
	public List<Pcolor> findByPid(Integer pid){
		return pcolorDao.findByPid(pid);
	}

}
