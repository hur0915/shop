package cn.hur.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.order.vo.Order;
import cn.hur.shop.order.vo.OrderItem;
import cn.hur.shop.utils.PageHibernateCallback;

/*
 * �����־ò�
 */
public class OrderDao extends HibernateDaoSupport{

	//���ɶ���
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	//�����û�ID��ѯ��������
	public int findCountByUid(Integer uid) {
		String hql="select count(*) from Order o where o.user.uid=?";
		List<Long> list=this.getHibernateTemplate().find(hql, uid);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//�����û�ID��ѯ����ҳ�Ķ�������
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		String hql="from Order o where o.user.uid=? order by o.ordertime desc";
		List<Order> list=this.getHibernateTemplate().
				execute(new PageHibernateCallback(hql, new Object[]{uid}, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	//���ݶ���ID��ѯ����
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	//���¶���
	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
	}
	
	//ͳ�ƶ�������
	public int findCount() {
		String hql = "select count(*) from Order";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//��ҳ��ѯ����
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, null, begin, limit));
		return list;
	}

	//���ݶ���ID��ѯ������
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql = "from OrderItem oi where oi.order.oid = ?";
		List<OrderItem> list = this.getHibernateTemplate().find(hql, oid);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
