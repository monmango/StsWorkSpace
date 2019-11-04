package com.mycompany.mynaxacro;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.mynaxacro.domain.Member;
import com.mycompany.mynaxacro.service.MemberService;
import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataTypes;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.Variable;
import com.nexacro17.xapi.data.VariableList;
import com.nexacro17.xapi.tx.HttpPlatformRequest;
import com.nexacro17.xapi.tx.HttpPlatformResponse;
import com.nexacro17.xapi.tx.PlatformException;
import com.nexacro17.xapi.tx.PlatformType;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	int result;
	int nErrorCode = 0;
	String strErrorMsg = "SUCC";
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("index")
	public String nexIndex() {
		return "memberMGR";
	}

	@RequestMapping("send")
	public String send(HttpServletRequest request) {
		/*
		 * 
		 * 매개변수명=값 쌍으로 보내며 각각의 쌍들은 공백으로 구분한다. var msg = "name="+data1; msg +=
		 * " age="+data2;
		 * 
		 * this.transaction("send","http://localhost:8090/mynaxacro/send"
		 * ,"","",msg,"callback");
		 */

		/*
		 * 
		 * PlatformData : 데이터를 보관하는 기본객체 PlatformRequest : XML Format Data를 읽고 객체화하는
		 * Input 객체 PlatformResponse : XML Format Data를 출력하는 output 객체
		 * 
		 * DatasetList & Dataset : 데이터를 2차원 Table 형태 또는 Table Array 타입으로 보관 VariableList
		 * & Variable : I/O 인자값으로 사용되는 단일 값을 보관
		 */

		// HttpServletRequest를 이용하여 HttpPlatformRequest 생성하고 전송된 XML 데이터를 분석합니다.
		HttpPlatformRequest pReq = new HttpPlatformRequest(request);
		// PlatformException에 대한 예외를 처리하기 위한 try-catch 구문
		try {
			pReq.receiveData();
		} catch (PlatformException e1) {
			e1.printStackTrace();
		}

		// PlatformData 객체를 생성하여 request로 전달받은 값을 넥사크로 프로젝트 포맷에 맞게 가져온다.
		// PlatformData 는 데이터 송수신의 기본 단위 입니다.
		PlatformData in_PlatformData = pReq.getData();

		// #1. VariableList 에서 변수 참조
		VariableList in_valList = in_PlatformData.getVariableList();
		String name = in_valList.getString("name");
		String age = in_valList.getString("age");
		System.out.println(name + " : " + age);

		return "redirect:resources/index.html";
	}
	@RequestMapping("save")
	public void savedataset(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * 
		 * this.transaction( "save", "dataUrl::save", "in_ds=gds_emp:A", "", "sVal=테스트",
		 * "callback" );
		 */
		// Http요청으로 부터 데이터를 수신받습니다.
		HttpPlatformRequest pReq = new HttpPlatformRequest(request);
		// PlatformException에 대한 예외를 처리하기 위한 try-catch 구문
		try {
			pReq.receiveData();
		} catch (PlatformException e1) {
			e1.printStackTrace();
		}

		// PlatformData 객체를 생성하여 request로 전달받은 값을
		// 넥사크로 프로젝트 포맷에 맞게 가져온다.
		// "sVal=테스트"
		PlatformData in_PlatformData = pReq.getData();
		Variable varData = in_PlatformData.getVariable("sVal");
		String sVal1 = varData.getString();
		System.out.println("sVal=" + sVal1);

		// Dataset에서 데이터 참조-(in_ds=gds_emp:A)
		DataSet ds = in_PlatformData.getDataSet("in_ds");
		for (int i = 0; i < ds.getRowCount(); i++) {
			System.out.print(i + "\t");
			System.out.println(ds.getColumnCount()); //Dataset의 총 컬럼 갯수
			System.out.print(ds.getColumn(0).getName() + ": " +   ds.getString(i, 0) + "\t");
			System.out.print(ds.getColumn(1).getName() + ": " +ds.getString(i, 1) + "\t");
			System.out.print(ds.getColumn(2).getName() + ": " +ds.getString(i, 2) + "\t");
			System.out.print(ds.getColumn(3).getName() + ": " +ds.getString(i, 3) + "\t");
			System.out.print(ds.getColumn(4).getName() + ": " +ds.getString(i, 4) + "\t");
			System.out.print(ds.getColumn(5).getName() + ": " +ds.getInt(i, 5) + "\t");
			System.out.print(ds.getColumn(6).getName() + ": " +ds.getString(i, 6) + "\t");
			System.out.print(ds.getColumn(7).getName() + ": " +ds.getString(i, 7) + "\t");
			System.out.println(ds.getColumn(8).getName() + ": " +ds.getString(i, 8) + "\t");
		}

		
		int result = 0;
		try {
			/******** DELETE ********/
			System.out.println("삭제된 줄 의 수 :"  + ds.getRemovedRowCount());
			for (int i = 0; i < ds.getRemovedRowCount(); i++) {
				String del_id = ds.getRemovedData(i, "EMPL_ID").toString();
				result = memberService.deleteMember(del_id);
				System.out.println(del_id + (result > 0 ? "삭제성공!" : "삭제실패"));
			}

			/******** INSERT, UPDATE ********/
			// getRowType(rowIndex)를 통해 각 행의 현재 상태를 알 수 있다.
			// 0:DataSet.Row_TYPE_NORMAL
			// 1:DataSet.Row_TYPE_INSERTED
			// 2:DataSet.Row_TYPE_UPDATED
            
			for (int i = 0; i < ds.getRowCount(); i++) {
				int rowType = ds.getRowType(i);
				System.out.println("rowType(" + i + ") = " + rowType);

				// MemberVO생성
				String empl_id = dsGet(ds, i, "EMPL_ID");
				String full_name = dsGet(ds, i, "FULL_NAME");
				String dept_id = dsGet(ds, i, "DEPT_ID");
				String gender = dsGet(ds, i, "GENDER");	
				
				//dsGet(ds, i, "MARRIED") : 선택한 경우는  true, 선택하지 않은 경우는  false
				String married = "true".equals(dsGet(ds, i, "MARRIED")) ? "1" : "0";
				
				int salary = Integer.parseInt(dsGet(ds, i, "SALARY"));
				String empl_memo = dsGet(ds, i, "MEMO");

				String temp = dsGet(ds, i, "HIRE_DATE");
				String pos_cd = dsGet(ds, i, "POS_CD");
				// java.sql.Date.valueOf(String s)
				// s_format ==> yyyy-mm-dd
				Date hire_date = Date.valueOf(temp.substring(0, 4) + "-" 
				                   + temp.substring(4, 6) + "-" + temp.substring(6, 8));
				Member m = new Member(empl_id, full_name, dept_id, hire_date, gender, 
						married, salary, empl_memo,	pos_cd);
				
				if (rowType == DataSet.ROW_TYPE_INSERTED ) {
					result = memberService.insertMember(m);
					System.out.println(empl_id + (result > 0 ? " insert성공!" : " insert실패"));
				} else if (rowType == DataSet.ROW_TYPE_UPDATED) {
					result = memberService.updateMember(m);
					System.out.println(empl_id + (result > 0 ? " update성공!" : " update실패"));
				}
			}
			// 예외가 발생하지 않으면, Error Code 0과 SUCC 메시지를 반환한다.
			nErrorCode = 0;
			strErrorMsg = "SUCC";

		} catch (Throwable th) {
			nErrorCode = -1;
			strErrorMsg = th.getMessage();
		}

		// 넥사크로 프로젝트로 전달할 PlatformData 객체 생성
		PlatformData out_PlatformData = new PlatformData();
		// Error 발생 내용을 전달하는 방법은 Save와 동일하다.
		VariableList varList = out_PlatformData.getVariableList();
		varList.add("ErrorCode", nErrorCode);
		varList.add("ErrorMsg", strErrorMsg);

		
		//데이터를 전송하는 기능을 쉽게 구현하기 위해 XPLATFORM 라이브러리의 PlatformResponse 객체를 만들고
		//PlatformData 로부터 데이터를 출력시키는 코드는 다음과 같습니다.
		//PlatformResponse :  XML Format Data를 출력하는 output 객체
		HttpPlatformResponse pRes 
		= new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML, "UTF-8");
		pRes.setData(out_PlatformData);

		// PlatformException에 대한 예외를 처리하기 위한 try-catch 구문
		try {
			pRes.sendData();
		} catch (PlatformException e) {
			e.printStackTrace();
		}
	}

	// Dataset과 row 번호, col 번호를 전달받아, 내부의 value를 가져온다.
	public String dsGet(DataSet ds, int rowno, String colid) throws Exception {
		String value;
		value = ds.getString(rowno, colid);
		if (value == null)
			return "";
		return value;
	}

    
	@RequestMapping("select")
	public void select(HttpServletRequest request, HttpServletResponse response) {

		// 넥사크로 프로젝트로 전달할 PlatformData 객체 생성
		PlatformData out_PlatformData = new PlatformData();

		int nErrorCode = 0;
		String strErrorMsg = "START";
		List<Member> memberList = null;

		try {
			System.out.println("@select");
			// MemberService를 통해 MemberList를 받아온다
			memberList = memberService.selectMember();
			System.out.println("memberList.size()=" + memberList.size());
			/********* Dataset **********/
			// x-api에서 제공하는 DataSet 객체를 생성하고,
			// 내부 컬럼을 구성한다.
			DataSet ds = new DataSet("out_ds");

			ds.addColumn("EMPL_ID", DataTypes.STRING, (short) 10);
			ds.addColumn("FULL_NAME", DataTypes.STRING, (short) 50);
			ds.addColumn("DEPT_ID", DataTypes.STRING, (short) 10);
			ds.addColumn("HIRE_DATE", DataTypes.STRING, (short) 30);
			ds.addColumn("GENDER", DataTypes.STRING, (short) 1);
			ds.addColumn("MARRIED", DataTypes.STRING, (short) 1);
			ds.addColumn("SALARY", DataTypes.INT, 15);
			ds.addColumn("MEMO", DataTypes.STRING, (short) 256);
			ds.addColumn("POS_CD", DataTypes.STRING, (short) 10);

			for (int i = 0; i < memberList.size(); i++) {
				// Member 객체의 정보를 하나의 row에 나눠 담는다.
				int row = ds.newRow();
				ds.set(row, "EMPL_ID", memberList.get(i).getEmpl_id());
				ds.set(row, "FULL_NAME", memberList.get(i).getFull_name());
				ds.set(row, "DEPT_ID", memberList.get(i).getDept_id());
				ds.set(row, "HIRE_DATE", memberList.get(i).getHire_date());
				ds.set(row, "GENDER", memberList.get(i).getGender());
				ds.set(row, "MARRIED", memberList.get(i).getMarried());
				ds.set(row, "SALARY", memberList.get(i).getSalary());
				ds.set(row, "MEMO", memberList.get(i).getMemo());
				ds.set(row, "POS_CD", memberList.get(i).getPos_cd());
			}
			// DataSet에 담은 객체를 PlatformData에 추가한다.			
			out_PlatformData.addDataSet(ds);			

			nErrorCode = 0;
			strErrorMsg = "SUCC";

		} catch (Throwable th) {
			nErrorCode = -1;
			strErrorMsg = th.getMessage();
		}
		// Error 발생 내용을 전달하는 방법은 Save와 동일하다.
		VariableList varList = out_PlatformData.getVariableList();
		varList.add("ErrorCode", nErrorCode);
		varList.add("ErrorMsg", strErrorMsg);

		// HttpPlatformResponse 객체 생성
		HttpPlatformResponse pRes 
		= new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML, "UTF-8");
		pRes.setData(out_PlatformData);

		// PlatformException에 대한 예외를 처리하기 위한 try-catch 구문
		try {
			pRes.sendData();
		} catch (PlatformException e) {
			e.printStackTrace();
		}
	}

}//end class
