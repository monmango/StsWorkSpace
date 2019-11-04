package com.mycompany.mytest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 실행할때 WAS(아파치-톰캣)은 실행하지 않음
 */
@RunWith(SpringJUnit4ClassRunner.class)//서버 안키고 테스트 하기 위해서 필요한 어노테이션
@ContextConfiguration(locations= {"file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml"})
public class _1DataSourceTest {
	
	@Autowired
	private DataSource datasource;
	
	@Test
	public void testConnection() {
		try {
			Connection conn=datasource.getConnection();
			System.out.println("확인용 conn : " + conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //end testConnection()
	
	@Test
	public void testQuery() {
		try {
			Connection conn=datasource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'), username \r\n" + 
					"from user_users");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println("현재시각 : "+rs.getString(1));
			System.out.println("사용자명 : "+rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //end testQuery()
	
} //end class
