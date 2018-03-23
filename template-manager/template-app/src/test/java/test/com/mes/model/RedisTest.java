package test.com.mes.model;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mes.core.cache.RedisCacheManager;

import test.BaseTester;
/**
  * 项目名称:	[info-app]
  * 包:	        [test.com.mes.model]    
  * 类名称:		[RedisTest]  
  * 类描述:		[Redis测试]
  * 创建人:		[liukl]   
  * 创建时间:	[2017年10月18日 上午10:47:46]   
  * 修改人:		[liukl]   
  * 修改时间:	[2017年10月18日 上午10:47:46]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
public class RedisTest extends BaseTester {
	@Autowired
    RedisCacheManager rediseCacheManager;
	@Test
	public void test() throws Exception {
		// 保存字符串
		rediseCacheManager.set("aaa", "111");
		String aaa = rediseCacheManager.get("aaa");
		System.out.println(aaa);
		rediseCacheManager.set("888888", "123123");
		String rs=rediseCacheManager.get("888888");
		System.out.println("333333333333333333333333333333333333"+rs);
	}
}
