package part01_basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 컨테이너(container)
 * 1 ApplicationContext - container생성될때
 * 2 WebApplicationContext - was(tomcat)가 실행될때
 */

/*
 * <용어정리>
 * IOC( Inversion Of Control) :인스턴스의 생성 및 소멸 등의 생명 주기와 사용 범위까지 개발자가 아닌 Spring Container가 관리하는 등, 자원의 제어 역할이 개발자가 아닌 Container에게 역전되었음을 뜻 함.
 * DL (Dependency Lookup) : 의존성 검색이란 뜻으로 컨테이너가 제공하는 API 함수로 필요한 Bean을 검색하여 사용하는 방식.
 * DI (Dpendency Injection) : 의존성 주입이란 뜻으로 Beans 설정정보를 이용해 IOC 컨테이너가 자동으로 객체를 연결해주는 방식.
 */

public class SpringTest {
	public static void main(String[] args) {
		String path="part01_basic/di.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		Service svc = (Service)context.getBean("svc");
		svc.prn();
		
	}
}
