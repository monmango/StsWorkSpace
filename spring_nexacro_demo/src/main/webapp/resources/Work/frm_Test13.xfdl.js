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
            obj = new Edit("Edit00","80","25","270","71",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_displaynulltext("이름을 입력하세요.");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit01","380","25","270","71",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_displaynulltext("나이를 입력하세요.");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","684","26","279","64",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("서버로 보내기");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,1080,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("frm_Test13.xfdl", function() {

        this.Button00_onclick = function(obj,e)
        {
        	 var name = this.Edit00.text;
             var age = this.Edit01.text;

        	 //transaction : 데이터를 웹 서버에 전달하기위해 사용하는 메서드입니다.
        	this.transaction(
        	   "send", //트랜잭션 ID
        	   "../../send", //접속할 서버 주소
        	   "", //서버에 전달할 Dataset이 없는 경우 공란처리
        	   "", //서버로 부터 받은 Dataset이 없는 경우
        	   "name="+name + " age="+age, ////트랜잭션간 전달할 변수, 데이터 사이는 공백

        	   "callback" //서버측 통신이 끝난 후 호출하는 함수
        		)
         };

        this.callback=function(id,errCd,errMsg){
          if(errCd < 0 ){
              alert(errMsg);
          }else{
              alert(id + "데이터 셋 전송 성공");
        	  }
        }
        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.frm_Test02_onload,this);
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
        };

        this.loadIncludeScript("frm_Test13.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
