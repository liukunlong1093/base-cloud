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
  * 类名称:		[MenuController]  
  * 类描述:		[菜单控制器测试类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月17日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月17日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@WebAppConfiguration
@AutoConfigureMockMvc
public class MenuControllerTest extends BaseTester {
	private static final Logger logger = LoggerFactory.getLogger(MenuControllerTest.class);
	@Resource
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getMenuById() throws Exception {
		RequestBuilder request = get("/menu/getMenuById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getMenuById() process test with result:{}", result);
	}

	@Test
	public void getMenuList() throws Exception {
		RequestBuilder request = get("/menu/getMenuList").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getMenuList() process test with result:{}", result);
	}

	@Test
	public void saveMenu() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", "1");
		jsonObject.put("parentId", "1");
		jsonObject.put("name", "1");
		jsonObject.put("iconName", "1");
		jsonObject.put("link", "1");
		jsonObject.put("sort", "1");
		jsonObject.put("isDel", "1");
		jsonObject.put("createTime", "2016-11-07 05:20:54");
		jsonObject.put("createBy", "1");
		jsonObject.put("createName", "1");
		jsonObject.put("updateTime", "2016-11-07 05:20:54");
		jsonObject.put("updateBy", "1");
		jsonObject.put("updateName", "1");
		RequestBuilder request = post("/menu/saveMenu").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("saveMenu() process test with result:{}", result);
	}

	@Test
	public void updateMenu() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
		jsonObject.put("code", "2");
		jsonObject.put("parentId", "2");
		jsonObject.put("name", "2");
		jsonObject.put("iconName", "2");
		jsonObject.put("link", "2");
		jsonObject.put("sort", "2");
		jsonObject.put("isDel", "2");
		jsonObject.put("createTime", "2016-11-08 05:20:54");
		jsonObject.put("createBy", "2");
		jsonObject.put("createName", "2");
		jsonObject.put("updateTime", "2016-11-08 05:20:54");
		jsonObject.put("updateBy", "2");
		jsonObject.put("updateName", "2");
		RequestBuilder request = post("/menu/updateMenu").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("updateMenu() process test with result:{}", result);
	}

	@Test
	public void deleteMenuById() throws Exception {
		RequestBuilder request = get("/menu/deleteMenuById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("deleteMenuById() process test with result:{}", result);
	}

	@Test
	public void batchSaveMenu() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("code", "1");
		jsonObject1.put("parentId", "1");
		jsonObject1.put("name", "1");
		jsonObject1.put("iconName", "1");
		jsonObject1.put("link", "1");
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
		jsonObject2.put("parentId", "1");
		jsonObject2.put("name", "1");
		jsonObject2.put("iconName", "1");
		jsonObject2.put("link", "1");
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
		RequestBuilder request = post("/menu/batchSaveMenu").contentType(MediaType.APPLICATION_JSON).content(jsonArray.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("batchSaveMenu() process test with result:{}", result);
	}
}
