package cn.hur.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.hur.shop.user.service.UserService;
import cn.hur.shop.user.vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 用户模块Action类
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	//用于接收数据的模型驱动
	private User user=new User();
	
	public User getModel() {	
		return user;
	}
	
	//接收验证码
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	// 注入UserService
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//跳转到注册页面的执行方法
	public String registPage() {
		return "registPage";
	}

	//AJAX进行异步校验用户名的执行方法
	public String findByName() throws IOException{
		// 根据用户名查询用户
		User existUser=userService.findByUsername(user.getUsername());
		// 获得response对象页面输出
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		// 判断
		if(existUser!=null){
			response.getWriter().println("<font color='red'>用户名已经存在</font>");	
		}
		else{
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	
	//用户注册的执行方法
	public String regist(){
		//判断验证码，从session取得验证码的随机值
		String checkcode1=(String) ServletActionContext.getRequest().
				getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("验证码错误！");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("注册成功!请去邮箱激活!");
		return "msg";
	}
	
	//用户激活的执行方法
	public String active(){
		//根据激活码查询用户
		User existUser=userService.findByCode(user.getCode());
		// 判断
		if (existUser == null) {
			// 激活码错误
			this.addActionMessage("激活失败:激活码错误!");
		} else {
			// 激活成功
			// 修改用户的状态
			existUser.setState(1);
			existUser.setCode(null);//一次激活
			userService.update(existUser);
			this.addActionMessage("激活成功:请去登录!");
		}
		return "msg";
	}
	
	//跳转到登录页面的执行方法
	public String loginPage() {
		return "loginPage";
	}
	
	//用户登录的执行方法
	public String login(){
		User existUser=userService.login(user);
		// 判断
		if (existUser == null) {
			// 登录失败
			this.addActionError("登录失败:用户名或密码错误或用户未激活!");
			return LOGIN;
		} else {
			// 登录成功
			// 将用户的信息存入到session中
			ServletActionContext.getRequest().getSession()
					.setAttribute("existUser", existUser);
			// 页面跳转
			return "loginSuccess";
		}
	}
	
	//用户退出的执行方法
	public String quit(){
		// 销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}

}
