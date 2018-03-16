package com.mes.purview.outclass.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.mes.purview.outclass.PurviewPlusOutClass;
import com.mes.system.bean.SessionUser;



/**
  * 
  * 项目名称:  [base-web]
  * 包:        [com.mes.sys.purview.outclass.impl]    
  * 类名称:    [DemoPvOutClass]  
  * 类描述:    [外接类DEMO测试实现]
  * 修改备注:  [说明本次修改内容]  
  * 版本:      [v1.0]   
  *
 */
public class DemoPvOutClass extends PurviewPlusOutClass{

	@SuppressWarnings("unused")
	@Override
	public String getSQL() {
		//外界类上下文信息
		HashMap<Object,Object> context=this.context;
		//获取requset对象
		HttpServletRequest requset=this.req;
		//获取用户对象
		SessionUser su=this.su;
		System.out.println(context.toString());
		return " 1=1";
	}
	
}
