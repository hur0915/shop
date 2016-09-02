package cn.hur.shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.categorysecond.dao.CategorySecondDao;
import cn.hur.shop.categorysecond.vo.CategorySecond;
import cn.hur.shop.utils.PageBean;

/*
 * ��̨��������ģ��ҵ���
 */
@Transactional
public class CategorySecondService {
	
	//ע��CategorySecondDao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	//ҵ����ѯ���з�ҳ�Ķ�������
	public PageBean<CategorySecond> findByPage(int page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		//���ò���
		pageBean.setPage(page);
		//����ÿҳ��ʾ��¼��
		int limit = 10;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//����ҳ����ʾ���ݵļ���
		int begin = (page - 1) * limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//ҵ��㱣���������
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	//ҵ���ɾ����������
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	//ҵ�����ݶ�������ID��ѯ
	public CategorySecond fingByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}
		
	//ҵ�����¶�������
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}

	//ҵ����ѯ���ж�������
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}

}
