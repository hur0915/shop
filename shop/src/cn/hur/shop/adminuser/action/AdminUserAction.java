package cn.hur.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import cn.hur.shop.adminuser.service.AdminUserService;
import cn.hur.shop.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 后台管理员模块Action类
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{

	//用于接收数据的模型驱动
	private AdminUser adminUser=new AdminUser();
	
	public AdminUser getModel() {
		return adminUser;
	}
	
	//注入AdminUserService
	private AdminUserService adminUserService;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	//后台登录的执行方法
	public String login(){
		// 调用service方法完成登录
		AdminUser existAdminUser = adminUserService.login(adminUser);
		// 判断
		if (existAdminUser == null) {
			// 用户名或密码错误
			this.addActionError("用户名或密码错误!");
			return "loginFail";
		}else {
			//登录成功
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}

}
