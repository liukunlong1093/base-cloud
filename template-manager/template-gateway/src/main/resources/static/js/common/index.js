//Info项目接口域名
var infoDomain = "http://gzinfo.ecoeco.com";

//静态资源页面
var staticDomain= "http://gz.ecoeco.com";

//图片访问域名
var imageDomain="http://gzinfo.ecoeco.com/upload";

//cookie域名信息
var cookieDomain="127.0.0.1";
//用户信息已经失效不需要重新登陆的页面
var noLoginPage="index.html,news.html,login.html,register.html,func.html,nav.html,find_psd.html,new_file.html,talent_agreement.html,company_agreement.html,newsDetial.html,talentPool.html,joinUs.html,contactUs.html,reset_psd.html";
document.write('<script src="../../js/common/ajaxhook.js" type="text/javascript"></script>');
document.write('<script src="../../js/common/jquery.cookie.min.js" type="text/javascript"></script>');
//加密相关js开始
document.write('<script src="../../js/common/core.js" type="text/javascript"></script>');
document.write('<script src="../../js/common/enc-base64.js" type="text/javascript"></script>');
document.write('<script src="../../js/common/enc-utf8.js" type="text/javascript"></script>');
document.write('<script src="../../js/common/md5.js" type="text/javascript"></script>');
document.write('<script src="../../js/common/hmac.js" type="text/javascript"></script>');
document.write('<script src="../../js/common/hmac-md5.js" type="text/javascript"></script>');
document.write('<script src="../../js/common/evpkdf.js" type="text/javascript"></script>');
document.write('<script src="../../js/common/cipher-core.js" type="text/javascript"></script>');
document.write('<script src="../../js/common/aes.js" type="text/javascript"></script>');
//加密相关js结束
$(document).ready(function(){
	
    var $notice_wrap = $("#notice-wrap");
     var tr_coll = $("#user-info>tbody").find("tr");
     for(var i=0,j=$(tr_coll).length; i<j;i++){
         var sta_td =$($(tr_coll)[i]).children("td").eq(7)
         var text = $(sta_td).text();
        switch(text){
            case "启用":
                 sta_td.css({"color":"rgba(0,149,231,1)"});
                 break;
            case "禁用":
                 sta_td.css({"color":"rgba(238,111,11,1)"});
                 break;
            default:;
        }
     }
    /*根据按钮显示相应的提示信息， 模态框监听shown.bs.modal事件，2016年10月14日13:53:53*/
    $("#sms-alert").on("show.bs.modal",function(event){
        $notice_wrap.hasClass("notice-active")?$notice_wrap.removeClass("notice-active"):"";
       var button = $(event.relatedTarget),
           title = button.data('title'),
           value = button.data('value');
        var  modal = $(this);
        modal.find("#sms-title").text(title);
        modal.find(".modal-body p").text(value);
    });
	$("#sms-alert").on("hidden.bs.modal",function(event){
		var btn = event.relatedTarget;
		var	id = $(btn).data("id");
		switch(id){
			case "delete-group":
				break;
			case "":
				break;
			case "":
				break;
			default :
				break;
		}
	});
    /*编辑，新增模态框显示对应的标题，2016年12月16日10:35:50*/
    $("#addOrEdit").on("show.bs.modal",function(event){
        $notice_wrap.hasClass("notice-active")?$notice_wrap.removeClass("notice-active"):"";
        var $rel_target = $(event.relatedTarget);
        var title = $rel_target.data("title");
        $(this).find().text(title);
    });
    
    var ___url=""//请求地址
    var requestTypeName="";//请求类型名称.POST OR GET
    //统一js异步请求过滤器开始
    hookAjax({
        onreadystatechange:function(xhr){
            console.log("onreadystatechange called: %O",xhr)
            //return true

        },
        onload:function(xhr){
            //console.log("onload called: %O",xhr)
           // xhr.responseText="hook"+xhr.responseText;
            //return true;
        },
        open:function(arg,xhr){
        	requestTypeName=arg[0];
        	___url=arg[1];
        	if(requestTypeName=="GET"){
        		var accountInfo=getAccountInfo();
                if(accountInfo){
              	  var token=accountInfo.access_token;
              	  var secret=accountInfo.secret;
              	  var timestamp=getNowFormatDate();
              	  var params=parseQueryString(___url);
              	  if(isEmpty(params.sign,false)){//如果已经签名则不需要进行二次签名
              		  params.token=token;
              		  params.timestamp=timestamp;
              		  if(isEmpty(params.data,false) || params.data=="undefined"){//如果data内容为空或者为undefined 则data参数不参与签名
              			  delete params.data;
              		  }
              		  
              		  delete params.moduleName;
              		  delete params.extName;
              		  delete params.fileStr;
              		  delete params.pageNo;
              		  delete params.pageSize;
              		  delete params.format;
              		  delete params.callback;
              		  delete params._;
              		  //需要动态
//              		  var signParams={};
//              		  if(params){
//              			  for(var param in params){
//              				  alert(param);
//              				  if(param=="action" || param=="data" || param=="token" || param=="timestamp"){
//              					  signParams.param=params[param];
//              				  }
//              			  }
//              			  
//              		  }
//              		  debugger;
              		  //处理特殊字符编码
              		  if(!isEmpty(params.data,false)){
              			  params.data = params.data.replace(/%20/gi, "+").replace(/(!)|(')|(\()|(\))|(\~)/gi, function(item) {
              				  return "%" + item.charCodeAt(0).toString(16).toLocaleUpperCase();
              			  });
    			      }
              		  var sign=signTopRequestNew(params,secret);
              		  arg[1]=___url+"&token="+token+"&timestamp="+timestamp+"&sign="+sign;
              	  }
                }
        	}
          console.log("open called: method:%s,url:%s,async:%s",arg[0],arg[1],arg[2],xhr)
          //统一添加请求头

        },
        send:function(arg,xhr){
          if(requestTypeName=="POST"){//post需要单独取出来数据处理
        	  var accountInfo=getAccountInfo();
        	  if(accountInfo){
        		  var token=accountInfo.access_token;
        		  var secret=accountInfo.secret;
        		  var data="";
        		  if(requestTypeName=="POST"){//post需要单独取出来数据处理
        			  data=arg[0];
        			  if(!isEmpty(___url,false) && !isEmpty(data,false)){
        				  ___url=___url+"&"+data;
        			  }
        		  }
        		  
        		  var timestamp=getNowFormatDate();
        		  var params=parseQueryString(___url);
        		  if(isEmpty(params.sign,false)){//如果已经签名则不需要进行二次签名
        			  params.token=token;
        			  params.timestamp=timestamp;
        			  if(isEmpty(params.data,false) || params.data=="undefined"){//如果data内容为空或者为undefined 则data参数不参与签名
        				  delete params.data;
        			  }   
        			  delete params.moduleName;
              		  delete params.extName;
              		  delete params.fileStr;
        			  delete params.pageNo;
        			  delete params.pageSize;
        			  delete params.format;
        			  delete params.callback;
        			//处理特殊字符编码
        			  if(!isEmpty(params.data,false)){
              				params.data = params.data.replace(/%20/gi, "+").replace(/(!)|(')|(\()|(\))|(\~)/gi, function(item) {
              					return "%" + item.charCodeAt(0).toString(16).toLocaleUpperCase();
                    	    });
      			      }
        			  var sign=signTopRequestNew(params,secret);
        			  if(isEmpty(params.data,false) || params.data=="undefined"){//如果post提交没有data参数
        				  if(isEmpty(arg[0],false) ||  arg[0]=="undefined"){//如果POST提交没有额外参数否则拼接上额外参数
        					  data="token="+token+"&timestamp="+timestamp+"&sign="+sign;
        				  }else{
        					  data=arg[0]+"&token="+token+"&timestamp="+timestamp+"&sign="+sign;
        				  }
        			  }else{
        				  if(isEmpty(arg[0],false) ||  arg[0]=="undefined"){//如果POST提交没有额外参数否则拼接上额外参数
        					  data="token="+token+"&timestamp="+timestamp+"&sign="+sign;
        				  }else{
        					  data=arg[0]+"&token="+token+"&timestamp="+timestamp+"&sign="+sign;
        				  }
        			  }      	
        			  arg[0]=data;
        		  }
        	  }
          }
          console.log("send called: %O",arg[0])
          //xhr.setRequestHeader("_custom_header_","ajaxhook")
        },
        setRequestHeader:function(arg,xhr){
            console.log("setRequestHeader called!",arg)
        }
    });
    //统一js异步请求过滤器结束
    
    /*加载alert提示框，modified by xuwl 2017年1月3日10:31:12*/
    alertInfo();
    
    
    //如果cooke失效则弹出提示信息,需要美化
	cookieExpiresRun(); //加载页面时启动定时器  
	var ___interval;
	function cookieExpiresRun() {
		___interval = setInterval(cookieExpiresChat, "1000");
	}
	function cookieExpiresChat() {
		var su=jQuery.cookie("gz_my");
	    if(su="\"\"" && isEmpty(su,false)){
	    	clearTimeout(___interval); //关闭定时器  
	    	var ___locationUrl=window.location.href;
	    	var pathname = window.location.pathname;
	    	if(pathname!="/" && pathname!="/login.html" && isIncludeFilterPage()==0){
	    		/*alert("用户信息已经失效请重新登陆!");*/
	    		var callbackUrl = "";
	        	//获取url参数json对象
	    		var urlParamObj=parseQueryString(location.search)
	    		if(!isEmpty(urlParamObj.callbackUrl,false)){
	    			callbackUrl = urlParamObj.callbackUrl;
	    			window.location.href=GZWWW+"?callbackUrl="+callbackUrl;
	    		}else{
	    			window.location.href=GZWWW;
	    		}
	    		
	    	}
	    }
	}
	
  /*头部菜单高亮显示，modified by xuwl:2017年3月8日17:53:36*/
    var currentURL = location.href;
    var curTag = getParamsByUrl(currentURL);
    try{
        if(curTag && curTag.tag){
            var tag = curTag.tag;
                tag = tag.toUpperCase();
            switch(tag){
              case "INDEX":
                  $("a#index").parent().addClass("curActive");
                  break;
              case "ASSESS":
                   $("a#nav_assess").parent().addClass("curActive");
                  break;
              case "GROUP":
                   $("a#nav_learn").parent().addClass("curActive");
                  break;
              case "WORK":
                   $("#__change").addClass("curActive");
                  break;
              case "ACTIVITY":
                   $("a#activity").parent().addClass("curActive");
                  break;
              default:;
            }
        }
    }catch(e){
        console.warn("部分页面无法获取该标志，属于正常现象，不要害怕！");
    }
    refreshToken();
});

//是否包含需要过滤的页面 0不包含 1.包含
function isIncludeFilterPage(){
	var flag=0;
	var pages=noLoginPage.split(",");
	var ___locationUrl=window.location.href;
	for(var i in pages){
		if(___locationUrl.indexOf(pages[i])>=0){
			flag=1;
			break;
		}
	}
	return flag;
}
function preView(file,$wrap){
    var content = "";
    var $container = $wrap?$wrap:$("#img-wrap");
    if(file.files && file.files[0]){
        var reader = new FileReader();
        reader.onload = function(event){
             content = "<div class='col-sm-6 text-center col-xs-offset-4 wrap-license'><i class='layui-icon'>&#x1006;</i><img class='img-responsive' src="+event.target.result+" alt="+event.target.fileName+"/></div>";
            /*营业执照只有正反两面*/
            if($container.hasClass("zhizhaoImg")){
                if($container.children(".wrap-license").length > 1){
                   $container.children(".wrap-license:eq(0)").remove();
                }
                $container.append(content);
            }else{
              $container.html(content).removeClass("fade").addClass("fade-in row");
            }
        }
        reader.readAsDataURL(file.files[0]);
    }  /*针对IE浏览器做处理,2017年3月9日10:33:05*/
    if(document.all){
        if(file.value){
            content = '<div class="col-sm-6 text-center col-xs-offset-4" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
            $container.html(content).removeClass("fade").addClass("fade-in row");
        }
    }  
}

//-------------------------前端数据签名加密相关方法开始----------------------------------------
//base64编码
function base64Encode(str) {
	var val = CryptoJS.enc.Utf8.parse(str);
	var base64 = CryptoJS.enc.Base64.stringify(val);
	return base64;
}
//base64解码(使用秘钥解码不需要CryptoJS.enc.Utf8)
function base64Decode(baseStr) {
    var val = CryptoJS.enc.Base64.parse(baseStr);
	try{
		val=val.toString(CryptoJS.enc.Utf8)
	}catch(e){
	}
    return val;
}

//获取签名
function signTopRequestNew(params,secret){
	  var keys = [];
	  for(var key in params){
		keys.push(key);
	  }
	  keys.sort();
	  var query="";
	  for (var i = 0, l = keys.length; i < l; i++) {
			var key = keys[i];
			var value=params[key]
			if(isEmpty(key,false) || isEmpty(value,false) || key=="callback"){
				continue;
			}else{
				query=query+key+value
			}
	   }
	   var decodeSecret=base64Decode(secret);
	   var sign = CryptoJS.HmacMD5(query,decodeSecret);
	   return sign
}
//判断是否为空
function isEmpty(v, allowBlank){
   		return v === null || v === undefined || (!allowBlank ? v === '' : false);
} 
//获取当前时间格式为 yyyy-MM-dd HH:mm:ss
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
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

//-------------------------前端数据签名加密相关方法结束--------------------------------------------
//-------------------------前端AES加密开始--------------------------------------------
//需要引用aes.js
function getAesString(data,key,iv){//加密
    var key  = CryptoJS.enc.Hex.parse(key);
    var iv   = CryptoJS.enc.Latin1.parse(iv);
    var encrypted = CryptoJS.AES.encrypt(data,key,{iv:iv,mode:CryptoJS.mode.CBC,padding:CryptoJS.pad.Pkcs7});
    return encrypted;
}
function getDAesString(encrypted,key,iv){//解密
    var key  = CryptoJS.enc.Hex.parse(key);
    var iv   = CryptoJS.enc.Latin1.parse(iv);
    var decrypted = CryptoJS.AES.decrypt(encrypted,key,{iv:iv,mode:CryptoJS.mode.CBC,padding:CryptoJS.pad.Pkcs7});
    return decrypted.toString(CryptoJS.enc.Utf8);
}

//获取AES加密后的数据
function getAESEncryptedData(plainText){ //加密
    var key  = '1234567812345678';  //密钥
    var iv   = 'Pkcs7';
    var encrypted = getAesString(plainText,key,iv); //密文
    return encrypted;
}
//获取AES解密后的数据
function getAESDecryptData(cipherText){//解密
    var key  = '1234567812345678';
    var iv   = 'Pkcs7';
    var decryptedStr = getDAesString(cipherText,key,iv);
    return decryptedStr;
}
//获取账号信息,返回json对象
function getAccountInfo(){
	var encryptedData=jQuery.cookie('gz_my');
	if(!isEmpty(encryptedData,false)){      		  
		  var decryptData=getAESDecryptData(encryptedData);
		  var accountInfoJsonObj=JSON.parse(decryptData);
		  return accountInfoJsonObj;
	}else{
		return null;
	}
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
//获取签名相关的参数的URL字符串例如&token=11111&timestamp=2017-01-04&sign=123213123123
function getSignParamUrlStr(url){
	var paramUrlStr="";
	var accountInfo=getAccountInfo();
	if(accountInfo){
		  //秘钥
		  var secret=accountInfo.secret;
		  //url地址参数json对象
		  var params=parseQueryString(url);
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
		  paramUrlStr=paramUrlStr+"&token="+token+"&timestamp="+timestamp+"&sign="+sign;
	 }
	 return paramUrlStr;
}

/*DOM文档结构中添加alert弹出层消息！*/
function alertInfo(){
    //<!--自定义,启,停,重置,等等模态框的基本样式哦！ 2016年10月13日17:33:56-->
    var str = '<div class="modal fade cus-size" id="sms-alert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">'+
                    '<div class="modal-dialog" role="document">'+
                            '<div class="modal-content">'+
                                '<div class="modal-header m-header-color">'+
                                    '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
                                    '<h4 class="modal-title text-center" id="sms-title">操作提示</h4>'+
                                '</div>'+
                                '<div class="modal-body text-center">'+
                                    '<h5 class="text-warning warning-size"><i class="glyphicon glyphicon-exclamation-sign"></i></h5>'+
                                    '<p>是否执行该操作</p>'+
                                '</div>'+
                                '<div class="modal-footer text-center">'+
                                    '<button type="button" class="button button-tiny button-glow button-highlight" data-dismiss="modal">取消</button>'+
                                    '<button type="button" class="button button-tiny button-glow button-primary" data-id="confirm" id="delete-confirm">确定'+
                                    '</button>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                '</div>';
    $str = $(str);
    $(document.body).append($str);
}
function showAlert(info){
     var info = info?info:"警告啦警告啦！"
     var $alert = $("#sms-alert");
     $alert.find(".modal-body>p").text(info);
     $alert.modal("show");
}
//退出
function logout(){
	var logoutUrl=GZMY+"/account/account.do?action=logout";
	$.ajax({
	        url:logoutUrl,
	        type:"GET",
	        dataType:"json",
	        async:false,
	        success:function(response,textStatus){
	            if (response.state =="0" || response.state =="999") {
                   jQuery.cookie('gz_my',null, {expires:0, path: '/',domain:cookieDomain});
                   window.location.href=GZWWW;
                }
	        }
    });
}


/**获取url中的参数值
 * sHref ：地址
 * sArgName：参数名称
 * ****/
function getArgsFromHref(sHref, sArgName){
	  var args    = sHref.split("?");
	  var retval = "";
	
	  if(args[0] == sHref) /*参数为空*/
	  {
	       return retval; /*无需做任何处理*/
	  }  
	  var str = args[1];
	  args = str.split("&");
	  for(var i = 0; i < args.length; i ++)
	  {
	      str = args[i];
	      var arg = str.split("=");
	      if(arg.length <= 1) continue;
	      if(arg[0] == sArgName) retval = arg[1]; 
	  }
	  return retval;
}

/*获取url地址栏的参数，add by xuwl 2017年2月10日15:41:37*/
function getParamsByUrl(url){
    var  myUrl = url.split("?"),
        str_params = "";
     var obj = {};
    if(myUrl.length>1){
        console.log(myUrl);
        str_params = myUrl[1];
        if(str_params.indexOf("&")>0){
            var arr_params = str_params.split("&");
            for(var i in arr_params){
                var param = arr_params[i];
                var arr = param.split("=");
                obj[arr[0]] = arr[1];
            }
        }else{
           var temp = str_params.split("=");
           obj[temp[0]] = temp[1];
        }
    }     
    return obj;
}

function __commonSearch(){
	var searchType=$(".search-type").val();
	var __keyWord=$("#__keyWord").val();
	if("0"==searchType){
		location.href = GZWWW+"/page/study/study.html?title="+__keyWord;
	}else if("1"==searchType){
		location.href = GZWWW+"/page/common/assessment.html?title="+__keyWord;
	}else if("2"==searchType){
		location.href = GZWWW+"/news.html?title="+__keyWord;
	}
}
/****格式化时间js
 * 使用示例：
 * var time=new Date('2016.1.2 15:01:00');
   time=time.format("yyyy-MM-dd");
 * 
 */
Date.prototype.format = function(format)  
{  
   var o = {  
     "M+" : this.getMonth()+1, //month  
     "d+" : this.getDate(),    //day  
     "h+" : this.getHours(),   //hour  
     "m+" : this.getMinutes(), //minute  
     "s+" : this.getSeconds(), //second  
     "q+" : Math.floor((this.getMonth()+3)/3), //quarter  
     "S" : this.getMilliseconds() //millisecond  
   }  
   if(/(y+)/.test(format)) format=format.replace(RegExp.$1,  
     (this.getFullYear()+"").substr(4 - RegExp.$1.length));  
   for(var k in o)if(new RegExp("("+ k +")").test(format))  
     format = format.replace(RegExp.$1,  
       RegExp.$1.length==1 ? o[k] :   
         ("00"+ o[k]).substr((""+ o[k]).length));  
   return format;  
}  
//判断对象是否为空
function isEmptyObject(e) {  
    var t;  
    for (t in e)  
        return !1;  
    return !0  
}
//刷新token
function refreshToken(){
	var url = window.location.href;
	var pathname = window.location.pathname;
	if(pathname=="/page/common/assessment.html"||pathname=="/page/study/study.html"||pathname=="/page/talent/matching.html"||
			pathname=="/page/activity/activity.html"||pathname=="/page/company/HRmanagement.html"){
		var actionUrl=GZMY+"/tokenController/tokenController.do?action=refreshToken";
		$.ajax({
		        url:actionUrl,
		        type:"get",
		        dataType:"json",
		        success:function(data,textStatus){
		           var state = data.state;
		           if(state==0){
	                   //登陆成功用户信息经过AES加密后存入cookie中开始
					    var expires_in=data.data.expires_in;//单位分钟
					    expires_in=parseInt(expires_in);
					    var expiresDate= new Date();
						expiresDate.setTime(expiresDate.getTime() + (expires_in * 60 * 1000)); //?替换成分钟数如果为60分钟则为 60 * 60 *1000
						var su=jQuery.cookie("gz_my");
					    jQuery.cookie('gz_my',su, {expires:expiresDate, path: '/',domain:cookieDomain});
		           }else if(state==999){//token失效
		        	   logout();
		           }
		        }
	    });
	}
}
//公共处理返回的状态方法，可以用来统一处理token失效登出功能
function processState(state){
	if(state==0){
		return true;
	}else if(state==999){//token失效
		logout();
	}
}