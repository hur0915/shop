package cn.hur.shop.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.user.dao.UserDao;
import cn.hur.shop.user.vo.User;
import cn.hur.shop.utils.MailUtils;
import cn.hur.shop.utils.PageBean;
import cn.hur.shop.utils.UUIDUtils;

/*
 * 用户模块业务层
 */
@Transactional
public class UserService {
	
	//注入UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//业务层根据用户名查询
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	
	//业务层注册
	public void save(User user){
		// 将数据存入到数据库
		user.setState(0); // 0:代表用户未激活.  1:代表用户已经激活.
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		//发送激活邮件
		MailUtils.sendMail(user.getEmail(), code);
	}

	//业务层根据激活码查询
	public User findByCode(String code) {
		return userDao.findByCode(code);	
	}

	// 业务层修改用户状态
	public void update(User existUser) {
		userDao.update(existUser);
		
	}

	//业务层登录
	public User login(User user) {
		return userDao.login(user);
	}

	//业务层查询带分页的用户
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<User> list = userDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层根据用户ID查询用户
	public User findByUid(Integer uid) {
		return userDao.findByUid(uid);
	}

	//业务层删除用户
	public void delete(User existUser) {
		userDao.delete(existUser);
	}

}
