package com.spring.service;

import java.util.ArrayList;

import com.hotel.vo.HotelInquiryVO;
import com.hotel.vo.ReplyInquiryVO;

public interface ReplyInquiryService {
	
	//�̴亯 ���
	ArrayList<HotelInquiryVO> replynoList(int startCount, int endCount);
	
	//���Ǳ� �˻�
	ArrayList<HotelInquiryVO> getSearch(int startCount, int endCount, String searchlist, String keyword);
	
	//���Ǳ� �亯��� ó�� 
	int getWriteResult(ReplyInquiryVO vo);
	 
	//���Ǳ� iid�� ��������
	ArrayList<ReplyInquiryVO> getIid();
	
	//���Ǳ� �亯 �󼼺��� iid
	ReplyInquiryVO getRiid(String iid);

	//���Ǳ� �亯 �����ϱ� iid
	int getDelte(String iid);
	
	
/*	
	//���Ǳ� �󼼺��� ���üũ
	int getPassCheck(String iid, String pass);
	
	//���Ǳ� ���� ó�� 
	int getDelete(String iid);
	
	//���Ǳ� ���� ó�� 
	int getUpdate(HotelInquiryVO vo);
	
	//���Ǳ� �󼼺��� 
	HotelInquiryVO getContent(String iid);
	
	//���Ǳ� ��ü ��
	int getTotalCount();
	
	//���Ǳ� ��ü ����Ʈ
	ArrayList<HotelInquiryVO> getBoardList(int startCount, int endCount);
*/	
}


