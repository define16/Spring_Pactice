package com.define.HelloWorld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.define.HelloWorld.VO.ProductVO;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	
	// return Ÿ�� void�϶�
	@RequestMapping("doA")
	public void doA() {
		logger.info("doA called.............................");
	}
	
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB called.............................");
	}
	
	// return Ÿ�� String�϶�
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC called.............................");
		return "result1"; //jsp ���� �̸�(jsp���Ͼȿ� �ִ� msg�� �Էµ� String ����
	}
	
	// Class(model)�� �̿��� ������ ����
	@RequestMapping("doD")
	public String doD(Model model) {
		ProductVO product = new ProductVO("Test", 5000);
		logger.info("doD called.............................");
		// ���� �̸��� ������ �ʴ� ��� �ڵ����� ����Ǵ� ��ü�� Ŭ������ �ձ��ڸ� �ҹ��ڷ� ó���� Ŭ�������� �̸����� ������
		// addAttribute("�𵨸�",��ü) ex) model.addAttribute("product",product)
		model.addAttribute(product);
		return "result2"; //jsp ���� �̸�(jsp���Ͽ� Class(model)�� ����
	}
	
	
	// Ư�� ��Ʈ�ѷ��� ������ ó���Ҷ� �ٸ� ��θ� ȣ���ؾ��ϴ� ��쿡 ���
	// �������� MVC�� Ư���� ���ڿ��� 'redirect:'�� �̿��ϴµ� ':'�� ����ϴ� ���� ������ �ʿ䰡 ����
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr) {
		logger.info("doE called.............................");
		rttr.addFlashAttribute("msg","This is the Message ! with redirected");
		return "redirect:/doF"; //jsp ���� �̸�(jsp���Ͽ� Class(model)�� ����
		// "redirect:/doF" -> "forward:/doF" �� ���� ����
	}
	
	
	@RequestMapping("doF")
	public String doF(String msg) {
		logger.info("doF called............................. "+msg);
		return "HelloWorld";
	}
	
}
