package cn.hur.shop.psize.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.psize.dao.PsizeDao;
import cn.hur.shop.psize.vo.Psize;

/*
 * ��Ʒ����ģ��ҵ���
 */
@Transactional
public class PsizeService {
	
	//ע��PsizeDao
	private PsizeDao psizeDao;

	public void setPsizeDao(PsizeDao psizeDao) {
		this.psizeDao = psizeDao;
	}
	
	//ҵ��������ƷID��ѯ����
	public List<Psize> findByPid(Integer pid){
		return psizeDao.findByPid(pid);
	}

}
