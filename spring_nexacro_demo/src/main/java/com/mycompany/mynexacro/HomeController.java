package com.mycompany.mynexacro;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;
import com.nexacro17.xapi.tx.HttpPlatformRequest;
import com.nexacro17.xapi.tx.PlatformException;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	int result;
	int nErrorCode = 0;
	String strErrorMsg = "SUCC";
	
	@RequestMapping("index")
	public String nexIndex() {
		return "memberMGR";
	}

	@RequestMapping("send")
	public String send(HttpServletRequest request) {
		/*
		 * 
		 * 매개변수명=값 쌍으로 보내며 각각의 쌍들은 공백으로 구분한다. 
		 * var msg  = "name="+data1;
		       msg += " age="+data2;
		 * 
		 * this.transaction("send","http://localhost:8090/mynexacro/resources/index.html"
		                    ,"","",msg,"callback");
		 */
		
		/*
		 * 
		  PlatformData : 데이터를 보관하는 기본객체
          PlatformRequest :  XML Format Data를 읽고 객체화하는 Input 객체
          PlatformResponse : XML Format Data를 출력하는 output 객체

          DatasetList & Dataset : 데이터를 2차원 Table 형태 또는 Table Array 타입으로 보관
          VariableList & Variable : I/O 인자값으로 사용되는 단일 값을 보관		  
		 */
		
		//HttpServletRequest를 이용하여 HttpPlatformRequest 생성하고 전송된 XML 데이터를 분석합니다.
		HttpPlatformRequest pReq = new HttpPlatformRequest(request);
		// PlatformException에 대한 예외를 처리하기 위한 try-catch 구문
		try {
			pReq.receiveData();
		} catch (PlatformException e1) {
			e1.printStackTrace();
		}
 
		// PlatformData 객체를 생성하여 request로 전달받은 값을 넥사크로 프로젝트 포맷에 맞게 가져온다.
		//PlatformData 는 데이터 송수신의 기본 단위 입니다.
		PlatformData in_PlatformData = pReq.getData();

		// #1. VariableList 에서 변수 참조
		VariableList in_valList = in_PlatformData.getVariableList();
		String name = in_valList.getString("name");
		String age = in_valList.getString("age");
		System.out.println(name + " : " + age);

		return "redirect:resources/index.html";
	}
	
}
