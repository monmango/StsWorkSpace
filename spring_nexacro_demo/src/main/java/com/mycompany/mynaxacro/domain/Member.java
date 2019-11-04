package com.mycompany.mynaxacro.domain;

import java.sql.Date;

public class Member {
    private String empl_id;
    private String full_name;
    private String dept_id;
    private Date hire_date;
    private String gender;
    private String married;
    private int salary;
    private String memo;
    private String pos_cd;
   
    
    public Member() {}
   
	public Member(String empl_id, String full_name, String dept_id,
			Date hire_date, String gender,String married,int salary, 
			String empl_memo, String pos_cd
			 ) {
		super();
		this.empl_id = empl_id;
		this.full_name = full_name;
		this.dept_id = dept_id;
		this.pos_cd = pos_cd;
		this.hire_date = hire_date;
		this.gender = gender;
		this.married = married;
		this.salary = salary;
		this.memo = empl_memo;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getPos_cd() {
		return pos_cd;
	}

	public void setPos_cd(String pos_cd) {
		this.pos_cd = pos_cd;
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_cd(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getEmpl_id() {
		return empl_id;
	}
	public void setEmpl_id(String empl_id) {
		this.empl_id = empl_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMarried() {
		return married;
	}
	public void setMarried(String married) {
		this.married = married;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	

}
