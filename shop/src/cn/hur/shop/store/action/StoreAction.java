package cn.hur.shop.store.action;

import cn.hur.shop.store.vo.Store;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 店铺模块Action类
 */
public class StoreAction extends ActionSupport implements ModelDriven<Store>{

	//用于接收数据的模型驱动
	private Store store=new Store();
	
	@Override
	public Store getModel() {
		return store;
	}

}
