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
  * 类名称:		[FunctionController]  
  * 类描述:		[系统功能控制器测试类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@WebAppConfiguration
@AutoConfigureMockMvc
public class FunctionControllerTest extends BaseTester {
	private static final Logger logger = LoggerFactory.getLogger(FunctionControllerTest.class);
	@Resource
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getFunctionById() throws Exception {
		RequestBuilder request = get("/function/getFunctionById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getFunctionById() process test with result:{}", result);
	}

	@Test
	public void getFunctionList() throws Exception {
		RequestBuilder request = get("/function/getFunctionList").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getFunctionList() process test with result:{}", result);
	}

	@Test
	public void saveFunction() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", "1");
		jsonObject.put("menuId", "1");
		jsonObject.put("operationTypeId", "1");
		jsonObject.put("name", "1");
		jsonObject.put("comment", "1");
		jsonObject.put("sort", "1");
		jsonObject.put("isDel", "1");
		jsonObject.put("createTime", "2016-11-07 05:20:54");
		jsonObject.put("createBy", "1");
		jsonObject.put("createName", "1");
		jsonObject.put("updateTime", "2016-11-07 05:20:54");
		jsonObject.put("updateBy", "1");
		jsonObject.put("updateName", "1");
		RequestBuilder request = post("/function/saveFunction").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("saveFunction() process test with result:{}", result);
	}

	@Test
	public void updateFunction() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
		jsonObject.put("code", "2");
		jsonObject.put("menuId", "2");
		jsonObject.put("operationTypeId", "2");
		jsonObject.put("name", "2");
		jsonObject.put("comment", "2");
		jsonObject.put("sort", "2");
		jsonObject.put("isDel", "2");
		jsonObject.put("createTime", "2016-11-08 05:20:54");
		jsonObject.put("createBy", "2");
		jsonObject.put("createName", "2");
		jsonObject.put("updateTime", "2016-11-08 05:20:54");
		jsonObject.put("updateBy", "2");
		jsonObject.put("updateName", "2");
		RequestBuilder request = post("/function/updateFunction").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("updateFunction() process test with result:{}", result);
	}

	@Test
	public void deleteFunctionById() throws Exception {
		RequestBuilder request = get("/function/deleteFunctionById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("deleteFunctionById() process test with result:{}", result);
	}

	@Test
	public void batchSaveFunction() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("code", "1");
		jsonObject1.put("menuId", "1");
		jsonObject1.put("operationTypeId", "1");
		jsonObject1.put("name", "1");
		jsonObject1.put("comment", "1");
		jsonObject1.put("sort", "1");
		jsonObject1.put("isDel", "1");
		jsonObject1.put("createTime", "2016-11-07 05:20:54");
		jsonObject1.put("createBy", "1");
		jsonObject1.put("createName", "1");
		jsonObject1.put("updateTime", "2016-11-07 05:20:54");
		jsonObject1.put("updateBy", "1");
		jsonObject1.put("updateName", "1");
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("code", "1");
		jsonObject2.put("menuId", "1");
		jsonObject2.put("operationTypeId", "1");
		jsonObject2.put("name", "1");
		jsonObject2.put("comment", "1");
		jsonObject2.put("sort", "1");
		jsonObject2.put("isDel", "1");
		jsonObject2.put("createTime", "2016-11-07 05:20:54");
		jsonObject2.put("createBy", "1");
		jsonObject2.put("createName", "1");
		jsonObject2.put("updateTime", "2016-11-07 05:20:54");
		jsonObject2.put("updateBy", "1");
		jsonObject2.put("updateName", "1");
		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		RequestBuilder request = post("/function/batchSaveFunction").contentType(MediaType.APPLICATION_JSON).content(jsonArray.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("batchSaveFunction() process test with result:{}", result);
	}

	@Test
	public void getFunctionApiRelById() throws Exception {
		RequestBuilder request = get("/function/getFunctionApiRelById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getFunctionApiRelById() process test with result:{}", result);
	}

	@Test
	public void getFunctionApiRelList() throws Exception {
		RequestBuilder request = get("/function/getFunctionApiRelList").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getFunctionApiRelList() process test with result:{}", result);
	}

	@Test
	public void saveFunctionApiRel() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("functionId", "1");
		jsonObject.put("apiId", "1");
		jsonObject.put("sort", "1");
		jsonObject.put("isDel", "1");
		jsonObject.put("createTime", "2016-11-07 05:20:54");
		jsonObject.put("createBy", "1");
		jsonObject.put("createName", "1");
		jsonObject.put("updateTime", "2016-11-07 05:20:54");
		jsonObject.put("updateBy", "1");
		jsonObject.put("updateName", "1");
		RequestBuilder request = post("/function/saveFunctionApiRel").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("saveFunctionApiRel() process test with result:{}", result);
	}

	@Test
	public void updateFunctionApiRel() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
		jsonObject.put("functionId", "2");
		jsonObject.put("apiId", "2");
		jsonObject.put("sort", "2");
		jsonObject.put("isDel", "2");
		jsonObject.put("createTime", "2016-11-08 05:20:54");
		jsonObject.put("createBy", "2");
		jsonObject.put("createName", "2");
		jsonObject.put("updateTime", "2016-11-08 05:20:54");
		jsonObject.put("updateBy", "2");
		jsonObject.put("updateName", "2");
		RequestBuilder request = post("/function/updateFunctionApiRel").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("updateFunctionApiRel() process test with result:{}", result);
	}

	@Test
	public void deleteFunctionApiRelById() throws Exception {
		RequestBuilder request = get("/function/deleteFunctionApiRelById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("deleteFunctionApiRelById() process test with result:{}", result);
	}

	@Test
	public void batchSaveFunctionApiRel() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("functionId", "1");
		jsonObject1.put("apiId", "1");
		jsonObject1.put("sort", "1");
		jsonObject1.put("isDel", "1");
		jsonObject1.put("createTime", "2016-11-07 05:20:54");
		jsonObject1.put("createBy", "1");
		jsonObject1.put("createName", "1");
		jsonObject1.put("updateTime", "2016-11-07 05:20:54");
		jsonObject1.put("updateBy", "1");
		jsonObject1.put("updateName", "1");
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("functionId", "1");
		jsonObject2.put("apiId", "1");
		jsonObject2.put("sort", "1");
		jsonObject2.put("isDel", "1");
		jsonObject2.put("createTime", "2016-11-07 05:20:54");
		jsonObject2.put("createBy", "1");
		jsonObject2.put("createName", "1");
		jsonObject2.put("updateTime", "2016-11-07 05:20:54");
		jsonObject2.put("updateBy", "1");
		jsonObject2.put("updateName", "1");
		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		RequestBuilder request = post("/function/batchSaveFunctionApiRel").contentType(MediaType.APPLICATION_JSON).content(jsonArray.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("batchSaveFunctionApiRel() process test with result:{}", result);
	}
}
