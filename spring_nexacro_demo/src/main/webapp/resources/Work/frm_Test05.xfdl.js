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
            obj = new CheckBox("CheckBox00","76","16","167","49",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("메일 수신 여부");
            this.addChild(obj.name, obj);

            obj = new Div("Div00","76","59","745","260",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("Div00");
            obj.set_border("1px solid black");
            this.addChild(obj.name, obj);

            obj = new Radio("Radio00","24","25","249","95",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("0");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            obj.set_border("1px solid black");
            var Div00_form_Radio00_innerdataset = new nexacro.NormalDataset("Div00_form_Radio00_innerdataset", obj);
            Div00_form_Radio00_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">COM</Col><Col id=\"datacolumn\">컴퓨터</Col></Row><Row><Col id=\"codecolumn\">LAP</Col><Col id=\"datacolumn\">노트북</Col></Row><Row><Col id=\"codecolumn\">TAB</Col><Col id=\"datacolumn\">태블릿</Col></Row></Rows>");
            obj.set_innerdataset(Div00_form_Radio00_innerdataset);
            obj.set_text("컴퓨터");
            obj.set_value("COM");
            obj.set_index("0");
            this.Div00.addChild(obj.name, obj);

            obj = new Div("Div01","77","402","748","303",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("Div01");
            obj.set_border("1px solid blue");
            this.addChild(obj.name, obj);

            obj = new Radio("Radio01","22","12","249","95",null,null,null,null,null,null,this.Div01.form);
            obj.set_taborder("0");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            obj.set_border("1px solid black");
            var Div01_form_Radio01_innerdataset = new nexacro.NormalDataset("Div01_form_Radio01_innerdataset", obj);
            Div01_form_Radio01_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">COM</Col><Col id=\"datacolumn\">컴퓨터</Col></Row><Row><Col id=\"codecolumn\">LAP</Col><Col id=\"datacolumn\">노트북</Col></Row><Row><Col id=\"codecolumn\">TAB</Col><Col id=\"datacolumn\">태블릿</Col></Row></Rows>");
            obj.set_innerdataset(Div01_form_Radio01_innerdataset);
            obj.set_text("컴퓨터");
            obj.set_value("COM");
            obj.set_index("0");
            this.Div01.addChild(obj.name, obj);

            obj = new Edit("Edit00","105","351","131","37",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_displaynulltext("code값 입력");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit01","259","350","131","37",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_displaynulltext("data값 입력");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","418","351","113","34",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("Radio 추가");
            this.addChild(obj.name, obj);

            obj = new Button("Button01","567","351","113","34",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("Radio 제거");
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
        this.registerScript("frm_Test05.xfdl", function() {

        	//CheckBox 수신 설정 및 해제
        	this.CheckBox00_onclick = function(obj,e)
        	{
        		var check = this.CheckBox00.value;
        		var message = "";
        		if(check) {
        			message = "메일 수신 설정";
        		} else {
        			message = "메일 수신 해제";
        		}
        		this.alert(message);

        	};



        this.Div00_Radio00_onitemchanged = function(obj,e)
        {
        	alert(this.Div00.form.Radio00.value);
        };



        this.Button00_onclick = function(obj,e)
        {
        	var code = this.Edit00.text;
        	var data = this.Edit01.text;

        	if(code==''){
        		alert("codecolumn을 입력하세요.");
        		return false;
        	}

        	if(data==''){
        		alert("datacolumn을 입력하세요.");
        		return false;
        	}

        	var innerDS = this.Div01.form.Radio01.getInnerDataset();
        	innerDS.insertRow(0);
        	innerDS.setColumn(0, "codecolumn", this.Edit00.value);
        	innerDS.setColumn(0, "datacolumn", this.Edit01.value);

        };

        this.Button01_onclick = function(obj,e)
        {
        	var innerDS = this.Div01.form.Radio01.getInnerDataset();
        	innerDS.deleteRow(0);
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.CheckBox00.addEventHandler("onclick",this.CheckBox00_onclick,this);
            this.Div00.form.Radio00.addEventHandler("onitemchanged",this.Div00_Radio00_onitemchanged,this);
            this.Div01.form.Radio01.addEventHandler("onitemchanged",this.Div00_Radio00_onitemchanged,this);
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.Button01.addEventHandler("onclick",this.Button01_onclick,this);
        };

        this.loadIncludeScript("frm_Test05.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
