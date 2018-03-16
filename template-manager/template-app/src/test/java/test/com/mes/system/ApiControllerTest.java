package test.com.mes.system;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import test.BaseTester;

/**
  * 项目名称:	[info-app]
  * 包:	        [com.mes.system.web]    
  * 类名称:		[ApiController]  
  * 类描述:		[应用程序接口控制器测试类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月28日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月28日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@WebAppConfiguration
@AutoConfigureMockMvc
public class ApiControllerTest extends BaseTester {
	private static final Logger logger = LoggerFactory.getLogger(ApiControllerTest.class);
	@Resource
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getApiById() throws Exception {
		RequestBuilder request = get("/api/getApiById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getApiById() process test with result:{}", result);
	}

	@Test
	public void getApiList() throws Exception {
		RequestBuilder request = get("/api/getApiList").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getApiList() process test with result:{}", result);
	}

	@Test
	public void saveApi() throws Exception {
		JSONObject jsonObject = new JSONObject();
																			jsonObject.put("name","1");
						    														jsonObject.put("projectId","1");
						    														jsonObject.put("projectName","1");
						    														jsonObject.put("moduleId","1");
						    														jsonObject.put("moduleName","1");
						    														jsonObject.put("url","1");
						    														jsonObject.put("comment","1");
						    														jsonObject.put("sort","1");
						    														jsonObject.put("isDel","1");
						    														jsonObject.put("createTime","2016-11-07 05:20:54");
						    														jsonObject.put("createBy","1");
						    														jsonObject.put("createName","1");
						    														jsonObject.put("updateTime","2016-11-07 05:20:54");
						    														jsonObject.put("updateBy","1");
						    														jsonObject.put("updateName","1");
						    				RequestBuilder request = post("/api/saveApi").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("saveApi() process test with result:{}", result);
	}

	@Test
	public void updateApi() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
																			jsonObject.put("name","2");
						    														jsonObject.put("projectId","2");
						    														jsonObject.put("projectName","2");
						    														jsonObject.put("moduleId","2");
						    														jsonObject.put("moduleName","2");
						    														jsonObject.put("url","2");
						    														jsonObject.put("comment","2");
						    														jsonObject.put("sort","2");
						    														jsonObject.put("isDel","2");
						    														jsonObject.put("createTime","2016-11-08 05:20:54");
						    														jsonObject.put("createBy","2");
						    														jsonObject.put("createName","2");
						    														jsonObject.put("updateTime","2016-11-08 05:20:54");
						    														jsonObject.put("updateBy","2");
						    														jsonObject.put("updateName","2");
						    				RequestBuilder request = post("/api/updateApi").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("updateApi() process test with result:{}", result);
	}

	@Test
	public void deleteApiById() throws Exception {
		RequestBuilder request = get("/api/deleteApiById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("deleteApiById() process test with result:{}", result);
	}

	@Test
	public void batchSaveApi() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
																			jsonObject1.put("name","1");
						    														jsonObject1.put("projectId","1");
						    														jsonObject1.put("projectName","1");
						    														jsonObject1.put("moduleId","1");
						    														jsonObject1.put("moduleName","1");
						    														jsonObject1.put("url","1");
						    														jsonObject1.put("comment","1");
						    														jsonObject1.put("sort","1");
						    														jsonObject1.put("isDel","1");
						    														jsonObject1.put("createTime","2016-11-07 05:20:54");
						    														jsonObject1.put("createBy","1");
						    														jsonObject1.put("createName","1");
						    														jsonObject1.put("updateTime","2016-11-07 05:20:54");
						    														jsonObject1.put("updateBy","1");
						    														jsonObject1.put("updateName","1");
						    				JSONObject jsonObject2 = new JSONObject();
																			jsonObject2.put("name","1");
						    														jsonObject2.put("projectId","1");
						    														jsonObject2.put("projectName","1");
						    														jsonObject2.put("moduleId","1");
						    														jsonObject2.put("moduleName","1");
						    														jsonObject2.put("url","1");
						    														jsonObject2.put("comment","1");
						    														jsonObject2.put("sort","1");
						    														jsonObject2.put("isDel","1");
						    														jsonObject2.put("createTime","2016-11-07 05:20:54");
						    														jsonObject2.put("createBy","1");
						    														jsonObject2.put("createName","1");
						    														jsonObject2.put("updateTime","2016-11-07 05:20:54");
						    														jsonObject2.put("updateBy","1");
						    														jsonObject2.put("updateName","1");
						    				jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		RequestBuilder request = post("/api/batchSaveApi").contentType(MediaType.APPLICATION_JSON).content(jsonArray.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("batchSaveApi() process test with result:{}", result);
	}
}
