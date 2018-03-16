package test.com.mes.product;

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
  * 包:	        [com.mes.product.web]    
  * 类名称:		[UnitController]  
  * 类描述:		[包装单位控制器测试类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月03日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月03日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@WebAppConfiguration
@AutoConfigureMockMvc
public class UnitControllerTest extends BaseTester {
	private static final Logger logger = LoggerFactory.getLogger(UnitControllerTest.class);
	@Resource
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getUnitById() throws Exception {
		RequestBuilder request = get("/product/getUnitById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getUnitById() process test with result:{}", result);
	}

	@Test
	public void getUnitList() throws Exception {
		RequestBuilder request = get("/product/getUnitList").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getUnitList() process test with result:{}", result);
	}

	@Test
	public void saveUnit() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", "1");
		jsonObject.put("value", "1");
		jsonObject.put("sort", "1");
		jsonObject.put("isDel", "1");
		jsonObject.put("createTime", "2016-11-07 05:20:54");
		jsonObject.put("createBy", "1");
		jsonObject.put("createName", "1");
		jsonObject.put("updateTime", "2016-11-07 05:20:54");
		jsonObject.put("updateBy", "1");
		jsonObject.put("updateName", "1");
		RequestBuilder request = post("/product/saveUnit").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("saveUnit() process test with result:{}", result);
	}

	@Test
	public void updateUnit() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
		jsonObject.put("code", "1");
		jsonObject.put("value", "1");
		jsonObject.put("sort", "1");
		jsonObject.put("isDel", "1");
		jsonObject.put("createTime", "2016-11-07 05:20:54");
		jsonObject.put("createBy", "1");
		jsonObject.put("createName", "1");
		jsonObject.put("updateTime", "2016-11-07 05:20:54");
		jsonObject.put("updateBy", "1");
		jsonObject.put("updateName", "1");
		RequestBuilder request = post("/product/updateUnit").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("updateUnit() process test with result:{}", result);
	}

	@Test
	public void deleteUnitById() throws Exception {
		RequestBuilder request = get("/product/deleteUnitById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("deleteUnitById() process test with result:{}", result);
	}

	@Test
	public void batchSaveUnit() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("code", "1");
		jsonObject1.put("value", "1");
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
		jsonObject2.put("value", "1");
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
		RequestBuilder request = post("/product/batchSaveUnit").contentType(MediaType.APPLICATION_JSON).content(jsonArray.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("batchSaveUnit() process test with result:{}", result);
	}
}
