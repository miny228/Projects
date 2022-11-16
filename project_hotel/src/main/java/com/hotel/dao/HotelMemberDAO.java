package com.hotel.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.vo.HotelMemberVO;
import com.hotel.vo.SessionVO;

public class HotelMemberDAO extends DBConn{


@Autowired
private SqlSessionTemplate sqlSession;
 	
     /*
      * ȸ�� ���� �ҷ�����
      */
	public HotelMemberVO memberContent(String mid) {
		return sqlSession.selectOne("mapper.hotel.member.memberContent",mid);
	}
    /*
 	 * �����ʼ���(����������)
 	 */
	public int memberUpdate(HotelMemberVO vo) {
		return sqlSession.update("mapper.hotel.member.memberUpdate", vo);
	}

    /*
	* �����й�ȣ���� (����������)
	*/
	public int mbrpassCheck(HotelMemberVO vo) {
		return sqlSession.selectOne("mapper.hotel.member.mbrpassCheck", vo);
	}
	/*
  	* ����й�ȣ���� (����������)
  	*/
	public int updateMppw(HotelMemberVO vo) {
		return sqlSession.update("mapper.hotel.member.updateMppw", vo);
	}

	/*
	 * ��й�ȣ���� (�̸�������)
	 */
	public int updatePw(HotelMemberVO vo) {
		return sqlSession.update("mapper.hotel.member.updatePw", vo);
	}
	/*
	 * ȸ�� ��ȸ(���̵�,�̸���)
	 */
	public int memberCheck(HotelMemberVO vo) {
		return sqlSession.selectOne("mapper.hotel.member.memberCheck", vo);
	}
	/*
	 * ȸ�� ��ȸ(name,����ȣ)
	 * 
	 */
	public int nameCheck(HotelMemberVO vo) {
		return sqlSession.selectOne("mapper.hotel.member.nameCheck", vo);
	}
	/*
	 * ���̵�ã�� mid �̸���
	 */
	public HotelMemberVO findId(HotelMemberVO vo) {
		return sqlSession.selectOne("mapper.hotel.member.findId", vo);
	}
	/*
	 * insert : ȸ������
	 */
	public int insert(HotelMemberVO vo) {
		return sqlSession.insert("mapper.hotel.member.join",vo);	//������̾��id��.dcl("���ӽ����̽�.id��, �Ķ���Ͱ�) ���ۿ��� �޾ƿ´�.
	}
	
	
	/*
	 * select : �α���
	 */
	public SessionVO select(HotelMemberVO vo) {
		
		
		return sqlSession.selectOne("mapper.hotel.member.login",vo);
	}
	
	
	/*
	 * idCheck : ���̵� �ߺ� üũ
	 */
	public int idCheck(String mid) {
	
		return sqlSession.selectOne("mapper.hotel.member.idcheck",mid);
		
	}

	/**
	 * selectAll : ȸ�� ��ü ����Ʈ
	 */
	public ArrayList<HotelMemberVO> selectAll(int startCount, int endCount){
		
		//Map Ÿ���� ��ü�� �����ϰ�, start / end ��� Ű�̸����� �Ķ���͸� �ѱ��.
		//�̶� startCount, endCount�� int���̶� String.valueOf�� ����Ͽ� ����ȯ�� �Ѵ�.
		Map<String, String> param = new HashMap<String, String>();
		param.put("start", String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));
		
		//�θ�Ÿ������ ����� �޾ƾ���! --> �θ�Ÿ�� = sqlSession.~();
		 List<HotelMemberVO> list = sqlSession.selectList("mapper.hotel.member.listAll", param);
				
		//�ڽ��� ������� ����ȯ���Ѿ� �Ѵ�.
		return (ArrayList<HotelMemberVO>)list;
	}
	
	
	
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










  



















 



