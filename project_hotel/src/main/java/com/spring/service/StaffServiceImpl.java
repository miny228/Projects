package com.spring.service;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.dao.HotelMemberDAO;
import com.hotel.dao.HotelStaffDAO;
import com.hotel.vo.HotelMemberVO;
import com.hotel.vo.HotelStaffVO;
import com.hotel.vo.SessionVO;

public class StaffServiceImpl implements StaffService {
	
	
	@Autowired
	private HotelMemberDAO hotelMemberDAO; // 서블릿컨텍스트에 다오 객체 생성 오토와이어드로 뿌려주기.
	
	@Autowired
	private HotelStaffDAO hotelStaffDAO;
	
	
	/*****************************************
	 *  staff - 로그인, 회원가입, 검색, 상세정보
	 ****************************************/
	
	/**
	 * 직원 상세정보 보기
	 */
	public HotelStaffVO getStaffContent(String sid) {
		return hotelStaffDAO.getStaffContent(sid);
	}
	
	
	
	/**
	 * 직원 검색
	 */
	@Override
	public ArrayList<HotelStaffVO> getSearch(int startCount, int endCount, String searchlist, String keyword){
		ArrayList<HotelStaffVO> list = hotelStaffDAO.getSearch(startCount, endCount,searchlist, keyword);
		return list;
	}
	
	
	/**
	 * 직원 총 카운트
	 */
	@Override
	public int getTotalCount() {
		return hotelStaffDAO.totalCount();
	}
	
	
	/**
	 * 직원 전체 리스트
	 */
	@Override
	public ArrayList<HotelStaffVO> getStaffList(int startCount, int endCount){	
		ArrayList<HotelStaffVO> list = hotelStaffDAO.selectAll(startCount, endCount);
		
		return list;
	}	
	
	/**
	 * 회원가입 
	 */
	@Override
	public int getJoin(HotelStaffVO vo) {		
		int result = hotelStaffDAO.insert(vo);
		
		return result;
	}
	
	/**
	 *  아이디 중복체크
	 */
	@Override
	public int getSidCheck(String sid) {
		int result = hotelStaffDAO.sidCheck(sid);
		
		return result;
	}
	

//	/**
//	 *  로그인 
//	 */
//	@Override
//	public SessionVO getLoginResult(HotelMemberVO vo) {			
//		return hotelMemberDAO.select(vo);
//		
//		
//	}

//	
//	
//	/*****************************************
//	 *  마이페이지 
//	 ****************************************/
//	/**
//	 *  회원 상세 정보
//	 */
//	
//	@Override
//	public HotelMemberVO getMemberContent(String mid) {
//		return hotelMemberDAO.memberContent(mid);
//	}
//	/**
//	 *  비밀번호 수정 체크 
//	 */
//	@Override
//	public int mbrpassCheck(HotelMemberVO vo) {
//	
//		return hotelMemberDAO.mbrpassCheck(vo);
//		
//	}
//	
//	/**
//	 * 비밀번호 수정(마이페이지)
//	 */
//	@Override
//	public int passUpdate(HotelMemberVO vo) {
//		int result = hotelMemberDAO.updateMppw(vo);
//		
//		return result;
//	}
//	
//	/**
//	 * 프로필 수정(마이페이지)
//	 */
//	
//	@Override
//	public int memberUpdateCheck(HotelMemberVO vo) {
//		int result = hotelMemberDAO.memberUpdate(vo);
//		
//		return result;
//	}
//	
//	/*****************************************
//	 *  아이디찾기, 비밀번호찾기
//	 ****************************************/
//	
//	//비밀번호 찾기 이메일발송
//	@Override
//	public void sendEmail(HotelMemberVO vo, String div) throws Exception {
//		try {
//				Email email = new SimpleEmail(); 
//				email.setHostName("smtp.naver.com");
//				email.setSmtpPort(587) ;
//				email.setAuthenticator(new DefaultAuthenticator("fkiieyu4455@naver.com", "dlwlals1?")) ;
//				email.setStartTLSRequired(true) ;
//				email.setFrom("fkiieyu4455@naver.com") ;
//				email.setSubject("신라스테이 임시 비밀번호 입니다.") ;
//				
//				
//				
//			
//				email.setMsg(vo.getMid() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요."+"임시 비밀번호 :"+ vo.getPass());
//				email.addTo(vo.getHemail());  //받는사람
//				email.send();
//		
//				
//		} catch (Exception e) {
//			System.out.println("메일발송 실패 : " + e);
//		}
//	}
//
//	//비밀번호찾기
//	@Override
//	public void findPw(HttpServletResponse response, HotelMemberVO vo) throws Exception {
//		response.setContentType("text/html;charset=utf-8");
//		int checkresult = hotelMemberDAO.memberCheck(vo);
//		PrintWriter out = response.getWriter();
//		// 가입된 아이디가 없으면
//		if(checkresult == 0) {
//			out.print("등록되지 않은 회원입니다.");
//			out.close();
//		
//		}else {
//			// 임시 비밀번호 생성
//			String pw = "";
//			for (int i = 0; i < 12; i++) {
//				pw += (char) ((Math.random() * 26) + 97);
//			}
//			System.out.println(pw);
//			vo.setPass(pw);
//			// 비밀번호 변경
//			hotelMemberDAO.updatePw(vo);
//			// 비밀번호 변경 메일 발송
//			sendEmail(vo, "findpw");
//
//			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
//			out.close();
//		}
//	}
//	// 아이디찾기
//
//	@Override
//	public void sendEmail2(HotelMemberVO vo, String div) throws Exception {
//		
//		// 받는 사람 E-Mail 주소
//		try {
//				Email email = new SimpleEmail(); 
//				email.setHostName("smtp.naver.com");
//				email.setSmtpPort(587) ;
//				email.setAuthenticator(new DefaultAuthenticator("fkiieyu4455@naver.com", "dlwlals1?")) ;
//				email.setStartTLSRequired(true) ;
//				email.setFrom("fkiieyu4455@naver.com") ;
//				email.setSubject("회원님의 아이디입니다") ;
//				email.setMsg(vo.getHname() + "님의 아이디는" + vo.getMid()+ "입니다");
//				email.addTo(vo.getHemail());  //받는사람
//				email.send();
//		
//				
//		} catch (Exception e) {
//			System.out.println("메일발송 실패 : " + e);
//		}
//	}
//	//아이디찾기
//	@Override
//	public void findId(HttpServletResponse response, HotelMemberVO vo) throws Exception {
//		response.setContentType("text/html;charset=utf-8");
//		int checkresult = hotelMemberDAO.nameCheck(vo);
//		PrintWriter out = response.getWriter();
//		// 가입된 이름이 없으면
//		if(checkresult == 0) {
//			out.print("등록되지 않은 회원입니다.");
//			out.close();
//		
//		}else {
//			HotelMemberVO sendvo = hotelMemberDAO.findId(vo);
//			sendEmail2(sendvo, "findid");
//
//			}			
//		    out.print("등록된 이메일로 아이디를 발송하였습니다.");
//			out.close();
//		}
//	
	}

