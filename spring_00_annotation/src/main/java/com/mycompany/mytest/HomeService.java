package com.mycompany.mytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//<bean id="homeService" class="com.mycompany.mytest.HomeService">
//	<property name="homeDAO" ref="homeDAO" />
//</bean>
@Service
public class HomeService {
	@Autowired
	private HomeDAO homeDAO;
	
	public HomeService() {
		// TODO Auto-generated constructor stub
	}
	
	public void setHomeDAO(HomeDAO homeDAO) {
		this.homeDAO = homeDAO;
	}
	
	public void process() {
		System.out.println("HomeService process()");
		homeDAO.getAllData();
	}
}
