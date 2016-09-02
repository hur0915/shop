package cn.hur.shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.category.dao.CategoryDao;
import cn.hur.shop.category.vo.Category;

/*
 * һ������ģ��ҵ���
 */
@Transactional
public class CategoryService {
	
	//ע��CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	//ҵ����ѯ����һ������
	public List<Category> findAll(){
		return categoryDao.findAll();
	}
	
	//ҵ��㱣��һ������
	public void save(Category category) {
		categoryDao.save(category);
	}

	//ҵ������һ������ID��ѯ
	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}

	//ҵ���ɾ��һ������
	public void delete(Category category) {
		categoryDao.delete(category);
		
	}

	//ҵ������һ������
	public void update(Category category) {
		categoryDao.update(category);
	}
	
}
