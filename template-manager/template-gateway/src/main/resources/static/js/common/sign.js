//加密相关js结束
$(document).ready(function() {
    var ___url = "" //请求地址
    var requestTypeName = ""; //请求类型名称.POST OR GET
    //统一js异步请求过滤器开始
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
                
            }
            console.log("open called: method:%s,url:%s,async:%s", arg[0], arg[1], arg[2], xhr)
            //统一添加请求头
        },
        send: function(arg, xhr) {
            if (requestTypeName == "POST") { //post需要单独取出来数据处理
                var accountInfo = getAccountInfo();
                if (accountInfo) {
                    var token = accountInfo.access_token;
                    var secret = accountInfo.secret;
                    var data = "";
                    if (requestTypeName == "POST") { //post需要单独取出来数据处理
                        data = arg[0];
                        if (!isEmpty(___url, false) && !isEmpty(data, false)) {
                        	//data=encodeURIComponent(data);
                            ___url = ___url + "&data=" + data;
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
                        //处理特殊字符编码（待完善考虑直接传入JSON）-------------
                        params.action="api-a/system/getUserById";
                        var sign = signTopRequestNew(params, secret);
                        xhr.setRequestHeader("token",token);
                        xhr.setRequestHeader("timestamp",timestamp);
                        xhr.setRequestHeader("sign",sign);
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
    //统一js异步请求过滤器结束
});

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
    try {
        val = val.toString(CryptoJS.enc.Utf8)
    } catch(e) {}
    return val;
}

//获取签名
function signTopRequestNew(params, secret) {
    var keys = [];
    for (var key in params) {
        keys.push(key);
    }
    keys.sort();
    var query = "";
    for (var i = 0,
    l = keys.length; i < l; i++) {
        var key = keys[i];
        var value = params[key]
        if (isEmpty(key, false) || isEmpty(value, false) || key == "callback") {
            continue;
        } else {
            query = query + key + value
        }
    }
    var decodeSecret = base64Decode(secret);
    var sign = CryptoJS.HmacMD5(query, decodeSecret);
    return sign
}
//判断是否为空
function isEmpty(v, allowBlank) {
    return v === null || v === undefined || (!allowBlank ? v === '': false);
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

//-------------------------前端数据签名加密相关方法结束--------------------------------------------
//-------------------------前端AES加密开始--------------------------------------------
//需要引用aes.js
function getAesString(data, key, iv) { //加密
    var key = CryptoJS.enc.Hex.parse(key);
    var iv = CryptoJS.enc.Latin1.parse(iv);
    var encrypted = CryptoJS.AES.encrypt(data, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7
    });
    return encrypted;
}
function getDAesString(encrypted, key, iv) { //解密
    var key = CryptoJS.enc.Hex.parse(key);
    var iv = CryptoJS.enc.Latin1.parse(iv);
    var decrypted = CryptoJS.AES.decrypt(encrypted, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7
    });
    return decrypted.toString(CryptoJS.enc.Utf8);
}

//获取AES加密后的数据
function getAESEncryptedData(plainText) { //加密
    var key = '1234567812345678'; //密钥
    var iv = 'Pkcs7';
    var encrypted = getAesString(plainText, key, iv); //密文
    return encrypted;
}
//获取AES解密后的数据
function getAESDecryptData(cipherText) { //解密
    var key = '1234567812345678';
    var iv = 'Pkcs7';
    var decryptedStr = getDAesString(cipherText, key, iv);
    return decryptedStr;
}
//获取账号信息,返回json对象
function getAccountInfo() {
    var encryptedData = jQuery.cookie('gz_my');
    if (!isEmpty(encryptedData, false)) {
        var decryptData = getAESDecryptData(encryptedData);
        var accountInfoJsonObj = JSON.parse(decryptData);
        return accountInfoJsonObj;
    } else {
        var _testUser={access_token:'659166A40E2B666FE07F641ABEB39449',secret:'VehiR3orHJa7agNmfHdI3UxKvFHMcQAsS+GYz3mQsicTpmyABiqD9mSB0GQyfiZat/2opfVtcjK7O7mRrUtW7g=='};
        return _testUser;
    }
}
//自动签名get方式提交的URL
function signUrlByGet(url) {
    var __url = url;
    var accountInfo = getAccountInfo();
    if (accountInfo) {
        //秘钥
        var secret = accountInfo.secret;
        //url地址参数json对象
        var params = parseQueryString(__url);
        if (isEmpty(params.data, false) || params.data == "undefined") { //如果data内容为空或者为undefined 则data参数不参与签名
            delete params.data;
        }
        delete params.pageNo;
        delete params.pageSize;
        delete params.format;
        delete params.callback;
        //签名参数获取
        var token = accountInfo.access_token;
        var timestamp = getNowFormatDate();
        params.token = token;
        params.timestamp = timestamp;
        //需要签名参数结束
        var sign = signTopRequestNew(params, secret);
        __url = __url + "&token=" + token + "&timestamp=" + timestamp + "&sign=" + sign;
    }
    return __url;
}
//获取签名相关的参数的URL字符串例如&token=11111&timestamp=2017-01-04&sign=123213123123
function getSignParamUrlStr(url) {
    var paramUrlStr = "";
    var accountInfo = getAccountInfo();
    if (accountInfo) {
        //秘钥
        var secret = accountInfo.secret;
        //url地址参数json对象
        var params = parseQueryString(url);
        if (isEmpty(params.data, false) || params.data == "undefined") { //如果data内容为空或者为undefined 则data参数不参与签名
            delete params.data;
        }
        delete params.pageNo;
        delete params.pageSize;
        delete params.format;
        delete params.callback;
        //签名参数获取
        var token = accountInfo.access_token;
        var timestamp = getNowFormatDate();
        params.token = token;
        params.timestamp = timestamp;
        //需要签名参数结束
        var sign = signTopRequestNew(params, secret);
        paramUrlStr = paramUrlStr + "&token=" + token + "&timestamp=" + timestamp + "&sign=" + sign;
    }
    return paramUrlStr;
}

/**获取url中的参数值
 * sHref ：地址
 * sArgName：参数名称
 * ****/
function getArgsFromHref(sHref, sArgName) {
    var args = sHref.split("?");
    var retval = "";

    if (args[0] == sHref)
    /*参数为空*/
    {
        return retval;
        /*无需做任何处理*/
    }
    var str = args[1];
    args = str.split("&");
    for (var i = 0; i < args.length; i++) {
        str = args[i];
        var arg = str.split("=");
        if (arg.length <= 1) continue;
        if (arg[0] == sArgName) retval = arg[1];
    }
    return retval;
}

/*获取url地址栏的参数，add by xuwl 2017年2月10日15:41:37*/
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

/****格式化时间js
 * 使用示例：
 * var time=new Date('2016.1.2 15:01:00');
   time=time.format("yyyy-MM-dd");
 * 
 */
Date.prototype.format = function(format) {
    var o = {
        "M+": this.getMonth() + 1,
        //month  
        "d+": this.getDate(),
        //day  
        "h+": this.getHours(),
        //hour  
        "m+": this.getMinutes(),
        //minute  
        "s+": this.getSeconds(),
        //second  
        "q+": Math.floor((this.getMonth() + 3) / 3),
        //quarter  
        "S": this.getMilliseconds() //millisecond  
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) if (new RegExp("(" + k + ")").test(format)) format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}
//判断对象是否为空
function isEmptyObject(e) {
    var t;
    for (t in e) return ! 1;
    return ! 0
}