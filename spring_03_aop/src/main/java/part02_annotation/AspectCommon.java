package part02_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

//공통 로직만 구현해놓은 클래스 - 공통 관점
@Service
@Aspect
public class AspectCommon {
	public AspectCommon() {
		// TODO Auto-generated constructor stub
	}
	
	@Before("execution(* part02_annotation.ServiceImp.prn1(..))")
	public void comm1() {
		System.out.println("before");
	}
	
	@After("execution(* part02_annotation.ServiceImp.prn2(..))")
	public void comm2() {
		System.out.println("after");
	}
	
	@AfterReturning(value="execution(* part02_annotation.ServiceImp.prn3(..))", returning="name")
	public void comm3(String name) {
		System.out.println("comm3:" + name);
	}
	
	@AfterThrowing(value="execution(* part02_annotation.ServiceImp.prn4(..))", throwing="ex")
	public void comm4(Exception ex) {
		if(ex!=null) {
			System.out.println(ex.toString());
		}
	}
	
	@Around("execution(* part02_annotation.ServiceImp.prn5(..))")
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
