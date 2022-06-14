package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Service
public class PhoneService {

	//필드
	@Autowired
	private PhoneDao phoneDao;
	
	
	//생성자
	
	
	//GS
	
	
	//일반
	
	public List<PersonVo> getPersonList(){
	
//		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		
		return personList;

	}

	public int personInsert(PersonVo personVo) {
		
		int count = phoneDao.personInsert(personVo);
		
		return count;
		
	}

	public int personDelete(int no) {
		
		int count = phoneDao.personDelete(no);
		
		return count;
		
	}
	
	public PersonVo getPerson(int no) {
		
		PersonVo personVo = (PersonVo)phoneDao.getPerson(no);
		
		return personVo;
	}

	public int personUpdate(PersonVo personVo) {
		
		int count = phoneDao.personUpdate(personVo);
		
		return count;
	}
}
