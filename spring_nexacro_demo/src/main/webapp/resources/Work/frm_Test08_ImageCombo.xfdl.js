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
            obj = new ImageViewer("ImageViewer00","60","44","290","266",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_stretch("fixaspectratio");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo00","380","44","520","79",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            var Combo00_innerdataset = new nexacro.NormalDataset("Combo00_innerdataset", obj);
            Combo00_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">imagerc::water-melon.png</Col><Col id=\"datacolumn\">수박</Col></Row><Row><Col id=\"datacolumn\">파인애플</Col><Col id=\"codecolumn\">imagerc::fruit_pineapple-128.png</Col></Row><Row><Col id=\"datacolumn\">포도</Col><Col id=\"codecolumn\">imagerc::Grape-128 (1).png</Col></Row></Rows>");
            obj.set_innerdataset(Combo00_innerdataset);
            obj.set_text("수박");
            obj.set_value("imagerc::water-melon.png");
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
        this.registerScript("frm_Test08_ImageCombo.xfdl", function() {

        this.Combo00_onitemchanged = function(obj,e)
        {
        	this.ImageViewer00.set_image(obj.value);
        	/*var select = obj.text;
        	if(select == "수박"){
        		this.ImageViewer00.set_image("imagerc::water-melon.png");
        		this.ImageViewer00.set_stretch("fixaspectratio");
        	}else if(select == "파인애플"){
        		this.ImageViewer00.set_image("imagerc::fruit_pineapple-128.png");
        		this.ImageViewer00.set_stretch("fixaspectratio");
        	}else if(select == "포도"){
        		this.ImageViewer00.set_image("imagerc::Grape-128 (1).png");
        		this.ImageViewer00.set_stretch("fixaspectratio");
        	}*/

        };

        this.frm_Test02_onload = function(obj,e)
        {
        	//this.ImageViewer00.set_image(this.Combo00.value);
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.frm_Test02_onload,this);
            this.Combo00.addEventHandler("onitemchanged",this.Combo00_onitemchanged,this);
        };

        this.loadIncludeScript("frm_Test08_ImageCombo.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
