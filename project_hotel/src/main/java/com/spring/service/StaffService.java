package com.spring.service;

import java.util.ArrayList;

import com.hotel.vo.HotelInquiryVO;
import com.hotel.vo.HotelStaffVO;


public interface StaffService {
	
	/*
	 * staff 관련
	 */
	HotelStaffVO getStaffContent(String sid); //직원상세정보
	ArrayList<HotelStaffVO> getSearch(int startCount, int endCount, String searchlist, String keyword); //직원검색
	int getTotalCount(); //직원 총 카운트
	ArrayList<HotelStaffVO> getStaffList(int startCount, int endCount); //직원 리스트
	int getSidCheck(String sid); // 아이디 중복체크
	int getJoin(HotelStaffVO vo); //회원가입 
	//SessionVO getLoginResult(HotelMemberVO vo); //로그인

	
//	
//	/*
//	 * 아이디찾기 , 비밀번호 찾기
//	 */
//	public void sendEmail(HotelMemberVO vo, String div) throws Exception; //이메일발송
//	public void sendEmail2(HotelMemberVO vo, String div) throws Exception; //이메일발송2 아이디찾기
//	public void findPw(HttpServletResponse resp, HotelMemberVO vo) throws Exception; //비밀번호찾기
//	public void findId(HttpServletResponse resp, HotelMemberVO vo) throws Exception; //아이디찾기
//	
//	/*
//	 * 마이페이지
//	 */
//	int passUpdate(HotelMemberVO vo);//새비밀번호 변경
//	int mbrpassCheck(HotelMemberVO vo); //현재비밀번호 체크
//	int memberUpdateCheck(HotelMemberVO vo); // 프로필수정 업데이트
//	HotelMemberVO getMemberContent(String mid); //회원 상세정보 
//	
}
