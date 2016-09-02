package cn.hur.shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hur.shop.categorysecond.dao.CategorySecondDao;
import cn.hur.shop.categorysecond.vo.CategorySecond;
import cn.hur.shop.utils.PageBean;

/*
 * 后台二级分类模块业务层
 */
@Transactional
public class CategorySecondService {
	
	//注入CategorySecondDao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	//业务层查询带有分页的二级分类
	public PageBean<CategorySecond> findByPage(int page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		//设置参数
		pageBean.setPage(page);
		//设置每页显示记录数
		int limit = 10;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//设置页面显示数据的集合
		int begin = (page - 1) * limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层保存二级分类
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	//业务层删除二级分类
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	//业务层根据二级分类ID查询
	public CategorySecond fingByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}
		
	//业务层更新二级分类
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}

	//业务层查询所有二级分类
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}

}
