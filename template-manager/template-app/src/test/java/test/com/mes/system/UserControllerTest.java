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
  * 类名称:		[UserController]  
  * 类描述:		[用户控制器测试类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月15日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月15日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@WebAppConfiguration
@AutoConfigureMockMvc
public class UserControllerTest extends BaseTester {
	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
	@Resource
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getUserById() throws Exception {
		RequestBuilder request = get("/user/getUserById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getUserById() process test with result:{}", result);
	}

	@Test
	public void getUserList() throws Exception {
		RequestBuilder request = get("/user/getUserList").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getUserList() process test with result:{}", result);
	}

	@Test
	public void saveUser() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "1");
		jsonObject.put("pwd", "1");
		jsonObject.put("fullname", "1");
		jsonObject.put("sex", "1");
		jsonObject.put("status", "1");
		jsonObject.put("birthday", "2016-11-07 05:20:54");
		jsonObject.put("comment", "1");
		jsonObject.put("sort", "1");
		jsonObject.put("isDel", "1");
		jsonObject.put("createTime", "2016-11-07 05:20:54");
		jsonObject.put("createBy", "1");
		jsonObject.put("createName", "1");
		jsonObject.put("updateTime", "2016-11-07 05:20:54");
		jsonObject.put("updateBy", "1");
		jsonObject.put("updateName", "1");
		RequestBuilder request = post("/user/saveUser").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("saveUser() process test with result:{}", result);
	}

	@Test
	public void updateUser() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
		jsonObject.put("name", "2");
		jsonObject.put("pwd", "2");
		jsonObject.put("fullname", "2");
		jsonObject.put("sex", "2");
		jsonObject.put("status", "2");
		jsonObject.put("birthday", "2016-11-08 05:20:54");
		jsonObject.put("comment", "2");
		jsonObject.put("sort", "2");
		jsonObject.put("isDel", "2");
		jsonObject.put("createTime", "2016-11-08 05:20:54");
		jsonObject.put("createBy", "2");
		jsonObject.put("createName", "2");
		jsonObject.put("updateTime", "2016-11-08 05:20:54");
		jsonObject.put("updateBy", "2");
		jsonObject.put("updateName", "2");
		RequestBuilder request = post("/user/updateUser").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("updateUser() process test with result:{}", result);
	}

	@Test
	public void deleteUserById() throws Exception {
		RequestBuilder request = get("/user/deleteUserById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("deleteUserById() process test with result:{}", result);
	}

	@Test
	public void batchSaveUser() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("name", "1");
		jsonObject1.put("pwd", "1");
		jsonObject1.put("fullname", "1");
		jsonObject1.put("sex", "1");
		jsonObject1.put("status", "1");
		jsonObject1.put("birthday", "2016-11-07 05:20:54");
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
		jsonObject2.put("name", "1");
		jsonObject2.put("pwd", "1");
		jsonObject2.put("fullname", "1");
		jsonObject2.put("sex", "1");
		jsonObject2.put("status", "1");
		jsonObject2.put("birthday", "2016-11-07 05:20:54");
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
		RequestBuilder request = post("/user/batchSaveUser").contentType(MediaType.APPLICATION_JSON).content(jsonArray.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("batchSaveUser() process test with result:{}", result);
	}
}
