package part03;

import org.springframework.transaction.annotation.Transactional;

public class ServiceImp implements Service {

	private MemDAO dao;

	public ServiceImp() {
		// TODO Auto-generated constructor stub
	}

	public void setDao(MemDAO dao) {
		this.dao = dao;
	}
	
	@Transactional(rollbackFor=java.lang.Exception.class)
	@Override
	public void insertProcess() {
		dao.insertMethod(new MemDTO(60, "용팔이", 50, "경기"));
		dao.insertMethod(new MemDTO(60, "유대위", 20, "대전"));
	}

}
