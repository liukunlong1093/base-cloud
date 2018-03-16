package test.com.mes.common;

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
  * 项目名称:	[common-app]
  * 包:	        [com.mes.common.web]    
  * 类名称:		[DataDictionaryController]  
  * 类描述:		[数据字典控制器测试类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@WebAppConfiguration
@AutoConfigureMockMvc
public class DataDictionaryControllerTest extends BaseTester {
	private static final Logger logger = LoggerFactory.getLogger(DataDictionaryControllerTest.class);
	@Resource
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getDataDictionaryById() throws Exception {
		RequestBuilder request = get("/dataDictionary/getDataDictionaryById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getDataDictionaryById() process test with result:{}", result);
	}

	@Test
	public void getDataDictionaryList() throws Exception {
		RequestBuilder request = get("/dataDictionary/getDataDictionaryList").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getDataDictionaryList() process test with result:{}", result);
	}

	@Test
	public void saveDataDictionary() throws Exception {
		JSONObject jsonObject = new JSONObject();
														jsonObject.put("id","1");
						    														jsonObject.put("code","1");
						    														jsonObject.put("name","1");
						    														jsonObject.put("parentCode","1");
						    														jsonObject.put("isEdit","1");
						    														jsonObject.put("isValid","1");
						    														jsonObject.put("isDefault","1");
						    														jsonObject.put("comment","1");
						    														jsonObject.put("sort","1");
						    														jsonObject.put("createBy","1");
						    														jsonObject.put("createName","1");
						    														jsonObject.put("createTime","2016-11-07 05:20:54");
						    														jsonObject.put("updateBy","1");
						    														jsonObject.put("updateName","1");
						    														jsonObject.put("updateTime","2016-11-07 05:20:54");
						    														jsonObject.put("isDel","1");
						    				RequestBuilder request = post("/dataDictionary/saveDataDictionary").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("saveDataDictionary() process test with result:{}", result);
	}

	@Test
	public void updateDataDictionary() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
														jsonObject.put("id","2");
						    														jsonObject.put("code","2");
						    														jsonObject.put("name","2");
						    														jsonObject.put("parentCode","2");
						    														jsonObject.put("isEdit","2");
						    														jsonObject.put("isValid","2");
						    														jsonObject.put("isDefault","2");
						    														jsonObject.put("comment","2");
						    														jsonObject.put("sort","2");
						    														jsonObject.put("createBy","2");
						    														jsonObject.put("createName","2");
						    														jsonObject.put("createTime","2016-11-08 05:20:54");
						    														jsonObject.put("updateBy","2");
						    														jsonObject.put("updateName","2");
						    														jsonObject.put("updateTime","2016-11-08 05:20:54");
						    														jsonObject.put("isDel","2");
						    				RequestBuilder request = post("/dataDictionary/updateDataDictionary").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("updateDataDictionary() process test with result:{}", result);
	}

	@Test
	public void deleteDataDictionaryById() throws Exception {
		RequestBuilder request = get("/dataDictionary/deleteDataDictionaryById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("deleteDataDictionaryById() process test with result:{}", result);
	}

	@Test
	public void batchSaveDataDictionary() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
														jsonObject1.put("id","1");
						    														jsonObject1.put("code","1");
						    														jsonObject1.put("name","1");
						    														jsonObject1.put("parentCode","1");
						    														jsonObject1.put("isEdit","1");
						    														jsonObject1.put("isValid","1");
						    														jsonObject1.put("isDefault","1");
						    														jsonObject1.put("comment","1");
						    														jsonObject1.put("sort","1");
						    														jsonObject1.put("createBy","1");
						    														jsonObject1.put("createName","1");
						    														jsonObject1.put("createTime","2016-11-07 05:20:54");
						    														jsonObject1.put("updateBy","1");
						    														jsonObject1.put("updateName","1");
						    														jsonObject1.put("updateTime","2016-11-07 05:20:54");
						    														jsonObject1.put("isDel","1");
						    				JSONObject jsonObject2 = new JSONObject();
														jsonObject2.put("id","1");
						    														jsonObject2.put("code","1");
						    														jsonObject2.put("name","1");
						    														jsonObject2.put("parentCode","1");
						    														jsonObject2.put("isEdit","1");
						    														jsonObject2.put("isValid","1");
						    														jsonObject2.put("isDefault","1");
						    														jsonObject2.put("comment","1");
						    														jsonObject2.put("sort","1");
						    														jsonObject2.put("createBy","1");
						    														jsonObject2.put("createName","1");
						    														jsonObject2.put("createTime","2016-11-07 05:20:54");
						    														jsonObject2.put("updateBy","1");
						    														jsonObject2.put("updateName","1");
						    														jsonObject2.put("updateTime","2016-11-07 05:20:54");
						    														jsonObject2.put("isDel","1");
						    				jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		RequestBuilder request = post("/dataDictionary/batchSaveDataDictionary").contentType(MediaType.APPLICATION_JSON).content(jsonArray.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("batchSaveDataDictionary() process test with result:{}", result);
	}
}
