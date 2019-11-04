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
            obj = new Combo("Combo00","57","31","520","79",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            var Combo00_innerdataset = new nexacro.NormalDataset("Combo00_innerdataset", obj);
            Combo00_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">cimputer</Col><Col id=\"datacolumn\">컴퓨터</Col></Row><Row><Col id=\"datacolumn\">노트북</Col><Col id=\"codecolumn\">notebook</Col></Row><Row><Col id=\"datacolumn\">태블릿</Col><Col id=\"codecolumn\">tablet</Col></Row></Rows>");
            obj.set_innerdataset(Combo00_innerdataset);
            obj.set_text("컴퓨터");
            obj.set_value("cimputer");
            obj.set_index("0");
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
        this.registerScript("frm_Test06_Combo.xfdl", function() {

        this.Combo00_onitemchanged = function(obj,e)
        {
        	//매개변수 obj는 이벤트 발생한 컨포넌드
        	message = obj.value + "를 선택하셨군요";
        	data = obj.text;

        	alert(message + "  " + data);
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Combo00.addEventHandler("onitemchanged",this.Combo00_onitemchanged,this);
        };

        this.loadIncludeScript("frm_Test06_Combo.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
