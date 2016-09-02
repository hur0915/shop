package cn.hur.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.order.dao.OrderDao;
import cn.hur.shop.order.vo.Order;
import cn.hur.shop.order.vo.OrderItem;
import cn.hur.shop.utils.PageBean;

/*
 * 订单业务层
 */
@Transactional
public class OrderService {

	//注入OrderDao
	private OrderDao orderDao;
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	//业务层生成订单
	public void save(Order order) {
		orderDao.save(order);
	}

	//业务层根据用户ID查询带分页的订单
	public PageBean<Order> findByUid(Integer uid, Integer page) {
		PageBean<Order> pageBean=new PageBean<Order>();
		//设置当前页数
		pageBean.setPage(page);
		//设置总记录数
		int totalCount=0;
		totalCount=orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		//设置每页显示数
		int limit=8;
		pageBean.setLimit(limit);
		//设置总页数
		int totalPage=0;
		if(totalCount % limit == 0){
			totalPage= totalCount / limit;
		}else{
			totalPage= totalCount / limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置每页显示的数据集合
		int begin=( page-1 ) * limit;
		List<Order> list=orderDao.findPageByUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层根据订单ID查询订单
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	//业务层更新订单
	public void update(Order currOrder) {
		orderDao.update(currOrder);	
	}
	
	//业务层查询所有订单
	public PageBean<Order> findAll(Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit = 10;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = orderDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//设置每页显示数据集合
		int begin = (page - 1) * limit;
		List<Order> list = orderDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		return orderDao.findOrderItem(oid);
	}

}
