package part02_search_xml;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeDTO {
	@XmlElement(name = "first_name")
	private String first_name;
	@XmlElement(name = "email")
	private String email;
	@XmlElement(name = "hire_date")
	private Date hire_date;
	@XmlElement(name = "salary")
	private int salary;
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
