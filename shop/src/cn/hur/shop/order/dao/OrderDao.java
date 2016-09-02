package cn.hur.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hur.shop.order.vo.Order;
import cn.hur.shop.order.vo.OrderItem;
import cn.hur.shop.utils.PageHibernateCallback;

/*
 * 订单持久层
 */
public class OrderDao extends HibernateDaoSupport{

	//生成订单
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	//根据用户ID查询订单数量
	public int findCountByUid(Integer uid) {
		String hql="select count(*) from Order o where o.user.uid=?";
		List<Long> list=this.getHibernateTemplate().find(hql, uid);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//根据用户ID查询带分页的订单集合
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		String hql="from Order o where o.user.uid=? order by o.ordertime desc";
		List<Order> list=this.getHibernateTemplate().
				execute(new PageHibernateCallback(hql, new Object[]{uid}, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	//根据订单ID查询订单
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	//更新订单
	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
	}
	
	//统计订单个数
	public int findCount() {
		String hql = "select count(*) from Order";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//分页查询订单
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, null, begin, limit));
		return list;
	}

	//根据订单ID查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql = "from OrderItem oi where oi.order.oid = ?";
		List<OrderItem> list = this.getHibernateTemplate().find(hql, oid);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
