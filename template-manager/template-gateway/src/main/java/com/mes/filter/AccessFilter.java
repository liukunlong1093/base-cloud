package com.mes.filter;

import com.alibaba.fastjson.JSON;
import com.mes.core.exception.SystemException;
import com.mes.core.exception.enums.SystemExceptionEnums;
import com.mes.core.pojos.ServiceResponse;
import com.mes.core.utils.GetRequestJsonUtils;
import com.mes.core.utils.InterfaceAuthenUtils;
import com.mes.core.utils.StringUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class AccessFilter extends ZuulFilter {
	private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	/**
	 * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型
	 * pre：可以在请求被路由之前调用
	 * routing：在路由请求时候被调用
	 * post：在routing和error过滤器之后被调用
	 * error：处理请求时发生错误时被调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 通过int值来定义过滤器的执行顺序数值越小优先级越高。
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 通过此方法来指定过滤器的有效范围
	 * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器的具体逻辑。需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，
	 * 不对其进行路由，然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，当然我们也可
	 * 以进一步优化我们的返回，比如，通过ctx.setResponseBody(body)对返回body内容进行编辑等。
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		//token
		String token = request.getHeader("token");

		//签名
		String sign = request.getHeader("sign");

		//时间
		String timestamp = request.getHeader("timestamp");

		//请求地址
		// String url = request.getRequestURI();

		String visitUrl = request.getRequestURL().toString();
		String sitePart = "http://" + request.getServerName();
		String port = request.getServerPort() + "";
		String projectName = request.getContextPath();
		String weburl = sitePart + ":" + port + projectName + "/";
		String actonUrl = visitUrl.replace(weburl, "");
		// 当前调用的方法
		String action = actonUrl;
		// 待实现逻辑
		Map<String, String> noFilterActionMap = new HashMap<String, String>();
		// 如果当前是非过滤的的Action方法名则不作授权认证
		if (noFilterActionMap.containsKey(action)) {
			return null;
		} else {
			try {
				// 必填参数校验
				if (!StringUtils.hasText(token) || !StringUtils.hasText(sign) || !StringUtils.hasText(timestamp)) {
					throw new SystemException(SystemExceptionEnums.MISSING_REQUIRED_ARGUMENTS);
				}
				// token在缓存中的信息 todo;
				Map<Object, Object> tokenMap = new HashMap<>(100);
				tokenMap.put("secret", "VehiR3orHJa7agNmfHdI3UxKvFHMcQAsS+GYz3mQsicTpmyABiqD9mSB0GQyfiZat/2opfVtcjK7O7mRrUtW7g==");
				if (tokenMap == null || tokenMap.size() <= 0) {
					throw new SystemException(SystemExceptionEnums.TOKEN_EXPIRED);
				}

				// 用户秘钥
				String secret = StringUtils.trim(tokenMap.get("secret"));

				// 服务端参数校验
				long second = InterfaceAuthenUtils.differDateSecond(timestamp);

				if (!StringUtils.hasText(secret)) {
					throw new SystemException(SystemExceptionEnums.MISSING_SECRET);
				}
				if (!StringUtils.hasText(timestamp)) {
					throw new SystemException(SystemExceptionEnums.MISSING_TIMESTAMP);
				}
				if (second < -1800) {
					throw new SystemException(SystemExceptionEnums.URL_EXPIRED);
				}

				// 需要签名认证的字段
				Map<String, String> singParamsMap = new HashMap<String, String>();
				String data = GetRequestJsonUtils.getRequestJsonString(request);
				singParamsMap.put("action", action);
				if (StringUtils.hasText(data)) {
					// boolean flag = UrlEncoderUtils.hasUrlEncoded(data);
					// if (!flag) {// 如果没有data没有编码需要编码后进行签名认证
					// data = URLEncoder.encode(data, "UTF-8");
					// }
					singParamsMap.put("data", data);
				}
				singParamsMap.put("timestamp", timestamp);
				singParamsMap.put("token", token);
				if (InterfaceAuthenUtils.verifySing(singParamsMap, secret, sign)) {
					return null;
				} else {
					return null;
					//throw new SystemException(SystemExceptionEnums.SIGNATURE_FAIL);
				}

			} catch (Exception e) {
				if (e instanceof SystemException) {
					SystemException systemException = (SystemException) e;
					responseError(ctx, systemException.getExceptionEnums().getCode(), systemException.getExceptionEnums().getMessage());
				} else {
					logger.error("AccessFilter.run is error", e);
				}
			}

		}
		logger.info("access token ok.........");
		return null;
	}

	/**
	 * 输出错误验证信息
	 * @param ctx  上下文对象
	 * @param code 错误代码
	 * @param msg  错误信息
	 */
	private void responseError(RequestContext ctx, int code, String msg) {
		// 解决中文乱码
		ctx.getResponse().setContentType("application/json;charset=UTF-8");
		ctx.setSendZuulResponse(false);
		ctx.setResponseStatusCode(500);
		ctx.setResponseBody(JSON.toJSONString(ServiceResponse.handleFail(String.valueOf(code), msg)));

	}

}
