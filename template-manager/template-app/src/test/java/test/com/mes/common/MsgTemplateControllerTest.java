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
  * 类名称:		[MsgTemplateController]  
  * 类描述:		[消息模板控制器测试类]
  * 创建人:		[刘坤龙]   
  * 创建时间:	[2017年8月24日 上午11:45:34]   
  * 修改人:		[刘坤龙]   
  * 修改时间:	[2017年8月24日 上午11:45:34]   
  * 修改备注:	[说明本次修改内容]  
  * 版本:		[v1.0]
 */
@WebAppConfiguration
@AutoConfigureMockMvc
public class MsgTemplateControllerTest extends BaseTester {
	private static final Logger logger = LoggerFactory.getLogger(MsgTemplateControllerTest.class);
	@Resource
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getMsgTemplateById() throws Exception {
		RequestBuilder request = get("/msgTemplate/getMsgTemplateById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getMsgTemplateById() process test with result:{}", result);
	}

	@Test
	public void getMsgTemplateList() throws Exception {
		RequestBuilder request = get("/msgTemplate/getMsgTemplateList").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("getMsgTemplateList() process test with result:{}", result);
	}

	@Test
	public void saveMsgTemplate() throws Exception {
		JSONObject jsonObject = new JSONObject();
																			jsonObject.put("code","1");
						    														jsonObject.put("type","1");
						    														jsonObject.put("status","1");
						    														jsonObject.put("title","1");
						    														jsonObject.put("content","1");
						    														jsonObject.put("sort","1");
						    														jsonObject.put("isDel","1");
						    														jsonObject.put("createTime","2016-11-07 05:20:54");
						    														jsonObject.put("createBy","1");
						    														jsonObject.put("createName","1");
						    														jsonObject.put("updateTime","2016-11-07 05:20:54");
						    														jsonObject.put("updateBy","1");
						    														jsonObject.put("updateName","1");
						    				RequestBuilder request = post("/msgTemplate/saveMsgTemplate").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("saveMsgTemplate() process test with result:{}", result);
	}

	@Test
	public void updateMsgTemplate() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "1");
																			jsonObject.put("code","2");
						    														jsonObject.put("type","2");
						    														jsonObject.put("status","2");
						    														jsonObject.put("title","2");
						    														jsonObject.put("content","2");
						    														jsonObject.put("sort","2");
						    														jsonObject.put("isDel","2");
						    														jsonObject.put("createTime","2016-11-08 05:20:54");
						    														jsonObject.put("createBy","2");
						    														jsonObject.put("createName","2");
						    														jsonObject.put("updateTime","2016-11-08 05:20:54");
						    														jsonObject.put("updateBy","2");
						    														jsonObject.put("updateName","2");
						    				RequestBuilder request = post("/msgTemplate/updateMsgTemplate").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("updateMsgTemplate() process test with result:{}", result);
	}

	@Test
	public void deleteMsgTemplateById() throws Exception {
		RequestBuilder request = get("/msgTemplate/deleteMsgTemplateById").param("id", "1");
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("deleteMsgTemplateById() process test with result:{}", result);
	}

	@Test
	public void batchSaveMsgTemplate() throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
																			jsonObject1.put("code","1");
						    														jsonObject1.put("type","1");
						    														jsonObject1.put("status","1");
						    														jsonObject1.put("title","1");
						    														jsonObject1.put("content","1");
						    														jsonObject1.put("sort","1");
						    														jsonObject1.put("isDel","1");
						    														jsonObject1.put("createTime","2016-11-07 05:20:54");
						    														jsonObject1.put("createBy","1");
						    														jsonObject1.put("createName","1");
						    														jsonObject1.put("updateTime","2016-11-07 05:20:54");
						    														jsonObject1.put("updateBy","1");
						    														jsonObject1.put("updateName","1");
						    				JSONObject jsonObject2 = new JSONObject();
																			jsonObject2.put("code","1");
						    														jsonObject2.put("type","1");
						    														jsonObject2.put("status","1");
						    														jsonObject2.put("title","1");
						    														jsonObject2.put("content","1");
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
		RequestBuilder request = post("/msgTemplate/batchSaveMsgTemplate").contentType(MediaType.APPLICATION_JSON).content(jsonArray.toJSONString());
		String result = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		logger.info("batchSaveMsgTemplate() process test with result:{}", result);
	}
}
