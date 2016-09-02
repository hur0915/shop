package cn.hur.shop.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.user.dao.UserDao;
import cn.hur.shop.user.vo.User;
import cn.hur.shop.utils.MailUtils;
import cn.hur.shop.utils.PageBean;
import cn.hur.shop.utils.UUIDUtils;

/*
 * �û�ģ��ҵ���
 */
@Transactional
public class UserService {
	
	//ע��UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//ҵ�������û�����ѯ
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	
	//ҵ���ע��
	public void save(User user){
		// �����ݴ��뵽���ݿ�
		user.setState(0); // 0:�����û�δ����.  1:�����û��Ѿ�����.
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		//���ͼ����ʼ�
		MailUtils.sendMail(user.getEmail(), code);
	}

	//ҵ�����ݼ������ѯ
	public User findByCode(String code) {
		return userDao.findByCode(code);	
	}

	// ҵ����޸��û�״̬
	public void update(User existUser) {
		userDao.update(existUser);
		
	}

	//ҵ����¼
	public User login(User user) {
		return userDao.login(user);
	}

	//ҵ����ѯ����ҳ���û�
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// ���õ�ǰҳ��:
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��:
		// ��ʾ5��
		int limit = 5;
		pageBean.setLimit(limit);
		// �����ܼ�¼��:
		int totalCount = 0;
		totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ����ÿҳ��ʾ���ݼ���:
		int begin = (page - 1)*limit;
		List<User> list = userDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//ҵ�������û�ID��ѯ�û�
	public User findByUid(Integer uid) {
		return userDao.findByUid(uid);
	}

	//ҵ���ɾ���û�
	public void delete(User existUser) {
		userDao.delete(existUser);
	}

}
