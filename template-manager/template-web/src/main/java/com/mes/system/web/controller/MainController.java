package com.mes.system.web.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mes.core.cache.RediseCacheManager;
import com.mes.core.controller.BaseController;
import com.mes.core.pojos.ServiceResponse;
import com.mes.core.utils.InterfaceAuthenUtils;
import com.mes.core.utils.MD5Utils;
import com.mes.system.bean.SessionUser;
import com.mes.system.service.MainService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.web]    
  * 类名称:		[MainController]  
  * 类描述:		[后台登录及框架页面控制器]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月17日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月17日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@RestController
@RequestMapping("/main")
@Api(value = "MainController", description = "后台登录管理")
public class MainController extends BaseController {
	private static Pattern SECRET_PATTERN = Pattern.compile("\\s*|\t|\r|\n");

	@Autowired
	private MainService mainService;

	@Autowired
	RediseCacheManager rediseCacheManager;

	/**
	 * 系统用户登录
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 服务响应对象
	 */
	@ApiOperation(value = "系统用户登录", httpMethod = "GET", notes = "系统用户登录")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "query"), @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "服务端错误", response = Void.class) })
	@RequestMapping("/login")
	public ServiceResponse<SessionUser> login(@RequestParam(value = "name") String name, @RequestParam(value = "pwd") String pwd) {
		ServiceResponse<SessionUser> resutl = mainService.login(name, pwd);
		SessionUser sessionUser = resutl.getData();
		long timestamp = Long.valueOf(System.currentTimeMillis());
		String accessToken = MD5Utils.sign(sessionUser.getName() + timestamp);
		// token过期时间
		long expiresIn = 10 * 24 * 3600 * 1000;
		// 当前用户的秘钥信息
		String secret = InterfaceAuthenUtils.init();
		Matcher m = SECRET_PATTERN.matcher(secret);
		secret = m.replaceAll("");
		sessionUser.setAccessToken(accessToken);
		sessionUser.setExpiresIn(expiresIn);
		sessionUser.setSecret(secret);
		resutl.setData(sessionUser);
		rediseCacheManager.setObject(accessToken, sessionUser, expiresIn);
		return resutl;
	}
}
