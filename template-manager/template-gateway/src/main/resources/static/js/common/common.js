//接口访问域名
var GA = "http://gamy.ecoeco.com";

//时间格式化代码
Date.prototype.format = function(format) {
  var o = {
    "M+": this.getMonth() + 1, //month  
    "d+": this.getDate(), //day  
    "h+": this.getHours(), //hour  
    "m+": this.getMinutes(), //minute  
    "s+": this.getSeconds(), //second  
    "q+": Math.floor((this.getMonth() + 3) / 3), //quarter  
    "S": this.getMilliseconds() //millisecond  
  }
  if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
    (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  for (var k in o)
    if (new RegExp("(" + k + ")").test(format))
      format = format.replace(RegExp.$1,
        RegExp.$1.length == 1 ? o[k] :
        ("00" + o[k]).substr(("" + o[k]).length));
  return format;
}

//地址栏解析函数
function getParamsByUrl(url) {
  var myUrl = url.split("?"),
    str_params = "";
  var obj = {};
  if (myUrl.length > 1) {
    console.log(myUrl);
    str_params = myUrl[1];
    if (str_params.indexOf("&") > 0) {
      var arr_params = str_params.split("&");
      for (var i in arr_params) {
        var param = arr_params[i];
        var arr = param.split("=");
        obj[arr[0]] = arr[1];
      }
    } else {
      var temp = str_params.split("=");
      obj[temp[0]] = temp[1];
    }
  }
  return obj;
}
//表单数据填充函数
function loadFormData(jsonStr) {
  var obj = jsonStr;
  var key, value, tagName, type, arr;
  for (x in obj) {
    key = x;
    value = obj[x];
    $("[name='" + key + "'],[name='" + key + "[]']").each(function() {
      tagName = $(this)[0].tagName;
      type = $(this).attr('type');
      if (tagName == 'INPUT') {
        if (type == 'radio') {
          $(this).attr('checked', $(this).val() == value);
        } else if (type == 'checkbox') {
          arr = value.split(',');
          for (var i = 0; i < arr.length; i++) {
            if ($(this).val() == arr[i]) {
              $(this).attr('checked', true);
              break;
            }
          }
        } else {
          $(this).val(value);
        }
      } else if (tagName == 'SELECT' || tagName == 'TEXTAREA') {
        $(this).val(value);
      }

    });
  }
}

//判断是否为空
function isEmpty(v, allowBlank) {
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
  var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate + " " + date.getHours() + seperator2 + date.getMinutes() + seperator2 + date.getSeconds();
  return currentdate;
}
//把URL参数转为Json字符串
function parseQueryString(url) {
  var obj = {};
  var keyvalue = [];
  var key = "",
    value = "";
  var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
  for (var i in paraString) {
    keyvalue = paraString[i].split("=");
    key = keyvalue[0];
    value = keyvalue[1];
    obj[key] = value;
  }
  return obj;
}
//获取账号信息,返回json对象
function getAccountInfo() {
  var encryptedData = jQuery.cookie('ga_my');
  console.log(encryptedData);
  if (!isEmpty(encryptedData, false)) {
    var decryptData = getAESDecryptData(encryptedData);
    var accountInfoJsonObj = JSON.parse(decryptData);
    return accountInfoJsonObj;
  } else {
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
  // alert(url);
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

//统一js异步请求过滤器开始
var ___url = "" //请求地址
var requestTypeName = ""; //请求类型名称.POST OR GET
hookAjax({
  onreadystatechange: function(xhr) {
    console.log("onreadystatechange called: %O", xhr)
      //return true

  },
  onload: function(xhr) {
    //console.log("onload called: %O",xhr)
    // xhr.responseText="hook"+xhr.responseText;
    //return true;
  },
  open: function(arg, xhr) {
    requestTypeName = arg[0];
    ___url = arg[1];
    if (requestTypeName == "GET") {
      var accountInfo = getAccountInfo();
      if (accountInfo) {
        var token = accountInfo.access_token;
        var secret = accountInfo.secret;
        var timestamp = getNowFormatDate();
        var params = parseQueryString(___url);
        if (isEmpty(params.sign, false)) { //如果已经签名则不需要进行二次签名
          params.token = token;
          params.timestamp = timestamp;
          if (isEmpty(params.data, false) || params.data == "undefined") { //如果data内容为空或者为undefined 则data参数不参与签名
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
          //                    var signParams={};
          //                    if(params){
          //                      for(var param in params){
          //                        alert(param);
          //                        if(param=="action" || param=="data" || param=="token" || param=="timestamp"){
          //                          signParams.param=params[param];
          //                        }
          //                      }
          //                      
          //                    }
          //                    debugger;
          //处理特殊字符编码
          if (!isEmpty(params.data, false)) {
            params.data = params.data.replace(/%20/gi, "+").replace(/(!)|(')|(\()|(\))|(\~)/gi, function(item) {
              return "%" + item.charCodeAt(0).toString(16).toLocaleUpperCase();
            });
          }
          var sign = signTopRequestNew(params, secret);
          // alert(___url);
          if(___url.indexOf('?') != -1){
            arg[1] = ___url + "&token=" + token + "&timestamp=" + timestamp + "&sign=" + sign;
          } else {
            arg[1] = ___url + "?token=" + token + "&timestamp=" + timestamp + "&sign=" + sign;
          }
           //arg[1] = ___url + "?token=" + token + "&timestamp=" + timestamp + "&sign=" + sign;
        }
      }
    }
    console.log("open called: method:%s,url:%s,async:%s", arg[0], arg[1], arg[2], xhr)
      //统一添加请求头

  },
  send: function(arg, xhr) {
    // alert(___url);
    if (requestTypeName == "POST") { //post需要单独取出来数据处理
      var accountInfo = getAccountInfo();
      if (accountInfo) {
        var token = accountInfo.access_token;
        var secret = accountInfo.secret;
        var data = "";
        if (requestTypeName == "POST") { //post需要单独取出来数据处理
          data = arg[0];
          if (!isEmpty(___url, false) && !isEmpty(data, false)) {
            ___url = ___url + "&" + data;
          }
        }

        var timestamp = getNowFormatDate();
        var params = parseQueryString(___url);
        if (isEmpty(params.sign, false)) { //如果已经签名则不需要进行二次签名
          params.token = token;
          params.timestamp = timestamp;
          if (isEmpty(params.data, false) || params.data == "undefined") { //如果data内容为空或者为undefined 则data参数不参与签名
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
          if (!isEmpty(params.data, false)) {
            params.data = params.data.replace(/%20/gi, "+").replace(/(!)|(')|(\()|(\))|(\~)/gi, function(item) {
              return "%" + item.charCodeAt(0).toString(16).toLocaleUpperCase();
            });
          }
          var sign = signTopRequestNew(params, secret);
          if (isEmpty(params.data, false) || params.data == "undefined") { //如果post提交没有data参数
            if (isEmpty(arg[0], false) || arg[0] == "undefined") { //如果POST提交没有额外参数否则拼接上额外参数
              data = "&token=" + token + "&timestamp=" + timestamp + "&sign=" + sign;
            } else {
              data = arg[0] + "&token=" + token + "&timestamp=" + timestamp + "&sign=" + sign;
            }
          } else {
            if (isEmpty(arg[0], false) || arg[0] == "undefined") { //如果POST提交没有额外参数否则拼接上额外参数
              data = "&token=" + token + "&timestamp=" + timestamp + "&sign=" + sign;
            } else {
              data = arg[0] + "&token=" + token + "&timestamp=" + timestamp + "&sign=" + sign;
            }
          }

          arg[0]=data;
        }
      }
    }
    console.log("send called: %O", arg[0])
      //xhr.setRequestHeader("_custom_header_","ajaxhook")
  },
  setRequestHeader: function(arg, xhr) {
    console.log("setRequestHeader called!", arg)
  }
});
// //统一js异步请求过滤器结束

$(function(){
    $("#yuangong").click(function(){
        $("#nav-msg01").text("人事管理");
        $("#nav-msg02").text("员工管理");
  })

  $("#wokerset").click(function(){
      $("#nav-msg01").text("人事管理");
      $("#nav-msg02").text("员工设置");
  })
    $("#recharge").click(function(){
      $("#nav-msg01").text("资产管理");
      $("#nav-msg02").text("在线充值");
  })
    $("#point").click(function(){
      $("#nav-msg01").text("资产管理");
      $("#nav-msg02").text("积分管理");
  })
  $("#appcenter").click(function(){
      $("#nav-msg01").text("应用中心");
      $("#nav-msg02").text("应用市场");
  })
    $("#appchoice").click(function(){
      $("#nav-msg01").text("应用中心");
      $("#nav-msg02").text("已选应用");
  })
        $("#sum").click(function(){
      $("#nav-msg01").text("数据中心");
      $("#nav-msg02").text("消费统计");
  })
      $("#consume").click(function(){
      $("#nav-msg01").text("数据中心");
      $("#nav-msg02").text("消费明细");
  })
    $("#wokerservice").click(function(){
      $("#nav-msg01").text("员工服务");
  })
      
});