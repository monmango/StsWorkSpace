package part03;

import org.mybatis.spring.SqlSessionTemplate;

public class MemDaoImp implements MemDAO{
	private SqlSessionTemplate SqlSession;
	
	public MemDaoImp() {
		// TODO Auto-generated constructor stub
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		SqlSession = sqlSession;
	}
	
	@Override
	public void insertMethod(MemDTO dto) {
		SqlSession.insert("mem.ins", dto);
	}
	
	
}
