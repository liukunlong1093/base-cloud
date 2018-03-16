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
  * 类名称:		[PurviewController]  
  * 类描述:		[权限控制器测试类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月21日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月21日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@WebAppConfiguration
@AutoConfigureMockMvc
public class PurviewControllerTest extends BaseTester {
	private static final Logger logger = LoggerFactory.getLogger(PurviewControllerTest.class);
	@Resource
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getMenuPurviewById() throws Exception {
		RequestBuilder request = get("/purview/getMenuPurviewById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getMenuPurviewById() process test with result:{}", result);
	}

	@Test
	public void getMenuPurviewList() throws Exception {
		RequestBuilder request = get("/purview/getMenuPurviewList").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getMenuPurviewList() process test with result:{}", result);
	}

	@Test
	public void saveMenuPurview() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("title", "1");
		jsonObject.put("secId", "1");
		jsonObject.put("secName", "1");
		jsonObject.put("menuId", "1");
		jsonObject.put("sort", "1");
		jsonObject.put("isDel", "1");
		jsonObject.put("createTime", "2016-11-07 05:20:54");
		jsonObject.put("createBy", "1");
		jsonObject.put("createName", "1");
		jsonObject.put("updateTime", "2016-11-07 05:20:54");
		jsonObject.put("updateBy", "1");
		jsonObject.put("updateName", "1");
		RequestBuilder request = post("/purview/saveMenuPurview").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("saveMenuPurview() process test with result:{}", result);
	}

	@Test
	public void updateMenuPurview() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
		jsonObject.put("title", "2");
		jsonObject.put("secId", "2");
		jsonObject.put("secName", "2");
		jsonObject.put("menuId", "2");
		jsonObject.put("sort", "2");
		jsonObject.put("isDel", "2");
		jsonObject.put("createTime", "2016-11-08 05:20:54");
		jsonObject.put("createBy", "2");
		jsonObject.put("createName", "2");
		jsonObject.put("updateTime", "2016-11-08 05:20:54");
		jsonObject.put("updateBy", "2");
		jsonObject.put("updateName", "2");
		RequestBuilder request = post("/purview/updateMenuPurview").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("updateMenuPurview() process test with result:{}", result);
	}

	@Test
	public void deleteMenuPurviewById() throws Exception {
		RequestBuilder request = get("/purview/deleteMenuPurviewById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("deleteMenuPurviewById() process test with result:{}", result);
	}

	@Test
	public void batchSaveMenuPurview() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("title", "1");
		jsonObject1.put("secId", "1");
		jsonObject1.put("secName", "1");
		jsonObject1.put("menuId", "1");
		jsonObject1.put("sort", "1");
		jsonObject1.put("isDel", "1");
		jsonObject1.put("createTime", "2016-11-07 05:20:54");
		jsonObject1.put("createBy", "1");
		jsonObject1.put("createName", "1");
		jsonObject1.put("updateTime", "2016-11-07 05:20:54");
		jsonObject1.put("updateBy", "1");
		jsonObject1.put("updateName", "1");
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("title", "1");
		jsonObject2.put("secId", "1");
		jsonObject2.put("secName", "1");
		jsonObject2.put("menuId", "1");
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
		RequestBuilder request = post("/purview/batchSaveMenuPurview").contentType(MediaType.APPLICATION_JSON).content(jsonArray.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("batchSaveMenuPurview() process test with result:{}", result);
	}

	@Test
	public void getFunctionPurviewById() throws Exception {
		RequestBuilder request = get("/purview/getFunctionPurviewById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getFunctionPurviewById() process test with result:{}", result);
	}

	@Test
	public void getFunctionPurviewList() throws Exception {
		RequestBuilder request = get("/purview/getFunctionPurviewList").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getFunctionPurviewList() process test with result:{}", result);
	}

	@Test
	public void saveFunctionPurview() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("title", "1");
		jsonObject.put("secId", "1");
		jsonObject.put("secName", "1");
		jsonObject.put("menuId", "1");
		jsonObject.put("functionId", "1");
		jsonObject.put("functionCode", "1");
		jsonObject.put("sort", "1");
		jsonObject.put("isDel", "1");
		jsonObject.put("createTime", "2016-11-07 05:20:54");
		jsonObject.put("createBy", "1");
		jsonObject.put("createName", "1");
		jsonObject.put("updateTime", "2016-11-07 05:20:54");
		jsonObject.put("updateBy", "1");
		jsonObject.put("updateName", "1");
		RequestBuilder request = post("/purview/saveFunctionPurview").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("saveFunctionPurview() process test with result:{}", result);
	}

	@Test
	public void updateFunctionPurview() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
		jsonObject.put("title", "2");
		jsonObject.put("secId", "2");
		jsonObject.put("secName", "2");
		jsonObject.put("menuId", "2");
		jsonObject.put("functionId", "2");
		jsonObject.put("functionCode", "2");
		jsonObject.put("sort", "2");
		jsonObject.put("isDel", "2");
		jsonObject.put("createTime", "2016-11-08 05:20:54");
		jsonObject.put("createBy", "2");
		jsonObject.put("createName", "2");
		jsonObject.put("updateTime", "2016-11-08 05:20:54");
		jsonObject.put("updateBy", "2");
		jsonObject.put("updateName", "2");
		RequestBuilder request = post("/purview/updateFunctionPurview").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("updateFunctionPurview() process test with result:{}", result);
	}

	@Test
	public void deleteFunctionPurviewById() throws Exception {
		RequestBuilder request = get("/purview/deleteFunctionPurviewById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("deleteFunctionPurviewById() process test with result:{}", result);
	}

	@Test
	public void batchSaveFunctionPurview() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("title", "1");
		jsonObject1.put("secId", "1");
		jsonObject1.put("secName", "1");
		jsonObject1.put("menuId", "1");
		jsonObject1.put("functionId", "1");
		jsonObject1.put("functionCode", "1");
		jsonObject1.put("sort", "1");
		jsonObject1.put("isDel", "1");
		jsonObject1.put("createTime", "2016-11-07 05:20:54");
		jsonObject1.put("createBy", "1");
		jsonObject1.put("createName", "1");
		jsonObject1.put("updateTime", "2016-11-07 05:20:54");
		jsonObject1.put("updateBy", "1");
		jsonObject1.put("updateName", "1");
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("title", "1");
		jsonObject2.put("secId", "1");
		jsonObject2.put("secName", "1");
		jsonObject2.put("menuId", "1");
		jsonObject2.put("functionId", "1");
		jsonObject2.put("functionCode", "1");
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
		RequestBuilder request = post("/purview/batchSaveFunctionPurview").contentType(MediaType.APPLICATION_JSON).content(jsonArray.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("batchSaveFunctionPurview() process test with result:{}", result);
	}

	@Test
	public void getDataPurviewById() throws Exception {
		RequestBuilder request = get("/purview/getDataPurviewById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getDataPurviewById() process test with result:{}", result);
	}

	@Test
	public void getDataPurviewList() throws Exception {
		RequestBuilder request = get("/purview/getDataPurviewList").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getDataPurviewList() process test with result:{}", result);
	}

	@Test
	public void saveDataPurview() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("title", "1");
		jsonObject.put("secId", "1");
		jsonObject.put("secName", "1");
		jsonObject.put("menuId", "1");
		jsonObject.put("functionId", "1");
		jsonObject.put("functionCode", "1");
		jsonObject.put("rangeSecId", "1");
		jsonObject.put("rangeSecName", "1");
		jsonObject.put("sort", "1");
		jsonObject.put("isDel", "1");
		jsonObject.put("createTime", "2016-11-07 05:20:54");
		jsonObject.put("createBy", "1");
		jsonObject.put("createName", "1");
		jsonObject.put("updateTime", "2016-11-07 05:20:54");
		jsonObject.put("updateBy", "1");
		jsonObject.put("updateName", "1");
		RequestBuilder request = post("/purview/saveDataPurview").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("saveDataPurview() process test with result:{}", result);
	}

	@Test
	public void updateDataPurview() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
		jsonObject.put("title", "2");
		jsonObject.put("secId", "2");
		jsonObject.put("secName", "2");
		jsonObject.put("menuId", "2");
		jsonObject.put("functionId", "2");
		jsonObject.put("functionCode", "2");
		jsonObject.put("rangeSecId", "2");
		jsonObject.put("rangeSecName", "2");
		jsonObject.put("sort", "2");
		jsonObject.put("isDel", "2");
		jsonObject.put("createTime", "2016-11-08 05:20:54");
		jsonObject.put("createBy", "2");
		jsonObject.put("createName", "2");
		jsonObject.put("updateTime", "2016-11-08 05:20:54");
		jsonObject.put("updateBy", "2");
		jsonObject.put("updateName", "2");
		RequestBuilder request = post("/purview/updateDataPurview").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("updateDataPurview() process test with result:{}", result);
	}

	@Test
	public void deleteDataPurviewById() throws Exception {
		RequestBuilder request = get("/purview/deleteDataPurviewById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("deleteDataPurviewById() process test with result:{}", result);
	}

	@Test
	public void batchSaveDataPurview() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("title", "1");
		jsonObject1.put("secId", "1");
		jsonObject1.put("secName", "1");
		jsonObject1.put("menuId", "1");
		jsonObject1.put("functionId", "1");
		jsonObject1.put("functionCode", "1");
		jsonObject1.put("rangeSecId", "1");
		jsonObject1.put("rangeSecName", "1");
		jsonObject1.put("sort", "1");
		jsonObject1.put("isDel", "1");
		jsonObject1.put("createTime", "2016-11-07 05:20:54");
		jsonObject1.put("createBy", "1");
		jsonObject1.put("createName", "1");
		jsonObject1.put("updateTime", "2016-11-07 05:20:54");
		jsonObject1.put("updateBy", "1");
		jsonObject1.put("updateName", "1");
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("title", "1");
		jsonObject2.put("secId", "1");
		jsonObject2.put("secName", "1");
		jsonObject2.put("menuId", "1");
		jsonObject2.put("functionId", "1");
		jsonObject2.put("functionCode", "1");
		jsonObject2.put("rangeSecId", "1");
		jsonObject2.put("rangeSecName", "1");
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
		RequestBuilder request = post("/purview/batchSaveDataPurview").contentType(MediaType.APPLICATION_JSON).content(jsonArray.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("batchSaveDataPurview() process test with result:{}", result);
	}
}
