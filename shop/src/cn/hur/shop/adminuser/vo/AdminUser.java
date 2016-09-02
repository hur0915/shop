package cn.hur.shop.adminuser.vo;

/*
 * 后台管理员模块实体类
 */
public class AdminUser {
	
	private Integer uid;//ID
	private String username;//用户名
	private String password;//密码
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
