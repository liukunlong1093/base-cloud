document.write('<script src="/static/js/common/ajaxhook.js" type="text/javascript"></script>');
document.write('<script src="/static/js/common/jquery.cookie.min.js" type="text/javascript"></script>');
//加密相关js开始
document.write('<script src="/static/js/common/core.js" type="text/javascript"></script>');
document.write('<script src="/static/js/common/enc-base64.js" type="text/javascript"></script>');
document.write('<script src="/static/js/common/enc-utf8.js" type="text/javascript"></script>');
document.write('<script src="/static/js/common/md5.js" type="text/javascript"></script>');
document.write('<script src="/static/js/common/hmac.js" type="text/javascript"></script>');
document.write('<script src="/static/js/common/hmac-md5.js" type="text/javascript"></script>');
document.write('<script src="/static/js/common/evpkdf.js" type="text/javascript"></script>');
document.write('<script src="/static/js/common/cipher-core.js" type="text/javascript"></script>');
document.write('<script src="/static/js/common/aes.js" type="text/javascript"></script>');
//加密相关js结束
//cookie域名信息
var cookieDomain="www.e.com";
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