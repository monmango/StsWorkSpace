package part02_search_xml;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmployeeDaoImp implements EmpDAO{
	private SqlSession sqlSession;
	
	public EmployeeDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<EmployeeDTO> search(String data) {
		 return sqlSession.selectList("empxml.list", data);
	}
}
