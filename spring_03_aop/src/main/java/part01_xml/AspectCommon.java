package part01_xml;

import org.aspectj.lang.ProceedingJoinPoint;

//공통 로직만 구현해놓은 클래스 - 공통 관점
public class AspectCommon {
	public AspectCommon() {
		// TODO Auto-generated constructor stub
	}
	
	public void comm1() {
		System.out.println("before");
	}
	
	public void comm2() {
		System.out.println("after");
	}
	
	public void comm3(String name) {
		System.out.println("comm3:" + name);
	}
	
	public void comm4(Exception ex) {
		if(ex!=null) {
			System.out.println(ex.toString());
		}
	}
	
	public void comm5(ProceedingJoinPoint point) {
		System.out.println("comm5 start");
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("comm5 end");
	}
}
