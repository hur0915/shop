package cn.hur.shop.interceptor;

import org.apache.struts2.ServletActionContext;

import cn.hur.shop.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/*
 * Ȩ��������
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		//�ж��Ƿ��¼�������¼�����У����û�е�¼����ת����¼ҳ�档
		AdminUser adminUser = (AdminUser) ServletActionContext.getRequest()
				.getSession().getAttribute("existAdminUser");
		if(adminUser != null){
			//�Ѿ���¼��
			return actionInvocation.invoke();
		}else{
			//��ת����¼ҳ��
			ActionSupport support = (ActionSupport) actionInvocation.getAction();
			support.addActionError("����û�е�¼!û��Ȩ�޷���!");
			return "loginFail";
		}
	}

}
