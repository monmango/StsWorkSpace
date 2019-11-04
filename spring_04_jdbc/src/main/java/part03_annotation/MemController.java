package part03_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemController {
	
	@Autowired
	private MemDAO dao;

	public void setDao(MemDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/list3.do")
	public ModelAndView process(ModelAndView mav) {
		dao.list();
		mav.addObject("aList", dao.list());
		mav.setViewName("view/part03/list");
		return mav;
	}
	
	@RequestMapping(value="/insert3.do", method=RequestMethod.GET)
	public String insertForm() {
		return "view/part03/insert";
	}
	
	@RequestMapping(value="/insert3.do", method=RequestMethod.POST)
	public String insertData(MemDTO dto) {
		dao.insertMethod(dto);
		return "redirect:/list3.do";  //sendRedirect (list.do)과 같은 역할 
	}
	
	@RequestMapping(value="/update3.do", method=RequestMethod.GET)
	public ModelAndView updateForm(int num, ModelAndView mav) {
		mav.addObject("dto", dao.updateMethod(num));
		mav.setViewName("view/part03/update");
		return mav;
	}
	
	@RequestMapping(value="/update2.do", method=RequestMethod.POST)
	public String updateData(MemDTO dto) {
		dao.updateMethod(dto);
		return "redirect:/list3.do";
	}
	
	@RequestMapping(value="/delete3.do", method=RequestMethod.GET)
	public String delete(int num) {
		dao.deleteMethod(num);
		return "redirect:/list3.do";
	}
}
