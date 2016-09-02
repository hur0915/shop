package cn.hur.shop.user.adminaction;

import cn.hur.shop.user.service.UserService;
import cn.hur.shop.user.vo.User;
import cn.hur.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 后台用户模块Action类
 */
public class UserAdminAction extends ActionSupport implements ModelDriven<User>{
	
	//接收数据的模型驱动
	private User user = new User();

	public User getModel() {
		return user;
	}
	
	// 注入用户的Service
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//接收当前页数page
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	//后台查询带分页的所有用户的执行方法
	public String findAll(){
		PageBean<User> pageBean = userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//后台删除用户的执行方法
	public String delete(){
		User existUser = userService.findByUid(user.getUid());
		userService.delete(existUser);
		return "deleteSuccess";
	}
	
	//后台编辑用户的执行方法
	public String edit(){
		user = userService.findByUid(user.getUid());
		return "editSuccess";
	}
	
	//后台更新用户的执行方法
	public String update(){
		userService.update(user);
		return "updateSuccess";
	}

}
