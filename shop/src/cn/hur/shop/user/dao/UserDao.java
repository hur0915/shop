package cn.hur.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.user.vo.User;
import cn.hur.shop.utils.PageHibernateCallback;

/*
 * �û�ģ��־ò�
 */
public class UserDao extends HibernateDaoSupport{
	
	//���û�����ѯ
	public User findByUsername(String username){
		String hql="from User where username=?";
		List<User> list=this.getHibernateTemplate().find(hql,username);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	//��ӣ�ע�ᣩ
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}
	
	// ���ݼ������ѯ�û�
	public User findByCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.getHibernateTemplate().find(hql, code);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// �޸��û�״̬�ķ���
	public void update(User existUser) {
		this.getHibernateTemplate().update(existUser);
	}

	//��¼
	public User login(User user) {
		String hql = "from User where username = ? and password = ? and state = ?";
		List<User> list = this.getHibernateTemplate().find(hql,
				user.getUsername(), user.getPassword(), 1);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//ͳ���û�����
	public int findCount() {
		String hql = "select count(*) from User";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//��ҳ��ѯ
	public List<User> findByPage(int begin, int limit) {
		String hql = "from User";
		List<User> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<User>(hql, null, begin, limit));
		return list;
	}

	//�����û�ID��ѯ
	public User findByUid(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
	}

	//ɾ���û�
	public void delete(User existUser) {
		this.getHibernateTemplate().delete(existUser);
	}
	
}
