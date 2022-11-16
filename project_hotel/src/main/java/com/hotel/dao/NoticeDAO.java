package com.hotel.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.vo.NoticeVO;


@Repository
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * �ֱ� �̺�Ʈ 3��
	 */
	public ArrayList<NoticeVO> getRecentEvent(){
		List<NoticeVO> list = sqlSession.selectList("mapper.notice.revent");
		return (ArrayList<NoticeVO>)list;
	}
	
	
	/**
	 * insert : �������� �۾��� 
	 */
	
	public int insert(NoticeVO vo) {
		return sqlSession.insert("mapper.notice.insert", vo);
	}
	
	/**
	 * update : �������� ������Ʈ 
	 */
	public int update(NoticeVO vo) {
		return sqlSession.update("mapper.notice.update", vo);
	}
	
	/**
	 * delete : �������� ������Ʈ 
	 */
	public int delete(NoticeVO vo) {
		return sqlSession.delete("mapper.notice.delete", vo);
	}	
	
	/**
	 * select : �������� �󼼺���
	 */
	public NoticeVO select(String nid) {
		return sqlSession.selectOne("mapper.notice.content", nid);
	}
	
	/**
	 * notice_list : �������� ����Ʈ
	 */
	
	public ArrayList<NoticeVO> select(int startCount, int endCount) {
		
		
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		List<NoticeVO> list = sqlSession.selectList("mapper.notice.notice_list", param);
		return (ArrayList<NoticeVO>)list;
	}
	/**
	 * event_list : �̺�Ʈ ����Ʈ
	 */
	
	public ArrayList<NoticeVO> event_select(int startCount, int endCount) {
		
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		List<NoticeVO> list = sqlSession.selectList("mapper.notice.event_list", param);
		return (ArrayList<NoticeVO>)list;
	}
	
	/**
	 * noticesearchtotalCount : ���� �˻� ����¡ ó�� �Խù� �� ����
	 */
	public int noticeSearchTotalCount(String search_option, String keyword) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("search_option", String.valueOf(search_option));
		param.put("keyword", String.valueOf(keyword));
		

		return sqlSession.selectOne("mapper.notice.noticesearchtotalcount",param);
	}
	/**
	 * eventsearchtotalCount : �̺�Ʈ �˻� ����¡ ó�� �Խù� �� ����
	 */
	public int eventSearchTotalCount(String search_option, String keyword) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("search_option", String.valueOf(search_option));
		param.put("keyword", String.valueOf(keyword));
		

		return sqlSession.selectOne("mapper.notice.eventsearchtotalcount",param);
	}
	/**
	 * noticetotalCount : ���� ����¡ ó�� �Խù� �� ����
	 */
	public int noticeTotalCount() {
		return sqlSession.selectOne("mapper.notice.noticetotalcount");
	}
	/**
	 * eventtotalCount : �̺�Ʈ ����¡ ó�� �Խù� �� ����
	 */
	public int eventTotalCount() {
		return sqlSession.selectOne("mapper.notice.eventtotalcount");
	}
	/**
	 * updateHits : ��ȸ�� ������Ʈ
	 */
	public int updateHits(String nid) {
		
		return sqlSession.update("mapper.notice.updatehits",nid);
	}
	
	/**
	 * notice_search : �˻� ���
	 */
	public ArrayList<NoticeVO> notice_list_search(int startCount, int endCount, String search_option, String keyword) {
		
		//Map Ÿ���� ��ü�� �����ϰ� start, end��� Ű�̸����� �Ķ���͸� �ѱ��.
		Map<String,String> param = new HashMap<String,String>();
		param.put("start", String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));
		param.put("search_option", String.valueOf(search_option));
		param.put("keyword", String.valueOf(keyword));
		

		List<NoticeVO> list = sqlSession.selectList("mapper.notice.notice_search",param);
		return (ArrayList<NoticeVO>)list;
	}
	/**
	 * event_search : �˻� ���
	 */
	public ArrayList<NoticeVO> event_list_search(int startCount, int endCount, String search_option, String keyword) {
		
		//Map Ÿ���� ��ü�� �����ϰ� start, end��� Ű�̸����� �Ķ���͸� �ѱ��.
		Map<String,String> param = new HashMap<String,String>();
		param.put("start", String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));
		param.put("search_option", String.valueOf(search_option));
		param.put("keyword", String.valueOf(keyword));


		List<NoticeVO> list = sqlSession.selectList("mapper.notice.event_search",param);
		return (ArrayList<NoticeVO>)list;
	}
}