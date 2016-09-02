package cn.hur.shop.adminuser.service;

import cn.hur.shop.adminuser.dao.AdminUserDao;
import cn.hur.shop.adminuser.vo.AdminUser;

/*
 * 后台管理员模块业务层
 */
public class AdminUserService {
	
	//注入AdminUserDao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	//业务层登录
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	

}
