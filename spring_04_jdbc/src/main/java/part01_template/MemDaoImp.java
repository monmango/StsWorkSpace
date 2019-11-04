package part01_template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/*
 * Template 클래스
 * 1. 개발자가 중복된 코드를 입력해야 하는 작업을 줄일 수 있도록 돕고 있다.
 * 2. JDBC뿐만 아니라 myBatis, JMS와 같은 다양한 기술에 대해 템플릿을 제공한다.
 * 3. 예로 Jdbc인 경우 JdbcTemplate클래스를 제공하고 있으며, JdbcTemplate클래스를
 *    사용함으로써 try~cath~finally 및커넥션 관리를 위한 중복된 코드를 줄이거나
 *    없앨 수 있다.
 *    
 *                             Java JDBC              Spring JDBC
 *    select  				   executeQuery( )         query( )
 *    insert, update, delete   executeUpdate( )        update( )
 */

public class MemDaoImp implements MemDAO{
	private JdbcTemplate jdbcTemplate;
	public MemDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<MemDTO> list() {
		String sql = "select * from mem order by num desc";
		List<MemDTO> list = jdbcTemplate.query(sql, new RowMapper<MemDTO>() {
			@Override
			public MemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				return dto;
			}
		});
		return list;
	}

	@Override
	public void insertMethod(MemDTO dto) {
		String sql = "insert into mem values(mem_num_seq.nextval,?,?,?)";
		Object[] args = new Object[] {
			dto.getName(), dto.getAge(), dto.getLoc()	
		};
		
		jdbcTemplate.update(sql, args);
	}

	@Override
	public MemDTO updateMethod(int num) {
		String sql = "select * from mem where num=?";
		Object[] args = new Object[] {num};
		return jdbcTemplate.queryForObject(sql, args, new RowMapper<MemDTO>() {

			@Override
			public MemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				return dto;
			}
		});
		
	}
	
	@Override
	public void updateMethod(MemDTO dto) {
		String sql = "update mem set name=?, age=?, loc=? where num=?";
		Object[] args = new Object[] {
			dto.getName(), dto.getAge(), dto.getLoc(), dto.getNum()	
		};
		
		jdbcTemplate.update(sql, args);
	}

	@Override
	public void deleteMethod(int num) {
		String sql = "delete from mem where num=?";
		
		Object[] args = new Object[] {
				num	
			};
			
			jdbcTemplate.update(sql, args);
	}

	@Override
	public MemDTO one(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countMethod() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
