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
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"url\" type=\"STRING\" size=\"256\"/><Column id=\"name\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"url\">imagerc::water-melon.png</Col><Col id=\"name\">수박</Col></Row><Row><Col id=\"url\">imagerc::fruit_pineapple-128.png</Col><Col id=\"name\">파인애플</Col></Row><Row><Col id=\"url\">imagerc::Grape-128 (1).png</Col><Col id=\"name\">포도</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Combo("Combo00","715","52","291","61",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_innerdataset("Dataset00");
            obj.set_codecolumn("url");
            obj.set_datacolumn("name");
            obj.set_text("");
            this.addChild(obj.name, obj);

            obj = new ImageViewer("ImageViewer00","166","58","521","328",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("");
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
        this.registerScript("frm_Test11_ImageCombo2.xfdl", function() {

        this.Combo00_onitemchanged = function(obj,e)
        {
        	this.ImageViewer00.set_image(obj.value);
        	this.ImageViewer00.set_stretch("fixaspectratio");
        };

        this.ImageViewer00_onclick = function(obj,e)
        {

        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.frm_Test02_onload,this);
            this.Combo00.addEventHandler("onitemchanged",this.Combo00_onitemchanged,this);
            this.ImageViewer00.addEventHandler("onclick",this.ImageViewer00_onclick,this);
        };

        this.loadIncludeScript("frm_Test11_ImageCombo2.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
