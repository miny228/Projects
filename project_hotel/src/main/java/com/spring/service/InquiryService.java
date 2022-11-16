package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.hotel.vo.HotelInquiryVO;

public interface InquiryService {
	
	//���Ǳ� �˻� - �Խù� ���
	int getSearchCount(String searchlist, String keyword);
	
	//���ǹ��Ǳ� �˻�
	ArrayList<HotelInquiryVO> getMySearch(String searchlist, String keyword, String mid);
	
	//���Ǳ� �˻�
	ArrayList<HotelInquiryVO> getSearch(int startCount, int endCount, String searchlist, String keyword);
	
	//faq �˻�
	ArrayList<HotelInquiryVO> getFaqSearch(int startCount, int endCount, String searchlist, String keyword);
	
	//���Ǳ� �󼼺��� ���üũ
	int getPassCheck(String iid, String pass);
	
	//���Ǳ� ���� ó�� 
	int getDelete(String iid);
	
	//���Ǳ� ���� ó�� 
	int getUpdate(HotelInquiryVO vo);
	
	//���Ǳ� ���� ó�� (���Ͼ��� �� �������� ����)
	int getUpdateNoFile(HotelInquiryVO vo);
	
	//���Ǳ� �󼼺��� 
	HotelInquiryVO getContent(String iid);
	
	//���Ǳ� �۾��� ó�� 
	int getWriteResult(HotelInquiryVO vo);
	 
	//���Ǳ� ��ü ��
	int getTotalCount(HotelInquiryVO vo);
	
	//���� ���Ǳ� ��ü ��
	int getMyCount(String mid);
	
	//���Ǳ� ��ü ����Ʈ
	ArrayList<HotelInquiryVO> getBoardList(int startCount, int endCount);
	
	//���� ���Ǳ� ����Ʈ
	ArrayList<HotelInquiryVO> getMyList(String mid, int startCount, int endCount);
}

