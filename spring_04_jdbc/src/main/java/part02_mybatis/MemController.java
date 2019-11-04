package part02_mybatis;

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

	@RequestMapping("/list2.do")
	public ModelAndView process(ModelAndView mav) {
		dao.list();
		mav.addObject("aList", dao.list());
		mav.setViewName("view/part02/list");
		return mav;
	}
	
	@RequestMapping(value="/insert2.do", method=RequestMethod.GET)
	public String insertForm() {
		return "view/part02/insert";
	}
	
	@RequestMapping(value="/insert2.do", method=RequestMethod.POST)
	public String insertData(MemDTO dto) {
		dao.insertMethod(dto);
		return "redirect:/list2.do";  //sendRedirect (list.do)과 같은 역할 
	}
	
	@RequestMapping(value="/update2.do", method=RequestMethod.GET)
	public ModelAndView updateForm(int num, ModelAndView mav) {
		mav.addObject("dto", dao.updateMethod(num));
		mav.setViewName("view/part02/update");
		return mav;
	}
	
	@RequestMapping(value="/update2.do", method=RequestMethod.POST)
	public String updateData(MemDTO dto) {
		dao.updateMethod(dto);
		return "redirect:/list2.do";
	}
	
	@RequestMapping(value="/delete2.do", method=RequestMethod.GET)
	public String delete(int num) {
		dao.deleteMethod(num);
		return "redirect:/list2.do";
	}
}
