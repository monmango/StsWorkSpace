package part03_exam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class StopWatchAspect {
	public StopWatchAspect() {
		// TODO Auto-generated constructor stub
	}
	
	@Around("execution(* part03_exam.ServiceImp.prn(..))")
	public void timeData(ProceedingJoinPoint point) {
		long startTime = System.currentTimeMillis();

		Object returnObj = null;

		try {

		returnObj = point.proceed();

		} catch (Throwable e) {

		e.printStackTrace();

		}

		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);
	}
/*	@Around("execution(* part03_exam.ServiceImp.prn(..))")
	public void timeData(ProceedingJoinPoint point) {
		long start = System.currentTimeMillis();
		Object returnObj = null;
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		String time = point.getSignature().getName() + "_메서드 실행시간:" + (end-start);
		
		System.out.println(time);
	}
*/
	
}
