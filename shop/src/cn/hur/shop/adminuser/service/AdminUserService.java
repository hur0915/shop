package cn.hur.shop.adminuser.service;

import cn.hur.shop.adminuser.dao.AdminUserDao;
import cn.hur.shop.adminuser.vo.AdminUser;

/*
 * ��̨����Աģ��ҵ���
 */
public class AdminUserService {
	
	//ע��AdminUserDao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	//ҵ����¼
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	

}
