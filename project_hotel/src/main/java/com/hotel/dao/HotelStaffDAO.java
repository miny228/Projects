package com.hotel.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.vo.HotelInquiryVO;
import com.hotel.vo.HotelSearchVO;
import com.hotel.vo.HotelStaffVO;

public class HotelStaffDAO extends DBConn{


@Autowired
private SqlSessionTemplate sqlSession;
	

	/**
	 * getStaffContent :  직원상세보기
	 */
	public HotelStaffVO getStaffContent(String sid) {
		return sqlSession.selectOne("mapper.hotel.staff.getContent", sid);
	}


	/**
	 * getSearch : 문의글 검색
	 * searchlist - 제목, 작성자 / keyword - 검색값
	 */
	public ArrayList<HotelStaffVO> getSearch(int startCount, int endCount, String searchlist, String keyword){
		
		HotelSearchVO vo = new HotelSearchVO();
		vo.setStart(startCount);
		vo.setEnd(endCount);
		vo.setSearchlist(searchlist);
		vo.setKeyword(keyword);
		
		List<HotelStaffVO> list = sqlSession.selectList("mapper.hotel.staff.getStaffSearch", vo);
		
		return (ArrayList<HotelStaffVO>)list;
	}
	
	/**
	 * totalCount : 직원 카운트
	 */
	public int totalCount() {
		return sqlSession.selectOne("mapper.hotel.staff.totalCount");
	}

	/**
	 * selectAll : 직원 전체 리스트
	 */
	public ArrayList<HotelStaffVO> selectAll(int startCount, int endCount){
		
		//Map 타입의 객체를 생성하고, start / end 라는 키이름으로 파라미터를 넘긴다.
		//이때 startCount, endCount는 int형이라서 String.valueOf를 사용하여 형변환을 한다.
		Map<String, String> param = new HashMap<String, String>();
		param.put("start", String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));
		
		//부모타입으로 결과를 받아야함! --> 부모타입 = sqlSession.~();
		 List<HotelStaffVO> list = sqlSession.selectList("mapper.hotel.staff.staffList", param);
				
		//자식의 모습으로 형변환시켜야 한다.
		return (ArrayList<HotelStaffVO>)list;
	}

	/*
	 * insert : 회원가입
	 */
	public int insert(HotelStaffVO vo) {
		return sqlSession.insert("mapper.hotel.staff.join",vo);	//오토와이어드id값.dcl("네임스페이스.id값, 파라미터값) 메퍼에서 받아온다.
	}

	
	/*
	 * sidCheck : 아이디 중복 체크
	 */
	public int sidCheck(String sid) {
		return sqlSession.selectOne("mapper.hotel.staff.sidcheck",sid);
	}

	
	
//
//
//     /*
//      * 회원 정보 불러오기
//      */
//	public HotelMemberVO memberContent(String mid) {
//		return sqlSession.selectOne("mapper.hotel.member.memberContent",mid);
//	}
//    /*
// 	 * 프로필수정(마이페이지)
// 	 */
//	public int memberUpdate(HotelMemberVO vo) {
//		return sqlSession.update("mapper.hotel.member.memberUpdate", vo);
//	}
//
//    /*
//	* 현재비밀번호변경 (마이페이지)
//	*/
//	public int mbrpassCheck(HotelMemberVO vo) {
//		return sqlSession.selectOne("mapper.hotel.member.mbrpassCheck", vo);
//	}
//	/*
//  	* 새비밀번호변경 (마이페이지)
//  	*/
//	public int updateMppw(HotelMemberVO vo) {
//		return sqlSession.update("mapper.hotel.member.updateMppw", vo);
//	}
//
//	/*
//	 * 비밀번호변경 (이메일전송)
//	 */
//	public int updatePw(HotelMemberVO vo) {
//		return sqlSession.update("mapper.hotel.member.updatePw", vo);
//	}
//	/*
//	 * 회원 조회(아이디,이메일)
//	 */
//	public int memberCheck(HotelMemberVO vo) {
//		return sqlSession.selectOne("mapper.hotel.member.memberCheck", vo);
//	}
//	/*
//	 * 회원 조회(name,폰번호)
//	 * 
//	 */
//	public int nameCheck(HotelMemberVO vo) {
//		return sqlSession.selectOne("mapper.hotel.member.nameCheck", vo);
//	}
//	/*
//	 * 아이디찾기 mid 이메일
//	 */
//	public HotelMemberVO findId(HotelMemberVO vo) {
//		return sqlSession.selectOne("mapper.hotel.member.findId", vo);
//	}
//		
//	
//	/*
//	 * select : 로그인
//	 */
//	public SessionVO select(HotelMemberVO vo) {
//		
//		
//		return sqlSession.selectOne("mapper.hotel.member.login",vo);
//	}
//	
//	
//	
//
//	/**
//	 * selectAll : 회원 전체 리스트
//	 */
//	public ArrayList<HotelMemberVO> selectAll(int startCount, int endCount){
//		
//		//Map 타입의 객체를 생성하고, start / end 라는 키이름으로 파라미터를 넘긴다.
//		//이때 startCount, endCount는 int형이라서 String.valueOf를 사용하여 형변환을 한다.
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("start", String.valueOf(startCount));
//		param.put("end", String.valueOf(endCount));
//		
//		//부모타입으로 결과를 받아야함! --> 부모타입 = sqlSession.~();
//		 List<HotelMemberVO> list = sqlSession.selectList("mapper.hotel.member.listAll", param);
//				
//		//자식의 모습으로 형변환시켜야 한다.
//		return (ArrayList<HotelMemberVO>)list;
//	}
//	
	
	
	/*
	 * select : 로그인
			public int select(HotelMemberVO vo) {
		
		
		return 0; 초안
		
	마이바티스
		
		
	/**		
	 *idCheck : 아이디 중복체크
	 */
	/*public int idCheck(String id) {
		int result = 0;
		String sql = "select count(id) from cgv_member "
				+ " where id=?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}			
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	} jdbc
	
	 */
	
	
	
	
}










  



















 



