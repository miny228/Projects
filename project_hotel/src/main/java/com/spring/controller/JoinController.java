package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.vo.HotelMemberVO;
import com.hotel.vo.HotelStaffVO;
import com.spring.service.MemberServiceImpl;
import com.spring.service.StaffServiceImpl;



@Controller
public class JoinController {
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private StaffServiceImpl staffService;
	
	
	/*
	 * sid_check.do : ���̵� �ߺ� 
	 */
	@ResponseBody  //ajax 
	@RequestMapping(value="/sid_check.do",  method=RequestMethod.GET)
	public String sid_check(String sid){
	
		return String.valueOf(staffService.getSidCheck(sid));  
	}
	
	
	/*
	 * sjoinCheck.do  ȸ������ ó����
	 */
	@RequestMapping(value="/sjoinCheck.do",  method=RequestMethod.POST)
	public ModelAndView sjoinCheck(HotelStaffVO vo) {
		ModelAndView mv = new ModelAndView();
	
		int result = staffService.getJoin(vo);
		
		if(result == 1){
			mv.addObject("join_result","ok");
			mv.setViewName("/login/login");  //�α���â
	
		}else{
  
			mv.setViewName("error_page");
		}
		
		return mv;  
	} 
	
	
	/*
	 * staffJoin.do : ����ȸ������
	 */
	@RequestMapping(value="/staffJoin.do",  method=RequestMethod.GET)
	public String staffJoin() {
		return "/join/staffJoin";   
	} 
	
	/****************************************************************************************/
	

	/*
	 * joinCheck.do  ȸ������ ó����
	 */
	@RequestMapping(value="/joinCheck.do",  method=RequestMethod.POST)
	public ModelAndView joinCheck(HotelMemberVO vo) {
		ModelAndView mv = new ModelAndView();
	
			int result = memberService.getJoinResult(vo);
		
		if(result == 1){
			mv.addObject("join_result","ok");
			mv.setViewName("/login/login");  //�α���â
	
		}else{
  
			mv.setViewName("error_page");
		}
		
		return mv;  
	} 
	
	/*
	 * join.do 
	 */
	@RequestMapping(value="/join.do",  method=RequestMethod.GET)
	public String join() {
		return "/join/join";   // login �����ȿ� �ִ� login.jsp ������ �ǹ� �Ѵ�
	} 
	/*
	 * joinstep.do 
	 */
	@RequestMapping(value="/joinstep.do", method=RequestMethod.GET)
	public String joinstep() {
		return "/join/joinstep";
	}
	
	/*
	 * id_check.do : ���̵� �ߺ� 
	 */
	@ResponseBody  //ajax 
	@RequestMapping(value="/id_check.do",  method=RequestMethod.GET)
	public String id_check(String mid){
	
		return String.valueOf(memberService.getIdCheck(mid));  
	}
	
}











