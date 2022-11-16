package com.hotel.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.vo.HotelInquiryVO;
import com.hotel.vo.HotelSearchVO;
import com.hotel.vo.SessionVO;

public class HotelInquiryDAO extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * searchcount : ���Ǳ� �˻� �Խù� ���� ���(������!)
	 */
	public int searchCount(String searchlist, String keyword) {

		Map<String,String> param = new HashMap<String,String>();
		param.put("searchlist", searchlist);
		param.put("keyword", keyword);
		
		return sqlSession.selectOne("mapper.inquiry.searchcount");
		
//		int result = 0;
//		
//		
//		String sqlsearch = "";
//		//System.out.println(searchlist);
//		
//		
//		if(searchlist.equals("title")) {
//			sqlsearch = "title";
//			//System.out.println(sqlsearch);
//		}else if(searchlist.equals("writer")){
//			/*���� ȸ�������� ���̵�� ����*/
//			sqlsearch = "iid";
//			//System.out.println(sqlsearch);
//		}
//		
//		String sql = "select count(*) from hotel_inquiry where "+sqlsearch+" like '%"+ keyword+"%'";
//		
//		try {
//			getPreparedStatment(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				result = rs.getInt(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
	}
	
	/**
	 * mysearch : ���ǹ��Ǳ� �˻�
	 */
	public ArrayList<HotelInquiryVO> mysearch(String searchlist, String keyword, String mid){
		
		HotelSearchVO vo = new HotelSearchVO();
		
//		vo.setStart(startCount);
//		vo.setEnd(endCount);
		vo.setSearchlist(searchlist);
		vo.setKeyword(keyword);
		vo.setMid(mid);
		
		List<HotelInquiryVO> mlist = sqlSession.selectList("mapper.inquiry.mysearch", vo);
		
		return (ArrayList<HotelInquiryVO>)mlist;
	}	
	
	
	/**
	 * search : ���Ǳ� �˻�
	 * searchlist - ����, �ۼ��� / keyword - �˻���
	 */
	public ArrayList<HotelInquiryVO> search(int startCount, int endCount, String searchlist, String keyword){
		
		HotelSearchVO vo = new HotelSearchVO();
		vo.setStart(startCount);
		vo.setEnd(endCount);
		vo.setSearchlist(searchlist);
		vo.setKeyword(keyword);
		
		List<HotelInquiryVO> list = sqlSession.selectList("mapper.inquiry.search", vo);
		
		return (ArrayList<HotelInquiryVO>)list;
		
//		String sqlsearch="";
//		
//		if(searchlist.equals("title")) {
//			sqlsearch = "title";
//			//System.out.println(sqlsearch);
//		}else if(searchlist.equals("writer")) {
//			/* ���߿� ȸ�������� ���̵� ������ �����ؾ���! */
//			sqlsearch="iid";
//			//System.out.println(sqlsearch);
//		}
		
		//�Ķ���͸� Map���� ����
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("start", String.valueOf(startCount));
//		param.put("end", String.valueOf(endCount));
//		param.put("searchlist", searchlist);
//		param.put("keyword", keyword);	
//		System.out.println(param.get("start"));
//		System.out.println(param.get("end"));
//		System.out.println(param.get("searchlist"));
//		System.out.println(param.get("keyword"));
		
		
		//ArrayList<HotelInquiryVO> list = new ArrayList<HotelInquiryVO>();
		
		
//		String sql = " select rno, iid, category, title, content, secret, secretnum, ifile, isfile, idate "
//				+ " from (select rownum rno, iid, category, title, content, secret, secretnum, ifile, isfile, idate "
//				+ " from (select iid, category, title, content, secret, secretnum, ifile, isfile, idate from hotel_inquiry "
//				+ " where "+sqlsearch+" like '%"+ keyword+"%' order by idate desc)) where rno between  ? and ? ";
//		
//		try {
//			getPreparedStatment(sql);
//			pstmt.setInt(1, startCount);
//			pstmt.setInt(2, endCount);
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				HotelInquiryVO vo = new HotelInquiryVO();
//				vo.setRno(rs.getInt(1));
//				vo.setIid(rs.getString(2));
//				vo.setCategory(rs.getString(3));
//				vo.setTitle(rs.getString(4));
//				vo.setContent(rs.getString(5));
//				vo.setSecret(rs.getInt(6));
//				vo.setSecretnum(rs.getInt(7));
//				vo.setIfile(rs.getString(8));
//				vo.setIsfile(rs.getString(9));
//				vo.setIdate(rs.getString(10));
//				
//				list.add(vo);
//			}
//			
//			close();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
	}
	
	
	/**
	 * faqsearch : �� �˻�
	 */
	public ArrayList<HotelInquiryVO> faqsearch(int startCount, int endCount, String searchlist, String keyword){
		
		HotelSearchVO vo = new HotelSearchVO();
		vo.setStart(startCount);
		vo.setEnd(endCount);
		vo.setSearchlist(searchlist);
		vo.setKeyword(keyword);
		
		List<HotelInquiryVO> list = sqlSession.selectList("mapper.inquiry.faqsearch", vo);
		
		return (ArrayList<HotelInquiryVO>)list;
	}
	
	
	
	
	/**
	 * passCheck : ���Ǳ� �󼼺��� ��й�ȣ üũ
	 */
	public int passCheck(String iid, String pass) {
		
		//System.out.println(iid);
		//System.out.println(pass);
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("iid", iid);
		param.put("pass", pass);
		
		
		//System.out.println(param.get(pass));
		
		return sqlSession.selectOne("mapper.inquiry.passcheck",param);
		
//		int result = 0;
//		String sql = " select count(secretnum) from hotel_inquiry where iid=? and secretnum=? ";
//		//System.out.println(iid+pass);
//		
//		try {
//			getPreparedStatment(sql);
//			pstmt.setString(1, iid);
//			pstmt.setString(2, pass);
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				result = rs.getInt(1);
//			}
//			
//			close();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
		
	}
	
	//����¡ ó��
	/**
	 * myCount : ���� ���Ǳ� DB���� ������ ��ü ���(��ü �ο�� ���)
	 **/
		public int myCount(String mid) {
			
			return sqlSession.selectOne("mapper.inquiry.mycount",mid);
		}	
	
	
	
	//����¡ ó��
	/**
	 * totalCount : DB���� ������ ��ü ���(��ü �ο�� ���)
	 **/
		public int totalCount(HotelInquiryVO vo) {
//			int result = 0;
//			String sql = " select count(*) from hotel_inquiry ";
//			
//			try {
//				getPreparedStatment(sql);
//				rs = pstmt.executeQuery();
//				while(rs.next()) {
//					result = rs.getInt(1);
//				}
//				
//				//close();
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}

			return sqlSession.selectOne("mapper.inquiry.totalcount", vo);
		}	
	
	/**
	 * delete :  ���Ǳ� �����ϱ�	
	 */
		public int delete(String iid) {
//			int result = 0;
//			String sql = " delete from hotel_inquiry where iid=? ";
//			
//			try {
//				getPreparedStatment(sql);
//				pstmt.setString(1, iid);
//				
//				result = pstmt.executeUpdate();
//				
//				close();
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
			return sqlSession.delete("mapper.inquiry.delete",iid);
			
		}
				
	/**
	 * update : ���Ǳ� �����ϱ�	
	 */
	public int update(HotelInquiryVO vo) {
		return sqlSession.update("mapper.inquiry.update", vo);
	}
	
	/**
	 * updatenofile : ���Ǳ� ���� ���Ͼ����� �������� ����	
	 */
	public int updatenofile(HotelInquiryVO vo) {
		return sqlSession.update("mapper.inquiry.updatenofile", vo);
	}
	
	
	/**
	 * myselect : ���� ���Ǳ� ����Ʈ ���
	 */
	public ArrayList<HotelInquiryVO> myselect(String mid, int startCount, int endCount) {
		
		HotelSearchVO vo = new HotelSearchVO();
		vo.setStart(startCount);
		vo.setEnd(endCount);
		vo.setMid(mid);
		
		//System.out.println(vo.getMid()+"11111111111");
		
		List<HotelInquiryVO> mlist = sqlSession.selectList("mapper.inquiry.mylist", vo);
		
		return (ArrayList<HotelInquiryVO>)mlist;	
		
	}
	
	
	/**
	 * select : ���Ǳ� ��ü ����Ʈ ���
	 */
	public ArrayList<HotelInquiryVO> select(int startCount, int endCount){
		
		//�Ķ���͸� Map���� ����
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		List<HotelInquiryVO> list = sqlSession.selectList("mapper.inquiry.list", param);
		
		return (ArrayList<HotelInquiryVO>)list;
		
//		String sql = " SELECT RNO, IID, CATEGORY, TITLE, SECRET, SECRETNUM, CONTENT, IDATE, RCOUNT FROM"
//				+ "    (SELECT ROWNUM RNO, IID, CATEGORY, TITLE, SECRET, SECRETNUM, CONTENT, IDATE, rcount FROM "
//				+ "        (SELECT IID, CATEGORY, TITLE, SECRET, SECRETNUM, CONTENT, IDATE, count(rcount) rcount FROM "
//				+ "            (SELECT hi.IID, CATEGORY, TITLE, SECRET, SECRETNUM, CONTENT, IDATE, ri.iid rcount "
//				+ "                FROM hotel_inquiry hi, reply_inquiry ri "
//				+ "                where hi.iid = ri.iid(+) "
//				+ "                ) "
//				+ "        GROUP BY IID, CATEGORY, TITLE, SECRET, SECRETNUM, CONTENT, IDATE "
//				+ "        order by idate desc "
//				+ "        )       "
//				+ "    ) "
//				+ "WHERE RNO BETWEEN ? AND ? ";
//		
//		try {
//			getPreparedStatment(sql);
//			pstmt.setInt(1, startCount);
//			pstmt.setInt(2, endCount);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				HotelInquiryVO vo = new HotelInquiryVO();
//				vo.setRno(rs.getInt(1));
//				vo.setIid(rs.getString(2));
//				vo.setCategory(rs.getString(3));
//				vo.setTitle(rs.getString(4));
//				vo.setSecret(rs.getInt(5));
//				vo.setSecretnum(rs.getInt(6));
//				vo.setContent(rs.getString(7));
//				vo.setIdate(rs.getString(8));
//				vo.setRcount(rs.getInt(9));
//				
//				list.add(vo);
//			}
//			
//			close();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
	}
		
	
	/**
	 * select : ���Ǳ� �󼼺���
	 */
	public HotelInquiryVO select(String iid) {
		return sqlSession.selectOne("mapper.inquiry.content",iid);
		
	}
	
	
	/**
	 * insert : �Խñ� ���
	 **/
	public int insert(HotelInquiryVO vo) {				
		return sqlSession.insert("mapper.inquiry.insert", vo);
	}
	
	
}
