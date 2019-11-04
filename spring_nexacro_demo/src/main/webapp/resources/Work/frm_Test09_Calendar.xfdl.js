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
            obj = new Calendar("Calendar00","90","49","350","131",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_locale("ko_KR");
            this.addChild(obj.name, obj);

            obj = new Calendar("Calendar01","90","205","350","131",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_locale("ko_KR");
            obj.set_type("monthonly");
            obj.set_dateformat("yyyy-MM-dd dddd");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","480","205","300","73",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Calendar("Calendar02","99","365","338","65",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_type("spin");
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
        this.registerScript("frm_Test09_Calendar.xfdl", function() {

        this.Calendar01_onchanged = function(obj,e)
        {
        	this.Edit00.set_value(obj.text);
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.frm_Test02_onload,this);
            this.Calendar01.addEventHandler("onchanged",this.Calendar01_onchanged,this);
        };

        this.loadIncludeScript("frm_Test09_Calendar.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
