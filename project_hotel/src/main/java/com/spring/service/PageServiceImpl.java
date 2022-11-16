package com.spring.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.vo.HotelInquiryVO;

public class PageServiceImpl {

	@Autowired
	private InquiryServiceImpl inquiryService;
	
	@Autowired
	private StaffServiceImpl staffService;
	
	@Autowired
	private NoticeServiceImpl noticeService;

	/***������*****/
	
	@Autowired
	private BasketServiceImpl basketService;
	
	@Autowired
	private BookServiceImpl bookService;
	
	@Autowired
	private MyroomServiceImpl myroomService; 
	
	/******* ����� ***********/
	
	/**
	 * ����¡ ó��
	 */
	public Map<String, Integer> getPageResult(String rpage, String serviceName, Object service) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 7;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
		int dbCount = 0;	//DB���� ������ ��ü ���
		
		if(serviceName.equals("inquiry")) {
			HotelInquiryVO vo = new HotelInquiryVO();
			vo.setRcount(0);
			inquiryService = (InquiryServiceImpl)service;
			dbCount = inquiryService.getTotalCount(vo);
			//pageSize=10; ���⼭ ������ ������ ������ �����ϴ�.
		
		}else if(serviceName.equals("notice")) {
			noticeService = (NoticeServiceImpl)service;
			dbCount = noticeService.getNoticeTotalCount();
			pageSize = 10;
		}else if(serviceName.equals("event")) {
			noticeService = (NoticeServiceImpl)service;
			dbCount = noticeService.getEventTotalCount();
			pageSize = 10;
		}else if(serviceName.equals("inquiry_replyno")) {
			HotelInquiryVO vo = new HotelInquiryVO();
			vo.setRcount(1);
			inquiryService = (InquiryServiceImpl)service;
			dbCount = inquiryService.getTotalCount(vo);
		}else if(serviceName.equals("basket")) {
			basketService = (BasketServiceImpl)service;
			dbCount = basketService.getTotalCount();
		}else if(serviceName.equals("book")) {
			bookService = (BookServiceImpl)service;
			dbCount = bookService.getTotalCount();
		}else if(serviceName.equals("staff")) {
			staffService = (StaffServiceImpl)service;
			dbCount = staffService.getTotalCount();
		}
				
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
				pageCount = dbCount/pageSize;
			}else{
				pageCount = dbCount/pageSize+1;
			}
				
		//��û ������ ���
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = pageSize;
		}
		
		//����Ÿ���� Map�� �����͸� �߰�
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("rpage", reqPage);
		param.put("pageCount", pageCount);
		
		return param;
	}
	
	/**
	 * ���� ����¡ ó��
	 */
	public Map<String, Integer> getMyPageResult(String rpage, String serviceName, Object service, String mid) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 7;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
		int dbCount = 0;	//DB���� ������ ��ü ���
		
		if(serviceName.equals("inquiry")) {
			HotelInquiryVO vo = new HotelInquiryVO();
			vo.setRcount(0);
			inquiryService = (InquiryServiceImpl)service;
			dbCount = inquiryService.getTotalCount(vo);
			//pageSize=10; ���⼭ ������ ������ ������ �����ϴ�.
		
		}else if(serviceName.equals("inquiry_replyno")) {
			HotelInquiryVO vo = new HotelInquiryVO();
			vo.setRcount(1);
			inquiryService = (InquiryServiceImpl)service;
			dbCount = inquiryService.getTotalCount(vo);
		}else if(serviceName.equals("myinquiry")) {
			inquiryService = (InquiryServiceImpl)service;
			dbCount = inquiryService.getMyCount(mid);
		}
				
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
				pageCount = dbCount/pageSize;
			}else{
				pageCount = dbCount/pageSize+1;
			}
				
		//��û ������ ���
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = pageSize;
		}
		
		//����Ÿ���� Map�� �����͸� �߰�
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("rpage", reqPage);
		param.put("pageCount", pageCount);
		
		return param;
	}
	
	
	/******* ������ ***********/
	
	
	/**
	 * ����¡ ó��
	 */
	public Map<String, Integer> getPageResult(String rpage, String serviceName, Object service,String mid) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 4;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
		int dbCount = 0;	//DB���� ������ ��ü ���
	
		if(serviceName.equals("myroom")) {
			myroomService = (MyroomServiceImpl)service;
			dbCount = myroomService.getTotalCount(mid);
		}
		
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		//��û ������ ���
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = pageSize;
		}
		
		//����Ÿ���� map�� ������ �߰�
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("rpage", reqPage);
		param.put("pageCount", pageCount);
		
		return param;
		
	}
	
	/**
	 * �����
	 */
	public Map<String, Integer> getNoticeSearchResult(String rpage, String serviceName, Object service, String search_option, String keyword) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 7;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
		int dbCount = 0;	//DB���� ������ ��ü ���
		
		if(serviceName.equals("notice")) {
			noticeService = (NoticeServiceImpl)service;
			dbCount = noticeService.getNoticeSearchTotalCount(search_option, keyword);
			pageSize = 10;
		}else if(serviceName.equals("event")) {
			noticeService = (NoticeServiceImpl)service;
			dbCount = noticeService.getEventSearchTotalCount(search_option, keyword);
			pageSize = 10;
		}
				
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
				pageCount = dbCount/pageSize;
			}else{
				pageCount = dbCount/pageSize+1;
			}
				
		//��û ������ ���
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = pageSize;
		}
		
		//����Ÿ���� Map�� �����͸� �߰�
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("rpage", reqPage);
		param.put("pageCount", pageCount);
		
		return param;
	}
	
}

