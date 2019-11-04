package part02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//http://localhost:8090/myint/index.do
@Controller
public class IndexController {

	@RequestMapping("/index.do")
	public String process() {
		return "part02/index";
	}
	
}
