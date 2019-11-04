package part03;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//http://localhost:8090/myint/main.do
@Controller
public class HelloController {

	public HelloController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("main.do")
	public String execute() {
		return "part03/form";
	}
	
	/*//1초마다 콘솔에 출력 인자값을 받응 매개변수가 없다  . 리턴은 보이드
	@Scheduled(fixedDelay = 1000)
	public void scheduledProcess() throws Exception{
		System.out.println(new Date() + "스케줄링 처리완료");
	}*/
	
	
	
	
	
}//end
