document.write('<link href="/miniui/miniui.css" rel="stylesheet" type="text/css" />');
document.write('<script src="/miniui/boot.js" type="text/javascript"></script>');
document.write('<script src="/js/common/ajaxhook.js" type="text/javascript"></script>');
document.write('<script src="/js/common/jquery.cookie.min.js" type="text/javascript"></script>');
//加密相关js开始
document.write('<script src="/js/common/core.js" type="text/javascript"></script>');
document.write('<script src="/js/common/enc-base64.js" type="text/javascript"></script>');
document.write('<script src="/js/common/enc-utf8.js" type="text/javascript"></script>');
document.write('<script src="/js/common/md5.js" type="text/javascript"></script>');
document.write('<script src="/js/common/hmac.js" type="text/javascript"></script>');
document.write('<script src="/js/common/hmac-md5.js" type="text/javascript"></script>');
document.write('<script src="/js/common/evpkdf.js" type="text/javascript"></script>');
document.write('<script src="/js/common/cipher-core.js" type="text/javascript"></script>');
document.write('<script src="/js/common/aes.js" type="text/javascript"></script>');
document.write('<script src="/js/common/sign.js" type="text/javascript"></script>');
document.write('<script src="/js/ajaxfileupload.js" type="text/javascript"></script>');
document.write('<script src="/miniui/miniui_common.js" type="text/javascript"></script>');
document.write('<script src="/js/cloud.js" type="text/javascript"></script>');
document.write('<script src="/js/template-web.js" type="text/javascript"></script>');
//获取用户会话信息,返回json对象
function getSessionUser(){
	var encryptedData=jQuery.cookie('su');
	if(!isEmpty(encryptedData,false)){      		  
		  var decryptData=getAESDecryptData(encryptedData);
		  var su=JSON.parse(decryptData);
		  return su;
	}else{
		return null;
	}
}

