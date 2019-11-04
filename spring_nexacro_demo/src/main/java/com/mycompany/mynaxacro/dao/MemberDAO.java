package com.mycompany.mynaxacro.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mynaxacro.domain.Member;

 

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insert(Member member) {
		return sqlSession.insert("insert",member);
	}
	
	public List<Member> select() {
		return sqlSession.selectList("select");
	}
	
	public int delete(String del_id) {
		return sqlSession.delete("delete",del_id);
	}

	public int update(Member m) {
		return sqlSession.update("update",m);
	}

	

}
