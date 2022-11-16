package com.spring.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.dao.ReplyInquiryDAO;
import com.hotel.vo.HotelInquiryVO;
import com.hotel.vo.ReplyInquiryVO;

public class ReplyInquiryServiceImpl implements ReplyInquiryService {

	@Autowired
	private ReplyInquiryDAO replyinquiryDao;
	
	
	/**
	 * ���Ǳ� �˻�
	 */
	@Override
	public ArrayList<HotelInquiryVO> getSearch(int startCount, int endCount, String searchlist, String keyword){
		ArrayList<HotelInquiryVO> list = replyinquiryDao.search(startCount, endCount, searchlist, keyword);

		return list;
	}
	
	
	/**
	 * ���Ǳ� �亯 �����ϱ�
	 */
	public int getDelte(String iid) {
		return replyinquiryDao.delete(iid);
	}
	
	
	/**
	 * �̴亯 ���Ǳ� ����
	 */
	@Override
	public ArrayList<HotelInquiryVO> replynoList(int startCount, int endCount) {
		ArrayList<HotelInquiryVO> list = replyinquiryDao.select(startCount, endCount);

		return list;
	}
	
	
	/**
	 *  ���Ǳ� �亯 �󼼺���
	 */
	public ReplyInquiryVO getRiid(String iid) {
		return replyinquiryDao.select(iid);
	}
	
	
	/**
	 * ���Ǳ� �亯���� ó��
	 */
	@Override
	public int getWriteResult(ReplyInquiryVO vo) {
		return replyinquiryDao.insert(vo);
	}

	
	/**
	 * ���Ǳ� iid ��������
	 */
	@Override
	public ArrayList<ReplyInquiryVO> getIid() {
		return replyinquiryDao.selectIid();
	}
	
	
	
}
