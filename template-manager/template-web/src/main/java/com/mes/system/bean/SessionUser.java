package com.mes.system.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.mes.core.cache.RedisCacheManager;
import com.mes.core.utils.StringUtils;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
  * 
  * 项目名称:  [base-app]
  * 包:        [com.ftd.system.dto]    
  * 类名称:    [SessionUser]  
  * 类描述:    [用户会话信息数据传输对象]
  * 创建人:    [liukl]   
  * 创建时间:  [2015-5-31 下午6:26:37]   
  * 修改人:    [liukl]   
  * 修改时间:  [2015-5-31 下午6:26:37]   
  * 修改备注:  [说明本次修改内容]  
  * 版本:      [v1.0]   
  *
 */
public class SessionUser {
	/** 用户标识*/
	private Long id;

	/** 用户名称*/
	private String name;

	/**  真实名称*/
	private String fullname;

	/** 单位标识*/
	private List<Long> OUs = new ArrayList<Long>();

	/** 部门标识*/
	private List<Long> CNs = new ArrayList<Long>();

	/** 岗位标识*/
	private List<Long> postIds = new ArrayList<Long>();

	/** 岗位类型标识*/
	private List<Long> postTypeIds = new ArrayList<Long>();

	/** 用户群组标识*/
	private List<Long> domainIds = new ArrayList<Long>();

	/** 额外的数据创建人ID集合*/
	private Map<Long, List<Long>> otherDataPvCreaterIdMap = new HashMap<Long, List<Long>>();

	/** 用户额外属性*/
	private HashMap<String, Object> userExpandMap = new HashMap<String, Object>();

	/** 认证令牌*/
	@ApiModelProperty(value = "认证令牌")
	private String accessToken;

	/** 过期时间(毫秒)*/
	@ApiModelProperty(value = "令牌失效时间")
	private Long expiresIn;

	/** 签名秘钥*/
	@ApiModelProperty(value = "签名秘钥")
	private String secret;

	@Autowired
	static RedisCacheManager rediseCacheManager;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<Long> getOUs() {
		return OUs;
	}

	public void setOUs(List<Long> oUs) {
		OUs = oUs;
	}

	public List<Long> getCNs() {
		return CNs;
	}

	public void setCNs(List<Long> cNs) {
		CNs = cNs;
	}

	public List<Long> getPostIds() {
		return postIds;
	}

	public void setPostIds(List<Long> postIds) {
		this.postIds = postIds;
	}

	public List<Long> getPostTypeIds() {
		return postTypeIds;
	}

	public void setPostTypeIds(List<Long> postTypeIds) {
		this.postTypeIds = postTypeIds;
	}

	public List<Long> getDomainIds() {
		return domainIds;
	}

	public void setDomainIds(List<Long> domainIds) {
		this.domainIds = domainIds;
	}

	public Map<Long, List<Long>> getOtherDataPvCreaterIdMap() {
		return otherDataPvCreaterIdMap;
	}

	public void setOtherDataPvCreaterIdMap(Map<Long, List<Long>> otherDataPvCreaterIdMap) {
		this.otherDataPvCreaterIdMap = otherDataPvCreaterIdMap;
	}

	public HashMap<String, Object> getUserExpandMap() {
		return userExpandMap;
	}

	public void setUserExpandMap(HashMap<String, Object> userExpandMap) {
		this.userExpandMap = userExpandMap;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * 获取用户信息
	 * @param request 请求对象
	 * @return 用户信息
	 */
	public static SessionUser getSessionUser(HttpServletRequest request) {
		String token = StringUtils.trim(request.getHeader("token"));
		SessionUser su = (SessionUser) rediseCacheManager.getObject(token);
		return su;
	}
}
