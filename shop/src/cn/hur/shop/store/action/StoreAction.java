package cn.hur.shop.store.action;

import cn.hur.shop.store.vo.Store;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * ����ģ��Action��
 */
public class StoreAction extends ActionSupport implements ModelDriven<Store>{

	//���ڽ������ݵ�ģ������
	private Store store=new Store();
	
	@Override
	public Store getModel() {
		return store;
	}

}
