package part04;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class SchedulerBean {

	
	//("0 15 5 * * *) = 5시 15분 0초 마다 메소드를 수행하라
	//("3 56 10 1 5 *) 5월 1일 10시 56분 3초 마다 메소드를 수행하라
	//*은 초 분 시 일 월 요일 [년도]
	@Scheduled(cron="3 * * * * *")
	public void scheduleRun() {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("스케줄 실행:"+dateFormat.format(calendar.getTime()));
		
	}
	
	
}
