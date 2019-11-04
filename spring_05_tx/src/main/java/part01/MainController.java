package part01;

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
	
	@RequestMapping("firstmain.st")
	public void execute() {
		svc.insertProcess();
	}
}
