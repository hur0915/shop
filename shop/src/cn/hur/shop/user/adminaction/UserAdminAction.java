package cn.hur.shop.user.adminaction;

import cn.hur.shop.user.service.UserService;
import cn.hur.shop.user.vo.User;
import cn.hur.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * ��̨�û�ģ��Action��
 */
public class UserAdminAction extends ActionSupport implements ModelDriven<User>{
	
	//�������ݵ�ģ������
	private User user = new User();

	public User getModel() {
		return user;
	}
	
	// ע���û���Service
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//���յ�ǰҳ��page
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	//��̨��ѯ����ҳ�������û���ִ�з���
	public String findAll(){
		PageBean<User> pageBean = userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//��̨ɾ���û���ִ�з���
	public String delete(){
		User existUser = userService.findByUid(user.getUid());
		userService.delete(existUser);
		return "deleteSuccess";
	}
	
	//��̨�༭�û���ִ�з���
	public String edit(){
		user = userService.findByUid(user.getUid());
		return "editSuccess";
	}
	
	//��̨�����û���ִ�з���
	public String update(){
		userService.update(user);
		return "updateSuccess";
	}

}
