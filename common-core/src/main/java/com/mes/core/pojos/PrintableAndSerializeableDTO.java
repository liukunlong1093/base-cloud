package com.mes.core.pojos;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * 覆盖toString默认打印及序列化DTO
 * @author Administrator
 *
 */
public class PrintableAndSerializeableDTO implements Serializable{

	private static final long serialVersionUID = 1260343681044206085L;
	public String toString() {
		try {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		} catch (Throwable e) {
			return getClass().getName();
		}
	}
}
