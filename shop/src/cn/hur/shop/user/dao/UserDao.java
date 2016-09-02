package cn.hur.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.user.vo.User;
import cn.hur.shop.utils.PageHibernateCallback;

/*
 * 用户模块持久层
 */
public class UserDao extends HibernateDaoSupport{
	
	//按用户名查询
	public User findByUsername(String username){
		String hql="from User where username=?";
		List<User> list=this.getHibernateTemplate().find(hql,username);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	//添加（注册）
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}
	
	// 根据激活码查询用户
	public User findByCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.getHibernateTemplate().find(hql, code);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 修改用户状态的方法
	public void update(User existUser) {
		this.getHibernateTemplate().update(existUser);
	}

	//登录
	public User login(User user) {
		String hql = "from User where username = ? and password = ? and state = ?";
		List<User> list = this.getHibernateTemplate().find(hql,
				user.getUsername(), user.getPassword(), 1);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//统计用户个数
	public int findCount() {
		String hql = "select count(*) from User";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//分页查询
	public List<User> findByPage(int begin, int limit) {
		String hql = "from User";
		List<User> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<User>(hql, null, begin, limit));
		return list;
	}

	//根据用户ID查询
	public User findByUid(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
	}

	//删除用户
	public void delete(User existUser) {
		this.getHibernateTemplate().delete(existUser);
	}
	
}
