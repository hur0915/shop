package cn.hur.shop.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.store.dao.StoreDao;
import cn.hur.shop.store.vo.Store;

/*
 * ����ģ��ҵ���
 */
@Transactional
public class StoreService {

	//ע��StoreDao
	private StoreDao storeDao;

	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}
	
	//ҵ����ѯ���е���
	public List<Store> findAll(){
		return storeDao.findAll();
	}
}
