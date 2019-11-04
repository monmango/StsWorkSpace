package part03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private Service svc;
	
	public MainController() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSvc(Service svc) {
		this.svc = svc;
	}
	
	@RequestMapping("thirdmain.sm")
	public void execute() {
		//트랜잭션이 설정된 메소드에서는  try~catch을 설정하면 안되고 메소드를 호출하는 곳에서 try~catch을 한다.
		try {
			svc.insertProcess();
			System.out.println("result:ok");
		} catch (Exception e) {
			System.out.println("result:"+e.toString());
		}
		
	}
}
