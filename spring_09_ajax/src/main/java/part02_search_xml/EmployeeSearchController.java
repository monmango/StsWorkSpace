package part02_search_xml;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeSearchController {
	private EmpDAO dao;
	
	public EmployeeSearchController() {
		// TODO Auto-generated constructor stub
	}

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/employeeSearch.do")
	public String doget() {
		return "part02_search_xml/searchForm";
	}
	
	@RequestMapping(value="/searchProcess.do")
	@ResponseBody
	//public List<EmployeeDTO> process(String data, HttpServletResponse response ) {
	public EmployeeList process(String data, HttpServletResponse response ) {
		//System.out.println(dao.search(data));
		/*
		EmployeeList empList = new EmployeeList();
		empList.setEmployees(dao.search(data));
		return empList.getEmployees();
		*/
		
		response.setContentType("text/xml;charset=utf-8");
		System.out.println(dao.search(data));
		return new EmployeeList(dao.search(data));
		
	}
}
