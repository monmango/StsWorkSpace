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
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Div("Div00","98","54","752","426",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("Div00");
            obj.set_border("1px solid");
            this.addChild(obj.name, obj);

            obj = new Edit("Edit00","15","21","201","61",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("0");
            obj.set_maxlength("20");
            obj.set_displaynulltext("내용을 작성하세요.");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static00","25","108","192","55",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("1");
            obj.set_text("String Type : 7자리\r\nformat : *******\r\ntype : string\r\n모든 알파벳");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static01","25","198","192","87",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("2");
            obj.set_text("Number Type\r\n세자리 마다 콤마\r\nformat:#,###\r\ntype : number\r\n0-9사이의 숫자");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static02","24","308","192","55",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("3");
            obj.set_text("String Type : 휴대폰 번호\r\nformat : ###-####-####\r\ntype : string");
            this.Div00.addChild(obj.name, obj);

            obj = new MaskEdit("MaskEdit00","244","110","158","53",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("4");
            obj.set_format("*******");
            obj.set_type("string");
            this.Div00.addChild(obj.name, obj);

            obj = new MaskEdit("MaskEdit01","250","196","153","89",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("5");
            obj.set_format("#,###");
            this.Div00.addChild(obj.name, obj);

            obj = new MaskEdit("MaskEdit02","251","305","158","58",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("6");
            obj.set_format("###-####-####");
            obj.set_type("string");
            this.Div00.addChild(obj.name, obj);

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

        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Div00.form.Edit00.addEventHandler("onchanged",this.Div00_Edit00_onchanged,this);
            this.Div00.form.Static00.addEventHandler("onclick",this.Div00_Static00_onclick,this);
        };

        this.loadIncludeScript("frm_Test04.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
