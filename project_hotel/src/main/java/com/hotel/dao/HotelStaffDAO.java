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
	 * getStaffContent :  �����󼼺���
	 */
	public HotelStaffVO getStaffContent(String sid) {
		return sqlSession.selectOne("mapper.hotel.staff.getContent", sid);
	}


	/**
	 * getSearch : ���Ǳ� �˻�
	 * searchlist - ����, �ۼ��� / keyword - �˻���
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
	 * totalCount : ���� ī��Ʈ
	 */
	public int totalCount() {
		return sqlSession.selectOne("mapper.hotel.staff.totalCount");
	}

	/**
	 * selectAll : ���� ��ü ����Ʈ
	 */
	public ArrayList<HotelStaffVO> selectAll(int startCount, int endCount){
		
		//Map Ÿ���� ��ü�� �����ϰ�, start / end ��� Ű�̸����� �Ķ���͸� �ѱ��.
		//�̶� startCount, endCount�� int���̶� String.valueOf�� ����Ͽ� ����ȯ�� �Ѵ�.
		Map<String, String> param = new HashMap<String, String>();
		param.put("start", String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));
		
		//�θ�Ÿ������ ����� �޾ƾ���! --> �θ�Ÿ�� = sqlSession.~();
		 List<HotelStaffVO> list = sqlSession.selectList("mapper.hotel.staff.staffList", param);
				
		//�ڽ��� ������� ����ȯ���Ѿ� �Ѵ�.
		return (ArrayList<HotelStaffVO>)list;
	}

	/*
	 * insert : ȸ������
	 */
	public int insert(HotelStaffVO vo) {
		return sqlSession.insert("mapper.hotel.staff.join",vo);	//������̾��id��.dcl("���ӽ����̽�.id��, �Ķ���Ͱ�) ���ۿ��� �޾ƿ´�.
	}

	
	/*
	 * sidCheck : ���̵� �ߺ� üũ
	 */
	public int sidCheck(String sid) {
		return sqlSession.selectOne("mapper.hotel.staff.sidcheck",sid);
	}

	
	
//
//
//     /*
//      * ȸ�� ���� �ҷ�����
//      */
//	public HotelMemberVO memberContent(String mid) {
//		return sqlSession.selectOne("mapper.hotel.member.memberContent",mid);
//	}
//    /*
// 	 * �����ʼ���(����������)
// 	 */
//	public int memberUpdate(HotelMemberVO vo) {
//		return sqlSession.update("mapper.hotel.member.memberUpdate", vo);
//	}
//
//    /*
//	* �����й�ȣ���� (����������)
//	*/
//	public int mbrpassCheck(HotelMemberVO vo) {
//		return sqlSession.selectOne("mapper.hotel.member.mbrpassCheck", vo);
//	}
//	/*
//  	* ����й�ȣ���� (����������)
//  	*/
//	public int updateMppw(HotelMemberVO vo) {
//		return sqlSession.update("mapper.hotel.member.updateMppw", vo);
//	}
//
//	/*
//	 * ��й�ȣ���� (�̸�������)
//	 */
//	public int updatePw(HotelMemberVO vo) {
//		return sqlSession.update("mapper.hotel.member.updatePw", vo);
//	}
//	/*
//	 * ȸ�� ��ȸ(���̵�,�̸���)
//	 */
//	public int memberCheck(HotelMemberVO vo) {
//		return sqlSession.selectOne("mapper.hotel.member.memberCheck", vo);
//	}
//	/*
//	 * ȸ�� ��ȸ(name,����ȣ)
//	 * 
//	 */
//	public int nameCheck(HotelMemberVO vo) {
//		return sqlSession.selectOne("mapper.hotel.member.nameCheck", vo);
//	}
//	/*
//	 * ���̵�ã�� mid �̸���
//	 */
//	public HotelMemberVO findId(HotelMemberVO vo) {
//		return sqlSession.selectOne("mapper.hotel.member.findId", vo);
//	}
//		
//	
//	/*
//	 * select : �α���
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
//	 * selectAll : ȸ�� ��ü ����Ʈ
//	 */
//	public ArrayList<HotelMemberVO> selectAll(int startCount, int endCount){
//		
//		//Map Ÿ���� ��ü�� �����ϰ�, start / end ��� Ű�̸����� �Ķ���͸� �ѱ��.
//		//�̶� startCount, endCount�� int���̶� String.valueOf�� ����Ͽ� ����ȯ�� �Ѵ�.
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("start", String.valueOf(startCount));
//		param.put("end", String.valueOf(endCount));
//		
//		//�θ�Ÿ������ ����� �޾ƾ���! --> �θ�Ÿ�� = sqlSession.~();
//		 List<HotelMemberVO> list = sqlSession.selectList("mapper.hotel.member.listAll", param);
//				
//		//�ڽ��� ������� ����ȯ���Ѿ� �Ѵ�.
//		return (ArrayList<HotelMemberVO>)list;
//	}
//	
	
	
	/*
	 * select : �α���
			public int select(HotelMemberVO vo) {
		
		
		return 0; �ʾ�
		
	���̹�Ƽ��
		
		
	/**		
	 *idCheck : ���̵� �ߺ�üũ
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










  



















 



