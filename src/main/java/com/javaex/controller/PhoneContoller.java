package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value="/guest")
public class PhoneContoller {

	//필드
	
	//생성자
	
	//메소드-GS
	
	//메소드-일반
	//수정
	@RequestMapping(value="/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > update");
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(personVo);
		System.out.println(personVo);
		return"redirect:/guest/list";
	}
	
	@RequestMapping(value="/updateForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(Model model, @RequestParam("no") int no) {
		System.out.println("PhoneController > updateForm");
		
		PhoneDao phoneDao = new PhoneDao();
		PersonVo personVo = phoneDao.getPerson(no);
		
		model.addAttribute("personVo", personVo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}
	
	//전화번호 삭제(파라미터로 받아오기)
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhoneController > delete");
		
		//파라미터에서 no꺼내기
		System.out.println(no);
		
		//Dao로 삭제하기
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personDelete(no);
		System.out.println(count + "건 삭제");

		return "redirect:/guest/list";
	}
	
	//전화번호 삭제(주소로 받아오기)
	@RequestMapping(value="/delete2/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete2(@PathVariable("no") int num) {
		System.out.println("PhoneController > delete");
		
		//파라미터에서 no꺼내기
		System.out.println(num);
		
		//Dao로 삭제하기
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personDelete(num);
		System.out.println(count + "건 삭제");
		
		return "redirect:/guest/list";
	}
	
	//전화번호 리스트
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController > list");
		
		//dao를 통해서 personlist(주소)를 가져온다.
		PhoneDao phoneDao= new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		
		//ds 데이터보내기 --> request attribute에 넣는다.
		model.addAttribute("personList", personList);
		
		
		System.out.println();
		
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > write");
//		System.out.println(name);
//		System.out.println(hp);
//		System.out.println(company);
		
		
		//파라미터 꺼내기+vo로 묶기를 DS해서 메소드의 파라미터로 보내준다.
		
		
		//Dao로 저장
//		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personInsert(personVo);
//		System.out.println(count);
		return "redirect:/guest/list";
		
	}
	
	@RequestMapping(value="/write2", method= {RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company) {
		System.out.println("PhoneController > write2");
//		System.out.println(name);
//		System.out.println(hp);
//		System.out.println(company);
		
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personInsert(personVo);
		System.out.println(count);
		return "redirect:/guest/list";
		
	}
	
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController > writeForm");
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	

	
	
	//테스트
//	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
//	public String test() {
//		System.out.println("PhoneController > test");
//		
//		return "/WEB-INF/views/test.jsp";
//	}
//	
	//등록메소드
	
	
	
	//수정메소드
	
	
	
	//삭제메소드
	
	
	
	//리스트메소드
	
	
	
	
}
