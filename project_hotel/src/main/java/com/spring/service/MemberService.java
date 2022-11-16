package com.spring.service;

import javax.servlet.http.HttpServletResponse;

import com.hotel.vo.HotelMemberVO;
import com.hotel.vo.HotelStaffVO;
import com.hotel.vo.SessionVO;

public interface MemberService {
	
	/*
	 * �α��� ȸ������
	 */
	// int getLoginResult(HotelMemberVO vo); //�α���
	SessionVO getLoginResult(HotelMemberVO vo); //�α���
	int getJoinResult(HotelMemberVO vo); //ȸ������ 
	int getIdCheck(String mid); // ���̵� �ߺ�üũ
	
	/*
	 * ���̵�ã�� , ��й�ȣ ã��
	 */
	public void sendEmail(HotelMemberVO vo, String div) throws Exception; //�̸��Ϲ߼�
	public void sendEmail2(HotelMemberVO vo, String div) throws Exception; //�̸��Ϲ߼�2 ���̵�ã��
	public void findPw(HttpServletResponse resp, HotelMemberVO vo) throws Exception; //��й�ȣã��
	public void findId(HttpServletResponse resp, HotelMemberVO vo) throws Exception; //���̵�ã��
	
	/*
	 * ����������
	 */
	int passUpdate(HotelMemberVO vo);//����й�ȣ ����
	int mbrpassCheck(HotelMemberVO vo); //�����й�ȣ üũ
	int memberUpdateCheck(HotelMemberVO vo); // �����ʼ��� ������Ʈ
	HotelMemberVO getMemberContent(String mid); //ȸ�� ������ 

	
}
