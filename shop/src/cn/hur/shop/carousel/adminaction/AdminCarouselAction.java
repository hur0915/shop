package cn.hur.shop.carousel.adminaction;


import java.util.List;

import cn.hur.shop.carousel.service.CarouselService;
import cn.hur.shop.carousel.vo.Carousel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * ��̨��ҳ���ģ��Aciton��
 */
public class AdminCarouselAction extends ActionSupport implements ModelDriven<Carousel>{
	
	//���ڽ������ݵ�ģ������
	private Carousel carousel =new Carousel();
	
	public Carousel getModel() {
		return carousel;
	}
	
	//ע��CarouselService
	private CarouselService carouselService;

	public void setCarouselService(CarouselService carouselService) {
		this.carouselService = carouselService;
	}
	
	//��̨��ѯ���й���ִ�з���
	public String findAll(){
		List<Carousel> caList=carouselService.findAll();
		//������ֵջ��
		ActionContext.getContext().getValueStack().set("caList", caList);
		//ҳ����ת
		return "findAll";
	}
	
	//��̨�������ִ�з���
	public String save(){
		//����Service��ɱ���һ������
		carouselService.save(carousel);
		//����ҳ����ת
		return "saveSuccess";
	}
	
	//��̨ɾ������ִ�з���
	public String delete(){
		// ����ɾ��һ���Ȳ�ѯ��ɾ��
		carousel=carouselService.findByCaid(carousel.getCaid());
		carouselService.delete(carousel);
		//ҳ����ת
		return "deleteSuccess";
	}
	
	//��̨�༭����ִ�з���
	public String edit(){
		//����caid���в�ѯ
		carousel=carouselService.findByCaid(carousel.getCaid());
		//ҳ����ת
		return "editSuccess";
	}
	
	//��̨�޸Ĺ���ִ�з���
	public String update(){
		//ʹ��ģ����������ǰ̨�ύ����
		carouselService.update(carousel);
		//ҳ����ת
		return "updateSuccess";
	}

}
