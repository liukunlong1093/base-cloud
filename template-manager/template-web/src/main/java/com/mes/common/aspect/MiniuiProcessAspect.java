package com.mes.common.aspect;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mes.core.utils.StringUtils;

/**
 * miniui分页处理层日志切面
 */
@Aspect
@Order(5)
@Component
public class MiniuiProcessAspect {
	@Pointcut("execution(public * com.mes.*.web.controller.*.get*List(..))")
	public void miniuiProcess() {
	}

	@SuppressWarnings("unchecked")
	@Around("miniuiProcess()")
	public Object process(ProceedingJoinPoint point) throws Throwable {
		// 访问目标方法的参数：
		Object[] args = point.getArgs();
		if (args != null && args.length > 0) {
			Object obj = args[0];
			if (obj instanceof Map) {
				Map<String, Object> condition = (Map<String, Object>) args[0];
				// 是否分页
				String isPage = StringUtils.trim(condition.get("isPage"), "1");
				if ("1".equals(isPage)) {
					// 当前页
					Object pageIndex = condition.get("pageIndex");
					// 每页的数量
					Object pageSize = condition.get("pageSize");
					if (StringUtils.hasText(pageIndex) && StringUtils.hasText(pageSize)) {
						condition.remove("pageIndex");
						condition.put("pageNum", Integer.parseInt(String.valueOf(pageIndex)) + 1);
						args[0] = condition;
					}
					// 用改变后的参数执行目标方法
				} else {
					// 否则删除分页参数
					condition.remove("pageIndex");
					condition.remove("pageSize");
				}
			}
		}
		Object returnValue = point.proceed(args);
		return returnValue;
	}
}
