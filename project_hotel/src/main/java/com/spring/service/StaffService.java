package com.spring.service;

import java.util.ArrayList;

import com.hotel.vo.HotelInquiryVO;
import com.hotel.vo.HotelStaffVO;


public interface StaffService {
	
	/*
	 * staff ����
	 */
	HotelStaffVO getStaffContent(String sid); //����������
	ArrayList<HotelStaffVO> getSearch(int startCount, int endCount, String searchlist, String keyword); //�����˻�
	int getTotalCount(); //���� �� ī��Ʈ
	ArrayList<HotelStaffVO> getStaffList(int startCount, int endCount); //���� ����Ʈ
	int getSidCheck(String sid); // ���̵� �ߺ�üũ
	int getJoin(HotelStaffVO vo); //ȸ������ 
	//SessionVO getLoginResult(HotelMemberVO vo); //�α���

	
//	
//	/*
//	 * ���̵�ã�� , ��й�ȣ ã��
//	 */
//	public void sendEmail(HotelMemberVO vo, String div) throws Exception; //�̸��Ϲ߼�
//	public void sendEmail2(HotelMemberVO vo, String div) throws Exception; //�̸��Ϲ߼�2 ���̵�ã��
//	public void findPw(HttpServletResponse resp, HotelMemberVO vo) throws Exception; //��й�ȣã��
//	public void findId(HttpServletResponse resp, HotelMemberVO vo) throws Exception; //���̵�ã��
//	
//	/*
//	 * ����������
//	 */
//	int passUpdate(HotelMemberVO vo);//����й�ȣ ����
//	int mbrpassCheck(HotelMemberVO vo); //�����й�ȣ üũ
//	int memberUpdateCheck(HotelMemberVO vo); // �����ʼ��� ������Ʈ
//	HotelMemberVO getMemberContent(String mid); //ȸ�� ������ 
//	
}
