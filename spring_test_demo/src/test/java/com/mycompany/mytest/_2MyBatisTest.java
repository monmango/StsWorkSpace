package com.mycompany.mytest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml"})
public class _2MyBatisTest {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testSqlSessionFactory() {
		System.out.println("~~~~~sqlSessionFactory : "+sqlSessionFactory);
	}
	
	@Test
	public void testSqlSession() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println("~~~~~sqlSession : "+sqlSession);
	}
}
