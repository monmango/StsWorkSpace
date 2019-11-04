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
            obj = new ImageViewer("ImageViewer00","100","65","410","273",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_stretch("fixaspectratio");
            obj.set_image("URL(\"imagerc::water-melon.png\")");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","612","79","255","83",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("수박");
            this.addChild(obj.name, obj);

            obj = new Button("Button01","610","220","255","83",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("파인애플");
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
        this.registerScript("frm_Test07_ImageBtn.xfdl", function() {
        //수박을 선택했을때
        this.Button00_onclick = function(obj,e)
        {
        	//이미지를 인자값으로 변경합니다.
        	this.ImageViewer00.set_image("imagerc::water-melon.png");

        	//가로 세로 크기를 이미지뷰어 크기에 맞춥니다.
        	this.ImageViewer00.set_stretch("fit");
        };

        //파인애플을 선택했을때
        this.Button01_onclick = function(obj,e)
        {
        	//이미지를 인자값으로 변경합니다.
        	this.ImageViewer00.set_image("imagerc::fruit_pineapple-128.png");

        	//가로 세로 크기를 이미지뷰어 크기에 맞춥니다.
        	this.ImageViewer00.set_stretch("fixaspectratio");
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.Button01.addEventHandler("onclick",this.Button01_onclick,this);
        };

        this.loadIncludeScript("frm_Test07_ImageBtn.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
