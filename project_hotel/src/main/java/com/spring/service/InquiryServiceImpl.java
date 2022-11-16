package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.dao.HotelInquiryDAO;
import com.hotel.vo.HotelInquiryVO;
import com.hotel.vo.SessionVO;

public class InquiryServiceImpl implements InquiryService {

	@Autowired
	private HotelInquiryDAO hotelinquiryDao;
	
	/**
	 * ���� ���Ǳ� ����Ʈ
	 */
	@Override
	public ArrayList<HotelInquiryVO> getMyList(String mid, int startCount, int endCount){
		ArrayList<HotelInquiryVO> mlist = hotelinquiryDao.myselect(mid, startCount, endCount);

		return mlist;
	}
	
	/**
	 * ���Ǳ� �˻� �Խù� ���� ���
	 */
	@Override
	public int getSearchCount(String searchlist, String keyword) {
		return hotelinquiryDao.searchCount(searchlist, keyword);
	}
	
	/**
	 * ���� ���Ǳ� �˻� ó�� 
	 */
	public ArrayList<HotelInquiryVO> getMySearch(String searchlist, String keyword, String mid){
		
		ArrayList<HotelInquiryVO> mlist = hotelinquiryDao.mysearch(searchlist, keyword, mid);
		
		return mlist;
	}
	
	/**
	 * ���Ǳ� �˻� ó��
	 */
	@Override
	public ArrayList<HotelInquiryVO> getSearch(int startCount, int endCount, String searchlist, String keyword){
		ArrayList<HotelInquiryVO> list = hotelinquiryDao.search(startCount, endCount, searchlist, keyword);

		return list;
	}
	
	
	/**
	 * faq �˻� ó��
	 */
	@Override
	public ArrayList<HotelInquiryVO> getFaqSearch(int startCount, int endCount, String searchlist, String keyword){
		ArrayList<HotelInquiryVO> list = hotelinquiryDao.faqsearch(startCount, endCount, searchlist, keyword);

		return list;
	}
	
	
	/**
	 * ���Ǳ� �󼼺��� ���üũ
	 */
	@Override
	public int getPassCheck(String iid, String pass) {
		//HotelInquiryDAO dao = new HotelInquiryDAO(); 
		//int result = hotelinquiryDao.passCheck(iid, pass);
		
		return hotelinquiryDao.passCheck(iid, pass);
	}
	
	/**
	 * ���Ǳ� ���� ó��
	 */
	 @Override 
	 public int getDelete(String iid) {	
		return hotelinquiryDao.delete(iid);
	 }
	
	/**
	* ���Ǳ� �� �󼼺���
	*/
	
	@Override 
	public HotelInquiryVO getContent(String iid) { 
		return hotelinquiryDao.select(iid); 
	 }
	 	
	/**
	 * ���Ǳ� ���� ó��
	 */
	
	 @Override 
	 public int getUpdate(HotelInquiryVO vo) { 
		 return hotelinquiryDao.update(vo); 
	  }
	 
	 /**
	  * ���Ǳ� ���� ó�� : ���Ͼ��� �� �������� ����
	  */
	 @Override 
	 public int getUpdateNoFile(HotelInquiryVO vo) { 
	     return hotelinquiryDao.updatenofile(vo); 
	 }
	  	
	/**
	 * ���Ǳ� �۾��� ó��
	 */
	@Override 
	public int getWriteResult(HotelInquiryVO vo) { 
		return hotelinquiryDao.insert(vo); 
	}
			 
	/**
	 * ���Ǳ� ��ü �� ��
	 */
	@Override
	public int getTotalCount(HotelInquiryVO vo) {
		return hotelinquiryDao.totalCount(vo);
	}
	
	/**
	 * ���ǹ��Ǳ� ��ü �� ��
	 */
	@Override
	public int getMyCount(String mid) {
		return hotelinquiryDao.myCount(mid);
	}
	
	/**
	 * �Խ��� ��ü �� ����Ʈ
	 */
	@Override
	public ArrayList<HotelInquiryVO> getBoardList(int startCount, int endCount) {
		ArrayList<HotelInquiryVO> list = hotelinquiryDao.select(startCount, endCount);

		return list;
	}

	

}
