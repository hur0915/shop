package cn.hur.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.order.dao.OrderDao;
import cn.hur.shop.order.vo.Order;
import cn.hur.shop.order.vo.OrderItem;
import cn.hur.shop.utils.PageBean;

/*
 * ����ҵ���
 */
@Transactional
public class OrderService {

	//ע��OrderDao
	private OrderDao orderDao;
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	//ҵ������ɶ���
	public void save(Order order) {
		orderDao.save(order);
	}

	//ҵ�������û�ID��ѯ����ҳ�Ķ���
	public PageBean<Order> findByUid(Integer uid, Integer page) {
		PageBean<Order> pageBean=new PageBean<Order>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//�����ܼ�¼��
		int totalCount=0;
		totalCount=orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		//����ÿҳ��ʾ��
		int limit=8;
		pageBean.setLimit(limit);
		//������ҳ��
		int totalPage=0;
		if(totalCount % limit == 0){
			totalPage= totalCount / limit;
		}else{
			totalPage= totalCount / limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//����ÿҳ��ʾ�����ݼ���
		int begin=( page-1 ) * limit;
		List<Order> list=orderDao.findPageByUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//ҵ�����ݶ���ID��ѯ����
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	//ҵ�����¶���
	public void update(Order currOrder) {
		orderDao.update(currOrder);	
	}
	
	//ҵ����ѯ���ж���
	public PageBean<Order> findAll(Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit = 10;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = orderDao.findCount();
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//����ÿҳ��ʾ���ݼ���
		int begin = (page - 1) * limit;
		List<Order> list = orderDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//ҵ����ѯ������
	public List<OrderItem> findOrderItem(Integer oid) {
		return orderDao.findOrderItem(oid);
	}

}
