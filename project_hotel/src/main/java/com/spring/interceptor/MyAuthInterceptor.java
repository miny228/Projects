package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hotel.vo.SessionVO;

public class MyAuthInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
		//������ üũ�ϴ� ���� ����
		//1. request ��ü�� ���� session ������ ��������
		HttpSession session = request.getSession();
		
		//2. �α��� ���� ��, session�� �α��� ����Ű(mid) ��Ƽ� Ŭ���̾�Ʈ���� ����
		//�α����� ���� : �ڽ��� ID, �α������� ���� ����� : null
		SessionVO svo = (SessionVO)session.getAttribute("svo");
		
		if(svo == null) {
			//�α����� ���� ���� ����̸�,
			response.sendRedirect("http://localhost:9000/hotel/login.do?auth=fail");//�α��� �������� ������
			return false;
				
		}//if
			//�α����� ������ �� ���� �� ����!	
		return true; //�α��ο� �����ϸ� ���������� ���� �������� ������
		
	}
	
}

