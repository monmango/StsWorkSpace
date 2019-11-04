package com.mycompany.mynaxacro.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.mynaxacro.dao.MemberDAO;
import com.mycompany.mynaxacro.domain.Member;

 
@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	public List<Member> selectMember() {
		return  dao.select();
	}

	@Transactional
	public int deleteMember(String del_id) {
		return dao.delete(del_id);
	}

	@Transactional
	public int insertMember(Member m) {
		return dao.insert(m);
	}

	@Transactional
	public int updateMember(Member m) {
		return dao.update(m);
	}

}
