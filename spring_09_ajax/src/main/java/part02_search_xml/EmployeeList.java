package part02_search_xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="employee-list")
public class EmployeeList {
	
	@XmlElement(name="employee")
	private List<EmployeeDTO> employees;
	
	public EmployeeList() {
		// TODO Auto-generated constructor stub
	}

	
	public EmployeeList(List<EmployeeDTO> employees) {
		this.employees = employees;
	}


	public List<EmployeeDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDTO> employees) {
		this.employees = employees;
	}
	
	
}
