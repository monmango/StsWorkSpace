(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("frm_Test02");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,1080);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Static("Static00","40","30","309","50",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("인사 관리 페이지");
            obj.set_background("pink");
            obj.set_textAlign("center");
            this.addChild(obj.name, obj);

            obj = new Button("Select","382","30","112","39",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("Select");
            this.addChild(obj.name, obj);

            obj = new Button("Add","504","30","112","39",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("Add");
            this.addChild(obj.name, obj);

            obj = new Button("Delete","626","30","112","39",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("Delete");
            this.addChild(obj.name, obj);

            obj = new Button("Save","748","30","112","39",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("Save");
            this.addChild(obj.name, obj);

            obj = new Button("New","870","30","112","39",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("New");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","40","118","309","199",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_binddataset("gds_emp");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"48\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"NO\"/><Cell col=\"1\" text=\"EMPL_ID\"/><Cell col=\"2\" text=\"FULL_NAME\"/></Band><Band id=\"body\"><Cell expr=\"currow+1\"/><Cell col=\"1\" text=\"bind:EMPL_ID\" maskeditformat=\"AA-###\" maskedittype=\"string\" displaytype=\"mask\"/><Cell col=\"2\" text=\"bind:FULL_NAME\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Div("Div00","382","118","508","468",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("Div00");
            obj.set_border("1px solid black");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","20","9","143","44",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("0");
            obj.set_text("FULL_NAME");
            obj.set_background("#dede8b");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static01","20","58","143","44",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("1");
            obj.set_text("EMPL_ID");
            obj.set_background("#dede8b");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static02","20","254","143","44",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("2");
            obj.set_text("GENDER");
            obj.set_background("#dede8b");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static03","20","156","143","44",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("3");
            obj.set_text("MARRIED");
            obj.set_background("#dede8b");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static04","20","205","143","44",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("4");
            obj.set_text("SALARY");
            obj.set_background("#dede8b");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static05","20","352","143","44",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("5");
            obj.set_text("MEMO");
            obj.set_background("#dede8b");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static06","20","107","143","44",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("6");
            obj.set_text("HIREDATE");
            obj.set_background("#dede8b");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static07","20","303","143","44",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("7");
            obj.set_text("DEPT_ID");
            obj.set_background("#dede8b");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static08","20","401","143","44",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("8");
            obj.set_text("POS_CD");
            obj.set_background("#dede8b");
            this.Div00.addChild(obj.name, obj);

            obj = new MaskEdit("MaskEdit01","304","58","149","40",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("9");
            obj.set_type("string");
            obj.set_format("AA-###");
            this.Div00.addChild(obj.name, obj);

            obj = new Calendar("Calendar00","304","119","149","40",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("10");
            this.Div00.addChild(obj.name, obj);

            obj = new CheckBox("CheckBox00","304","174","149","40",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("11");
            obj.set_text("결혼 여부");
            this.Div00.addChild(obj.name, obj);

            obj = new MaskEdit("MaskEdit02","304","218","149","40",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("12");
            obj.set_format("#,###");
            this.Div00.addChild(obj.name, obj);

            obj = new Radio("Radio00","304","264","149","40",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("13");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            obj.set_direction("vertical");
            var Div00_form_Radio00_innerdataset = new nexacro.NormalDataset("Div00_form_Radio00_innerdataset", obj);
            Div00_form_Radio00_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">M</Col><Col id=\"datacolumn\">남성</Col></Row><Row><Col id=\"codecolumn\">W</Col><Col id=\"datacolumn\">여성</Col></Row></Rows>");
            obj.set_innerdataset(Div00_form_Radio00_innerdataset);
            this.Div00.addChild(obj.name, obj);

            obj = new Combo("Combo00","304","308","149","40",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("14");
            obj.set_datacolumn("value");
            obj.set_codecolumn("code");
            obj.set_innerdataset("gds_dept");
            obj.set_text("Combo00");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit00","304","403","149","40",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("15");
            this.Div00.addChild(obj.name, obj);

            obj = new TextArea("TextArea00","304","361","149","40",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("16");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit01","304","11","149","42",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("17");
            this.Div00.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,1080,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item1","Div00.form.MaskEdit01","value","gds_emp","EMPL_ID");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item2","Div00.form.Combo00","value","gds_emp","DEPT_ID");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item3","Div00.form.Edit00","value","gds_emp","POS_CD");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item4","Div00.form.Calendar00","value","gds_emp","HIRE_DATE");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item5","Div00.form.MaskEdit02","value","gds_emp","SALARY");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item6","Div00.form.Radio00","value","gds_emp","GENDER");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item7","Div00.form.TextArea00","value","gds_emp","MEMO");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item8","Div00.form.CheckBox00","value","gds_emp","MARRIED");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item0","Div00.form.Edit01","value","gds_emp","FULL_NAME");
            this.addChild(obj.name, obj);
            obj.bind();
        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("frm_Test12.xfdl", function() {

        this.Add_onclick = function(obj,e)
        {
           application = nexacro.getApplication();


           //오늘 날짜 구하기
        	var day = new Date();
        	var yyyy= day.getFullYear();
        	var mm = day.getMonth() + 1;
        	var dd = day.getDate();
        	mm = (mm < 9 ? '0':'') + mm;
        	dd = (dd < 9 ? '0':'') + dd;

           //dataset에 row 추가합니다.
        	var newRow = application.gds_emp.addRow();

        	application.gds_emp.setColumn(newRow, "HIRE_DATE", yyyy+mm+dd);

        	//Radio 박스의  지정
        	application.gds_emp.setColumn(newRow, "GENDER", 'M');


        };


        this.Delete_onclick = function(obj,e)
        {

        	application = nexacro.getApplication();

        	//현재 row를 삭제한다.
        	//현재 선택된 row의 인덱스를 deleteRow()메서드의 인자로 전달합니다.
        	application.gds_emp.deleteRow(application.gds_emp.rowposition);
        };

        this.Save_onclick = function(obj,e)
        {
           //데이터를 웹 서버에 전달하기위해 사용하는 메서드입니다.
        	this.transaction(
        	   "save", //트랜잭션 ID
        	   "../../save", //서버에 전달할 데이터 셋
        	   "in_ds=gds_emp:A", //:U update, :A all, :N 삭제되지 않은 정보
        	   "", //서버에서 전달받을 DataSet이 없다면 공란처리
        	   "sVal=테스트", //트랜잭션간 전달할 변수
        	   "callback" //서버측 통신이 끝난 후 호출하는 함수
        		)
        };

        this.callback=function(id,errCd,errMsg){

          if(errCd < 0 ){
              alert(errMsg);
          }else{
              alert(id + " 데이터 셋 전송 성공");
        	  }
        }



        this.Select_onclick = function(obj,e)
        {

        	//데이터를 웹 서버에 전달하기위해 사용하는 메서드입니다.
        	this.transaction(
        	   "select", //트랜잭션 ID
        	  // "http://localhost:8090/mynexacro/select", //서버에 전달할 데이터 셋
        	  //  "dataUrl::select",
        	  "../../select", //sts에서 이 스크립트 파일의 위치는 resources/Work/frm_Test12.xfdl.js이며 이를 기준으로 주소 설정하면 된다.
        	                  // "http://localhost:8090/mynexacro/select" 경로가 된다.
        	   "", //서버에 전달할 Dataset이 없는 경우 공란처리
        	   "gds_emp=out_ds", //서버에서 전달받을 DataSet이 없다면 공란처리
        	                     // 서버로부터 받을 DataSetID=서버에서 전송한 DataSetID
        	   "", //트랜잭션간 전달할 변수
        	   "callback" //서버측 통신이 끝난 후 호출하는 함수
        		)

        };


        //웹 문서가 로드되었을 때
        this.frm_Test12_onload = function(obj,e)
        {
        	this.Select_onclick(); //Select_onclick()를 실행합니다.
        };


        /*
        //웹 문서가 로드되었을 때
        this.frm_Test12_onload = function(obj:nexacro.Form,e:nexacro.LoadEventInfo)
        {
        	this.Select_onclick(); //Select_onclick()를 실행합니다.

        	//시간 이벤트 설정
        	this.setTimer(obj.timekey,2000);

        };

        this.fn_timerTest = function(){
        	// 날짜 오브젝트 생성
        	var day = new Date();
        	// 현재 시간을 console 화면에 출력
        	trace("현재 시간 = "+day.getHours()
        	      +":"+day.getMinutes()
        	      +":"+day.getSeconds());
        }


        */

        //Add 버튼
        this.Button01_onclick = function(obj,e)
        {
        	application = nexacro.getApplication();


           //오늘 날짜 구하기
        	var day = new Date();
        	var yyyy= day.getFullYear();
        	var mm = day.getMonth() + 1;
        	var dd = day.getDate();
        	mm = (mm < 9 ? '0':'') + mm;
        	dd = (dd < 9 ? '0':'') + dd;

           //dataset에 row 추가합니다.
        	var newRow = application.gds_emp.addRow();

        	application.gds_emp.setColumn(newRow, "HIRE_DATE", yyyy+mm+dd);

        	//Radio 박스의  지정
        	application.gds_emp.setColumn(newRow, "GENDER", 'M');
        };


        //New 버튼
        this.New_onclick = function(obj,e)
        {

        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.frm_Test02_onload,this);
            this.Select.addEventHandler("onclick",this.Select_onclick,this);
            this.Add.addEventHandler("onclick",this.Button01_onclick,this);
            this.Delete.addEventHandler("onclick",this.Delete_onclick,this);
            this.Save.addEventHandler("onclick",this.Save_onclick,this);
            this.New.addEventHandler("onclick",this.New_onclick,this);
        };

        this.loadIncludeScript("frm_Test12.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
