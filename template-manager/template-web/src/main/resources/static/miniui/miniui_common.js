//判断是否为新增的保存
function _add_action(key) {
	key = isEmpty(key) ? "id" : key;
	var obj = mini.get(key);
	if(isEmpty(obj, false)) {
		return false;
	}else{
		return isEmpty(obj.getValue(), false);
	}
}

//判断对象是否为空
function isEmpty(v, allowBlank){
	return v === null || v === undefined || (!allowBlank ? v === '' : false);
}

//通用弹出层方法
function _show_window_function(windowid, title) {
	if(!isEmpty(windowid, false)) {
		var windowdiv = mini.get(windowid);
		windowdiv.setTitle(title);
		windowdiv.show();
	}
}

//通用取消层方法
function _hide_window_function(windowid) {
	if(!isEmpty(windowid, false)) {
		var windowdiv = mini.get(windowid);
		windowdiv.hide();
	}
}
//通用弹出新增层方法
function _add_function(windowid, formid, title) {
	var windowdiv = mini.get(windowid);
	var formdiv = new mini.Form("#"+formid);
	formdiv.reset();
	if(title!="") {
		windowdiv.setTitle(title);
	}
	windowdiv.show();
}

//通用弹出编辑层方法
function _edit_function(gridid, windowid, formid, title, ajaxurl, nullmessage, errormessage) {
	if(nullmessage=="" || null == nullmessage) {
		nullmessage = "请选择需要编辑的一条记录.";
	}
	if(errormessage=="" || null == nullmessage) {
		errormessage = "加载失败.";
	}
	var grid = mini.get(gridid);
	var rows = grid.getSelecteds();
    if (rows.length==1) {
    	var windowdiv = mini.get(windowid);
    	if(title!="") {
    		windowdiv.setTitle(title);
    	}
    	windowdiv.show();
    	var formdiv = new mini.Form("#"+formid);
		formdiv.clear();
     	formdiv.loading();
     	$.ajax({
            url: ajaxurl + "?id=" + rows[0].id,
            dataType:"json",
	    	contentType:"application/json",
            success: function (obj) {
     			formdiv.unmask();
                var o = mini.decode(obj.data);
                formdiv.setData(o);
            },
            error: function () {
                mini.alert(errormessage);
                formdiv.unmask();
            }
     	});
    }else{
    	mini.alert(nullmessage);            	
    }
}

//通用弹出编辑层方法
function _edit_function(gridid, windowid, formid, title, ajaxurl,backfun,nullmessage,errormessage) {
	if(nullmessage=="" || null == nullmessage) {
		nullmessage = "请选择需要编辑的一条记录.";
	}
	if(errormessage=="" || null == nullmessage) {
		errormessage = "加载失败.";
	}
	var grid = mini.get(gridid);
	var rows = grid.getSelecteds();
    if (rows.length==1) {
    	var windowdiv = mini.get(windowid);
    	if(title!="") {
    		windowdiv.setTitle(title);
    	}
    	windowdiv.show();
    	var formdiv = new mini.Form("#"+formid);
		formdiv.clear();
     	formdiv.loading();
     	$.ajax({
            url: ajaxurl + "?id=" + rows[0].id,
            dataType:"json",
	   		contentType:"application/json",
            success: function (obj) {
     			formdiv.unmask();
                var o = mini.decode(obj.data);
                formdiv.setData(o);
                if(typeof(eval(backfun)) == "function") {
					var fn = eval(backfun);
    	        	fn(obj);
    	        }
            },
            error: function () {
                mini.alert(errormessage);
                formdiv.unmask();
            }
     	});
    }else{
    	mini.alert(nullmessage);            	
    }
}

function labelModel(formid) {
    var form = new mini.Form("#"+formid);
    var fields = form.getFields();                
    for (var i = 0, l = fields.length; i < l; i++) {
        var c = fields[i];
        if (c.setReadOnly) c.setReadOnly(true);     //只读
        if (c.setIsValid) c.setIsValid(true);      //去除错误提示
        if (c.addCls) c.addCls("asLabel");          //增加asLabel外观
    }
}

//通用删除数据的方法
function _delete_function(gridid, ajaxurl, backfun, tipmessage, nullmessage, errormessage, successmessage) {
	if(nullmessage=="" || null == nullmessage) {
		nullmessage = "请选择需要删除的记录.";
	}
	if(errormessage=="" || null == errormessage) {
		errormessage = "删除失败.";
	}
	if(tipmessage=="" || null == tipmessage) {
		tipmessage = "确定删除选择的记录?";
	}
	if(successmessage=="" || null == successmessage) {
		successmessage = "删除成功.";
	}
	var grid = mini.get(gridid);
	var rows = grid.getSelecteds();
    if (rows.length > 0) {
    	mini.confirm(tipmessage, "确定?",
           function (action) {            
               if (action == "ok") {
            	   var ids = [];
                   for (var i = 0, l = rows.length; i < l; i++) {
                       var r = rows[i];
                       ids.push(r.id);
                   }
                   var id = ids.join(',');
                   $.ajax({
                	   url: ajaxurl + "?id=" + id,
                	   dataType:"json",
	    			   contentType:"application/json",
                       success: function (obj) {
                            if(obj.success) {
								mini.alert(successmessage);
								if(typeof(eval(backfun)) == "function") {
									var fn = eval(backfun);
				    	        	fn(obj);
				    	        }
                           }else{
                        	   var message=obj.message;
                        	   if(!isEmpty(message, false) && message!="sucess") {
                        		   errormessage=message;
                        	   }
                        	   mini.alert(errormessage);
                           }
                       },
                       error: function () {
                           mini.alert(errormessage);
                       }
                   });
               }
           }
        );
    } else {
        mini.alert(nullmessage);
    }
}

//通用弹出查询层方法
function _search_function(windowid,formid,title) {
	var windowdiv = mini.get(windowid);
	var formdiv = new mini.Form("#"+formid);
	formdiv.reset();
	if(title!="") {
		windowdiv.setTitle(title);
	}
	windowdiv.show();
}

//通用刷新表格方法
function _refresh_function(gridid, ajaxurl) {
	var grid = mini.get(gridid);
	if((ajaxurl != "") && (null != ajaxurl)) {
		grid.setUrl(ajaxurl);
	}
	grid.load();
}

//通用取消弹出层方法
function _cancel_function(windowid) {
	var windowdiv = mini.get(windowid);
	windowdiv.hide();
}

//通用定义查询数据失败后执行的脚本方法
function _search_Fail() {
	mini.alert("查询失败,请重新查询.");
}

//通用新增或编辑的保存方法
function _save_function(formid, ajaxurl, backfun, successmessage, errormessage) {
	if(errormessage=="" || null == errormessage) {
		errormessage = "保存失败.";
	}
	if(successmessage=="" || null == successmessage) {
		successmessage = "保存成功.";
	}
	var form = new mini.Form("#"+formid);
    form.validate();
    if (form.isValid() == false) return;
	var o = form.getData();
	
	var json = mini.encode(o,"yyyy-MM-dd HH:mm:ss");
	$.ajax({
	    url: ajaxurl,
	    data: json,
	    type: 'post',
	    dataType:"json",
	    contentType:"application/json",
	    success: function (obj) {
    	    if(obj.success) {
    	    	mini.alert(successmessage);
    	        if(typeof(eval(backfun)) == "function") {
    	        	var fn = eval(backfun);
    	        	fn(obj);
    	        }
    	    }else{
				mini.alert(errormessage);
				form.unmask();
        	}
	    },
	    error: function (jqXHR, textStatus, errorThrown) {
	        mini.alert(errormessage);
	        form.unmask();
	    }
	});
}

//通用修改保存可编辑表格的数据方法
function _update_editgrid_function(gridid, ajaxurl, backfun, successmessage, errormessage) {
	if(errormessage=="" || null == errormessage) {
		errormessage = "修改失败.";
	}
	if(successmessage=="" || null == successmessage) {
		successmessage = "修改成功.";
	}
	if(!isEmpty(gridid, false)) {
		var editgrid = mini.get(gridid);
		var editdata = editgrid.getChanges();
		var json = mini.encode(editdata);
		$.ajax({
			url: ajaxurl,
			dataType:"json",
	    	contentType:"application/json",
		    data:json,
		    success: function (obj) {
	    	    if("0"==obj.state) {
	    	    	mini.alert(successmessage);
	    	        if(typeof(eval(backfun)) == "function") {
	    	        	var fn = eval(backfun);
	    	        	fn(obj);
	    	        }
	    	    }else{
					mini.alert(errormessage);
					form.unmask();
	        	}
		    },
		    error: function (jqXHR, textStatus, errorThrown) {
		        mini.alert(errormessage);
		        form.unmask();
		    }
		});
	}
}

//通用上传图片方法
//imgobj:上传文本对象
//uploadurl:上传的执行url地址
//htmlo:所有页面的隐藏文本、div层id等信息的对象
//paramo:传递额外执行的参数对象
function _img_upload(imgobj, uploadurl, htmlo, paramo) {
	var imgobjid = imgobj.id;
 	var messageid = mini.loading("正在上传, 请稍等 ...","");
	jQuery.ajaxFileUpload({
		url:uploadurl,
		secureuri:false,
		fileElementId:imgobjid,
		data:paramo,
		dataType: 'text',
		success: function(result){
			var start = result.indexOf(">");  
            if(start != -1) {  
              var end = result.indexOf("<", start + 1);  
              if(end != -1) {  
            	  result = result.substring(start + 1, end);  
               }  
            }  
			if(result!=""){
				alert("上传成功");
				var json = eval('(' +result+ ')');
				if(json.fileState=="1"){
					var fileUrl = json.fileUrl;
					var fileName = json.fileName;
					mini.get(htmlo.valueid).setValue(fileName);
					$("#"+htmlo.deleteimgid).val(fileName);
					$("#"+htmlo.fullurlid).removeAttr("src");
					$("#"+htmlo.fullurlid).attr("src", fileUrl);
					$("#"+htmlo.viewdivid).show();
					$("#"+htmlo.uploaddivid).hide();
					$("#"+htmlo.deletedivid).show();
					mini.hideMessageBox(messageid);
				}else{
					mini.hideMessageBox(messageid);
					mini.alert(json.fileMessage);
				}
			}else{
				mini.hideMessageBox(messageid);
				mini.alert("上传失败.");
			}
		},
		error: function(data, status, e){
			mini.hideMessageBox(messageid);
			mini.alert("上传失败.");
		}
	});
}

//通用删除上传图片方法
//imgobj:上传文本对象
//uploadurl:删除的执行url地址
//htmlo:所有页面的隐藏文本、div层id等信息的对象
//paramo:传递额外执行的参数对象
function _img_delete(imgobj, deleteurl, htmlo, paramo) {
	$.ajax({
		url: deleteurl,
	    data: paramo,
	    success: function (result) {
	    	if(result!=""){
	    		var json = eval('(' +result+ ')');
	    		if(json.fileState=="1"){
	    			mini.get(htmlo.valueid).setValue("");
	    			$("#"+htmlo.deleteimgid).val("");
					$("#"+htmlo.fullurlid).removeAttr("src");
					$("#"+htmlo.viewdivid).hide();
					$("#"+htmlo.uploaddivid).show();
					$("#"+htmlo.deletedivid).hide();
    	    	}else {
					mini.alert(json.fileMessage);
            	}
	    	}else{
				mini.alert("删除失败.");
			}
	    },
	    error: function (jqXHR, textStatus, errorThrown) {
	    	mini.alert("删除失败.");
	    }
	});
}

//通用修改保存可编辑表格的数据方法
function _common_ajax_function(json, ajaxurl, backfun,loading,successmessage, errormessage) {
	mini.mask({
        el: document.body,
        cls: 'mini-mask-loading',
        html: loading
    });
	
	if(!isEmpty(json, false)) {
		$.ajax({
			url: ajaxurl,
			type:"post",
			dataType:"json",
	   		contentType:"application/json",
		    data:json,
		    success: function (obj) {

    	        if(obj.success) {
    	        	if(typeof(eval(backfun)) == "function") {
	    	        	var fn = eval(backfun);
	    	        	fn(obj);
	    	        }
    	        	mini.unmask(document.body);
    	        	mini.alert(successmessage);
	    	    }else{
	    	    	mini.unmask(document.body);
	    	    	mini.alert(errormessage);
	        	}
		    },
		    error: function (jqXHR, textStatus, errorThrown) {
		    	mini.unmask(document.body);
		        mini.alert(errormessage);
		    }
		});
	}
}

function createJson(jobj,prop, val) {
    if(typeof val === "undefined") {
        delete jobj[prop];
    }
    else {
        jobj[prop] = val;
    }
}

function arrayToJson(o) {
	var r = [];
	if (typeof o == "string"){
		return "\"" + o.replace(/([\'\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
	}
	if (typeof o == "object") {
		if (!o.sort) {
			for (var i in o)
			r.push(i + ":" + arrayToJson(o[i]));
			if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {
				r.push("toString:" + o.toString.toString());
			}
			r = "{" + r.join() + "}";
		} else {
			for (var i = 0; i < o.length; i++) {
				r.push(arrayToJson(o[i]));
			}
			r = "[" + r.join() + "]";
		}
		return r;
	}
	return o.toString();
}
var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
function generateMixed(n) {
	var res = "";
    for(var i = 0; i < n ; i ++) {
    	var id = Math.ceil(Math.random()*35);
        res += chars[id];
    }
    return res;
}
function onImgErrorLoad(obj){
	$(obj).attr("src","<%=path %>/res/images/imageError.GIF");
}

function onActionRenderer(e) {
         var grid = e.sender;
         var record = e.record;
         var _uid = record._uid;
         var rowIndex = e.rowIndex;
         var icoSrc=staticDomain+"/images/finder_drop_arrow.gif";
         var s = '<img src='+icoSrc+' onclick="showView(' + _uid + ')"/>';
         return s;
}

function editRowInfo(gridid,viewFormId,readOnlyViewFormId,ajaxurl,row_uid) {
		 var grid = mini.get(gridid);
		 var viewForm = document.getElementById(viewFormId);
         var shrink = mini.get("Shrink_row");
         _currentRow = row_uid;
         if (isEmpty(shrink.getValue(), false)) {
             shrink.setValue(row_uid);
             var row = grid.getRowByUID(row_uid);
             if (row) {
                 //显示行详细
                 grid.hideAllRowDetail();
                 grid.showRowDetail(row);
                 //将editForm元素，加入行详细单元格内
                 var td = grid.getRowDetailCellEl(row);
                 td.appendChild(viewForm);
                 viewForm.style.display = "";
                 var id = row.id;
                 if (!isEmpty(id, false)) {
                     var form = new mini.Form("#"+readOnlyViewFormId);
                     form.clear();
                     form.loading();
                     $.ajax({
                         url: ajaxurl+"?id=" + id,
                         dataType:"json",
	   		             contentType:"application/json",
                         success: function (obj) {
                             form.unmask();
                             var o = mini.decode(obj.data);
                             form.setData(o);
                             labelModel(readOnlyViewFormId);
                         }, error: function () {
                             mini.alert("表单加载错误");
                             form.unmask();
                         }
                     });

                 }
                 grid.doLayout();
             }
         } else {
             grid.hideAllRowDetail();
             mini.get("Shrink_row").setValue("");
         }
}

function onDefaultRenderer(id,val,valueField,textField){
        var name="";
        var data=mini.get(id).getData();
        for(var o in data){ 
           var obj=data[o];
            alert();
        	if(val==eval('obj.'+valueField)){
        		name=eval('obj.'+textField);
        		break; 
        	}
        }
        return name;
}