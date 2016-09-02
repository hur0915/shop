package cn.hur.shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.category.dao.CategoryDao;
import cn.hur.shop.category.vo.Category;

/*
 * 一级分类模块业务层
 */
@Transactional
public class CategoryService {
	
	//注入CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	//业务层查询所有一级分类
	public List<Category> findAll(){
		return categoryDao.findAll();
	}
	
	//业务层保存一级分类
	public void save(Category category) {
		categoryDao.save(category);
	}

	//业务层根据一级分类ID查询
	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}

	//业务层删除一级分类
	public void delete(Category category) {
		categoryDao.delete(category);
		
	}

	//业务层更新一级分类
	public void update(Category category) {
		categoryDao.update(category);
	}
	
}
