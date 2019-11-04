package part04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//http://127.0.0.1:8090/mymvc/mem.htm
@Controller
public class HelloCommandController {

	@RequestMapping(value = "/mem.htm", method = RequestMethod.GET)
	public String form() {
		return "view/part04/memForm";
	}
	
	/*
	 * @RequestMapping(value = "/mem.htm", method = RequestMethod.POST) public
	 * ModelAndView submit(String name, int age, ModelAndView mav) {
	 * mav.addObject("name", name); mav.addObject("age", age);
	 * mav.setViewName("view/part04/memPro"); return mav; }
	 */
	
	
	/*
	 * @RequestMapping(value = "/mem.htm", method = RequestMethod.POST) public
	 * String submit(MemDTO dto) { return "view/part04/memPro"; }
	 */
	
	@RequestMapping(value = "/mem.htm", method = RequestMethod.POST)
	public String submit(@ModelAttribute("mdo") MemDTO dto) {
		return "view/part04/memPro";
	}
	
}
