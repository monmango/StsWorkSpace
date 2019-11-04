package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.PersonDAO;
import dto.PersonDTO;

//REpresentational State Transfer(표현 상태 전이,REST)
//API를 통해 프로그램들은 의사소통을 한다. 그리고 REST응 개발자가 API를 만들때 준수해야 할 규칙들이다.
//이런 규칙들을 통해 특정 URL에 접근해서 데이터들을 가져올 수 있다.
/*
 * GET(/myrest/person/list)			자료조회용
 * GET(/myrest/person/list/3)			자료조회용
 * DELETE(/myrest/person/3)			자료 삭제
 * POST(/myrest/person/)+데이터			자료 등록
 * PUT(/myrest/person/update)+데이터			자료 수정
 * 
 * @PathValiable - URI의 경로에서 원하는  데이터를 추출하는 용도로 사용
 * @RequestBoot - 전송된 JSON데이터를 객체로 변환해 주는 어노테이션
 * @ModelAndView와 유사한 역할을 하지만 JSON에서 사용된다는 점이 차이
 */

@Controller
public class PersonComtroller {

	private PersonDAO dao;
	
	public PersonComtroller() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDao(PersonDAO dao) {
		this.dao = dao;
	}
	
	//select는 무조건 GET방식 처리
	//http://localhost:8090/myrest/person/list
	@RequestMapping(value="/list" , method = RequestMethod.GET)
	public @ResponseBody List<PersonDTO> listMethod(){
		return dao.list();
	}//end---------------------------------------------------------
	
	//http://localhost:8090/myrest/person/list/2
	@RequestMapping(value="/list/{ss}" , method= RequestMethod.GET)
	public @ResponseBody PersonDTO listMethod(@PathVariable("ss") int num) {
		return dao.list(num);
		//{ss}는 파라미터 변수명 
	}
	//http://localhost:8090/myrest/person/list/1/홍길동
	/*@RequestMapping(value= "/list/{num}/{name}" , method= RequestMethod.GET)
	public @ResponseBody PersonDTO listMethod(
			@PathVariable("num") int num,
			@PathVariable("name") String name) {
		PersonDTO dto = new PersonDTO();
		dto.setName(name);
		dto.setNum(num);
		return dao.list(dto);
	}
	*/
	//http://localhost:8090/myrest/person/list/1/홍길동
	@RequestMapping(value="/list/{num}/{name}" , method = RequestMethod.GET)
	public @ResponseBody PersonDTO listMethod(PersonDTO dto) {
		return dao.list(dto);
	}
	
	
	
	//http://localhost:8090/myrest/person/
	@RequestMapping(value = "/" , method=RequestMethod.POST)
	public  ResponseEntity<String> insertMethod(@RequestBody PersonDTO dto){
		ResponseEntity<String> entity = null;
		try {
			dao.register(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.toString());
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//{"num":3,"name":"강아지"}
	//http://localhost:8090/myrest/person/update
	@RequestMapping(value = "/update" , method=RequestMethod.PUT)
	public  ResponseEntity<String> updateMethod(@RequestBody PersonDTO dto){
		ResponseEntity<String> entity = null;
		try {
			dao.update(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.toString());
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//{"num":3,"name":"강아지"}
		//http://localhost:8090/myrest/person/3
		@RequestMapping(value = "/{num}" , method=RequestMethod.DELETE)
		public  ResponseEntity<String> deleteMethod(@PathVariable("num") int num){
			ResponseEntity<String> entity = null;
			try {
				dao.delete(num);
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}catch (Exception e) {
				System.out.println(e.toString());
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			return entity;
		}
	
	
	
	
	
	
	
}
