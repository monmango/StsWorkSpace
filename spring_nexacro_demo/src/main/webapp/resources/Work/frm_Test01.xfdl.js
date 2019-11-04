(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("frm_Test01");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Static("Static00","70","40","270","62",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("안녕하세요?\r\n넥사크로...");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("frm_Test01.xfdl", function() {

        //this는 Form영역을 의미한다.
        //nexacro.getApplication()는 넥사크로 애플리케이션에서 사용하는 전역(Application)을 의미한다.

        this.Static00_onclick = function(obj,e)
        {
        	this.alert("안녕하세요");
        	nexacro.getApplication().trace("Static00 클릭되었습니다.");
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Static00.addEventHandler("onclick",this.Static00_onclick,this);
        };

        this.loadIncludeScript("frm_Test01.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
