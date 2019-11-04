package part03_exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	private Service serviceImp;
	
	public void setServiceImp(Service serviceImp) {
		this.serviceImp = serviceImp;
	}
	
	public MainController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("main.ko")
	public String process() {
		serviceImp.prn();
		return "main";
	}
	
	
}
