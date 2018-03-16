
/**
 * 
 * bootstrap-table参数配置，公共js
 * 请勿添加跟业务相关的代码，会影响其他模块的功能
 */
function initTable(tableId,url,expand,method,data){
	    var uniqueId="id",singleSelect=false,search=false,pageSize=10,searchAlign="right",custom;
	    //如果url没有进行签名则自动就签名(签名依赖index.js)
	    var urlParam=parseQueryString(url);
        
	    if(!urlParam.sign){
	    	url=signUrlByGet(url);
	    }
        
        if(expand!=null){
    	   singleSelect=expand.singleSelect?expand.singleSelect:true;
    	   search = expand.search?true:false;
    	   pageSize=expand.pageSize?expand.pageSize:10;
    	   searchAlign=expand.searchAlign;
    	   uniqueId=expand.uniqueId?expand.uniqueId:"id";
        }
        $('#'+tableId).bootstrapTable({
             data:data,
             url:url,
             method: 'get',
             dataType: "json",
             contentType: 'application/json,charset=utf-8',
            pagination: true,
            clickToSelect: true,      //是否启用点击选中行
            singleSelect:singleSelect,        //禁止多选
            toolbar: "#toolbar",      //设置工具栏的Id或者class
            sidePagination: method, //设置为服务器端分页
            pageList: [8, 15,20],
            search:search,
            searchAlign:searchAlign,
            pageSize:pageSize,
            pageNumber: 1,
            uniqueId: uniqueId,
            silent:true,
              formatLoadingMessage: function () {  
              return "";  
            },  
            // //返回值配置，插件只接受返回值rows,total
            responseHandler:function responseHandler(res){
            	//自定义返回值
                if(res.state==0){
                  return {
                    "rows":res.data,//分页数据
                    "total":res.total//总数量
                  };
                }else{
                  return {
                    "rows":[],
                    "total":0
                  };
                }
            },
           // 分页参数配置
            queryParams: function queryParams(params) {
                //offset表示数据的偏移量
                var pageNo =params.offset/ params.limit;
                //配置参数
                var temp = {
                    //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    pageSize: params.limit,   //页面大小
                    pageNo: pageNo,  //当前页面索引
                };
                return temp;
            }
        });
    }
 
//刷新
function refeshTable(tableId){
    $("#"+tableId).bootstrapTable('refresh',{silent:true});
}
//查询
function searchTable(tableId,url){
	//如果url没有进行签名则自动就签名(签名依赖index.js)
    var urlParam=parseQueryString(url);
    if(!urlParam.sign){
    	url=signUrlByGet(url);
  
    }
	$('#'+tableId).bootstrapTable('refresh',{
        url: url,
        pageNumber: 1
     });
}
//设置行号
function indexFormatter(value, row, index) {
        return index + 1;
}
/**
 *
 * 表格操作按钮，适用大部分表格，不满足要求的，在指定页面重写actionFormatter即可
 **/
function actionFormatter(value, row, index) {

	var html='<div class="btn-group btn-group-sm my-btn-group">'+
    '<a href="#addOrEdit" data-toggle="modal"   title="编辑" class="btn btn-edit"><i class="glyphicon glyphicon-edit"></i></a>'+
    '<a href="#sms-alert" data-toggle="modal"   title="删除" data-value="是否删除!"    class="btn btn-single-trash"><i class="glyphicon glyphicon-trash"></i></a>'+
    '</div>';
    return [
        html
    ].join('');
}



//添加操作按钮
function deleteChildrenFormatter(value, row, index) {
	var html='<div class="btn-group btn-group-sm my-btn-group">'+
    '<a href="#sms-alert" data-toggle="modal"   title="删除" data-value="是否删除!"    class="btn btn-single-trash"><i class="glyphicon glyphicon-trash"></i></a>'+
    '</div>';
    return [
        html
    ].join('');
}

//添加企业列表操作按钮
function checkOrDeleteFormatter(value, row, index) {
	var html='<div class="btn-group btn-group-sm my-btn-group">'+
	'<a href="#addOrEdit" data-toggle="modal"   title="撤销审核" class="btn btn-edit"><i class="glyphicon glyphicon-edit"></i></a>'+
	'<a href="#addToIndex" data-toggle="modal"   title="首页展示" class="btn btn-edit"><i class="glyphicon glyphicon-edit"></i></a>'+
    '<a href="#sms-alert" data-toggle="modal"   title="删除" data-value="是否删除!"    class="btn btn-single-trash"><i class="glyphicon glyphicon-trash"></i></a>'+
    '</div>';
    return [
        html
    ].join('');
}

//添加待审核企业列表操作按钮
function checkFormatter(value, row, index) {
	var html='<div class="btn-group btn-group-sm my-btn-group">'+
	'<a href="#addOrEdit" data-toggle="modal"   title="审核" class="btn btn-edit"><i class="glyphicon glyphicon-edit"></i></a>'+
    '<a href="#sms-alert" data-toggle="modal"   title="删除" data-value="是否删除!"    class="btn btn-single-trash"><i class="glyphicon glyphicon-trash"></i></a>'+
    '</div>';
    return [
        html
    ].join('');
}

//把URL参数转为Json字符串
function parseQueryString(url){
	var obj={};
	var keyvalue=[];
	var key="",value=""; 
	var paraString=url.substring(url.indexOf("?")+1,url.length).split("&");
	for(var i in paraString){
		keyvalue=paraString[i].split("=");
		key=keyvalue[0];
		value=keyvalue[1];
		obj[key]=value; 
	} 
	return obj;
}
//自动签名get方式提交的URL
function signUrlByGet(url){
    var __url=url;
    var accountInfo=getAccountInfo();
    if(accountInfo){
          //秘钥
          var secret=accountInfo.secret;
          //url地址参数json对象
          var params=parseQueryString(__url);
          if(isEmpty(params.data,false) || params.data=="undefined"){//如果data内容为空或者为undefined 则data参数不参与签名
              delete params.data;
          }               
          delete params.pageNo;
          delete params.pageSize;
          delete params.format;
          delete params.callback;
          //签名参数获取
          var token=accountInfo.access_token;
          var timestamp=getNowFormatDate();
          params.token=token;
          params.timestamp=timestamp;
          //需要签名参数结束
          var sign=signTopRequestNew(params,secret);
          __url=__url+"&token="+token+"&timestamp="+timestamp+"&sign="+sign;
     }
     return __url;
}