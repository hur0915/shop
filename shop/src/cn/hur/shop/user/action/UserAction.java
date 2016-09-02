package cn.hur.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.hur.shop.user.service.UserService;
import cn.hur.shop.user.vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * �û�ģ��Action��
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	//���ڽ������ݵ�ģ������
	private User user=new User();
	
	public User getModel() {	
		return user;
	}
	
	//������֤��
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	// ע��UserService
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//��ת��ע��ҳ���ִ�з���
	public String registPage() {
		return "registPage";
	}

	//AJAX�����첽У���û�����ִ�з���
	public String findByName() throws IOException{
		// �����û�����ѯ�û�
		User existUser=userService.findByUsername(user.getUsername());
		// ���response����ҳ�����
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		// �ж�
		if(existUser!=null){
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");	
		}
		else{
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return NONE;
	}
	
	//�û�ע���ִ�з���
	public String regist(){
		//�ж���֤�룬��sessionȡ����֤������ֵ
		String checkcode1=(String) ServletActionContext.getRequest().
				getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("��֤�����");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("ע��ɹ�!��ȥ���伤��!");
		return "msg";
	}
	
	//�û������ִ�з���
	public String active(){
		//���ݼ������ѯ�û�
		User existUser=userService.findByCode(user.getCode());
		// �ж�
		if (existUser == null) {
			// ���������
			this.addActionMessage("����ʧ��:���������!");
		} else {
			// ����ɹ�
			// �޸��û���״̬
			existUser.setState(1);
			existUser.setCode(null);//һ�μ���
			userService.update(existUser);
			this.addActionMessage("����ɹ�:��ȥ��¼!");
		}
		return "msg";
	}
	
	//��ת����¼ҳ���ִ�з���
	public String loginPage() {
		return "loginPage";
	}
	
	//�û���¼��ִ�з���
	public String login(){
		User existUser=userService.login(user);
		// �ж�
		if (existUser == null) {
			// ��¼ʧ��
			this.addActionError("��¼ʧ��:�û��������������û�δ����!");
			return LOGIN;
		} else {
			// ��¼�ɹ�
			// ���û�����Ϣ���뵽session��
			ServletActionContext.getRequest().getSession()
					.setAttribute("existUser", existUser);
			// ҳ����ת
			return "loginSuccess";
		}
	}
	
	//�û��˳���ִ�з���
	public String quit(){
		// ����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}

}
