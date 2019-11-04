package part01_template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemController {
	private MemDAO dao;

	public void setDao(MemDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value="/list.html", method=RequestMethod.GET)
	public ModelAndView process(ModelAndView mav) {
		dao.list();
		mav.addObject("aList", dao.list());
		mav.setViewName("view/part01/list");
		return mav;
	}
	
	@RequestMapping(value="/insert.html", method=RequestMethod.GET)
	public String insertForm() {
		return "view/part01/insert";
	}
	
	@RequestMapping(value="/insert.html", method=RequestMethod.POST)
	public String insertData(MemDTO dto) {
		dao.insertMethod(dto);
		return "redirect:/list.html";  //sendRedirect (list.html)과 같은 역할 
	}
	
	@RequestMapping(value="/update.html", method=RequestMethod.GET)
	public ModelAndView updateForm(int num, ModelAndView mav) {
		mav.addObject("dto", dao.updateMethod(num));
		mav.setViewName("view/part01/update");
		return mav;
	}
	
	@RequestMapping(value="/update.html", method=RequestMethod.POST)
	public String updateData(MemDTO dto) {
		dao.updateMethod(dto);
		return "redirect:/list.html";
	}
	
	@RequestMapping(value="/delete.html", method=RequestMethod.GET)
	public String delete(int num) {
		dao.deleteMethod(num);
		return "redirect:/list.html";
	}
}
