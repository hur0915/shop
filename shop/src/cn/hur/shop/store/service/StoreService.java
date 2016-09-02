package cn.hur.shop.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.store.dao.StoreDao;
import cn.hur.shop.store.vo.Store;

/*
 * 店铺模块业务层
 */
@Transactional
public class StoreService {

	//注入StoreDao
	private StoreDao storeDao;

	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}
	
	//业务层查询所有店铺
	public List<Store> findAll(){
		return storeDao.findAll();
	}
}
