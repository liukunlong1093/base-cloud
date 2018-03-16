package com.mes.common.aspect;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.mes.core.utils.StringUtils;

/**
 * Web层日志切面
 */
@Aspect
@Order(5)
@Component
public class AutoPageAspect {

	@Pointcut("execution(public * com.mes.*.manager.*.get*List(..))")
	public void autoPage() {
	}

	@SuppressWarnings("unchecked")
	@Around("autoPage()")
	public Object process(ProceedingJoinPoint point) throws Throwable {
		System.out.println("@Around：执行目标方法之前...");
		// 访问目标方法的参数：
		Object[] args = point.getArgs();
		Map<String, Object> condition = (Map<String, Object>) args[0];
		// 处理排序(把上下文的的排序字段名转化为数据库字段名称)
		Object sortField = condition.get("sortField");
		Object sortOrder = condition.get("sortOrder");
		if (StringUtils.hasText(sortField) && StringUtils.hasText(sortOrder)) {
			condition.put("sortField", StringUtils.underscoreName(String.valueOf(sortField)));
			args[0] = condition;
		}
		// 用改变后的参数执行目标方法
		Object returnValue = point.proceed(args);
		return returnValue;
	}

	@SuppressWarnings("unchecked")
	@Before("autoPage()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		Map<String, Object> condition = (Map<String, Object>) args[0];
		if (condition != null) {
			// 当前页
			Object pageNum = condition.get("pageNum");
			// 每页的数量
			Object pageSize = condition.get("pageSize");
			if (pageNum != null && pageSize != null) {
				PageHelper.startPage(Integer.parseInt(String.valueOf(pageNum)), Integer.parseInt(String.valueOf(pageSize)));
			}

		}
	}
}
