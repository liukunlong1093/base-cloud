package com.mes.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mes.core.utils.StringUtils;
import com.mes.purview.inteface.PurviewPlusInterface;
import com.mes.system.bean.SessionUser;

public class PurviewUtils {

	private static Log logger = LogFactory.getLog(PurviewUtils.class);

	/**
	 * 创建人KEY名称
	 */
	public static String CREATER_KEY = "CREATE_BY";

	/**
	 * 数据权限拼接SQL语句的条件KEY
	 */
	public static String DATA_PURVIEW_SQL_KEY = "pv";

	/**
	 * 渠道KEY名称
	 */
	public static String CHANNEL_ID_KEY = "CHANNEL_ID";

	/**
	 * 前台创建人字段默认值为-100
	 */
	public static String FRONT_CREATER_VALUE = "-100";

	public static String PAGE_MENU_ID = "menuId";

	/**
	 * 数据权限拼接SQL语句的条件KEY
	 */
	public static String DATA_PURVIEW_OUT_CLASS_KEY = "outclass";

	/**
	 * 构造数据权限的sql语句 
	 * @param alias   数据库别名
	 * @param context 上下文信息<su,创建人数据库字段>
	 * @return 数据权限Sql语句
	 */
	public static String buildSQL4DataPurview(String alias, HashMap<Object, Object> context) {
		try {
			String datapvoutclass = StringUtils.trim(context.get(DATA_PURVIEW_OUT_CLASS_KEY));
			// 来自页面里面加载gridUrl中的菜单ID
			Long pageMenuId = StringUtils.getAsLong(StringUtils.trim(context.get(PAGE_MENU_ID)));
			String create_by = StringUtils.trim(context.get(CREATER_KEY));

			HttpServletRequest request = (HttpServletRequest) context.get("request");
			if (!StringUtils.hasText(create_by)) {
				create_by = "CREATE_BY";
			}
			if (StringUtils.hasText(alias)) {
				create_by = alias + "." + create_by;
			}
			Long menuId = -1L;
			SessionUser su = (SessionUser) context.get("su");
			String visitUrl = request.getRequestURL().toString();
			String sitePart = "http://" + request.getServerName();
			String port = request.getServerPort() + "";
			String projectName = request.getContextPath();
			String weburl = sitePart + ":" + port + projectName + "/";
			String actonUrl = visitUrl.replace(weburl, "");
			// if(BaseController.urlMenuMap.containsKey("/"+actonUrl)){
			// menuId=BaseController.urlMenuMap.get("/"+actonUrl);
			// }else{
			// String action[]=actonUrl.split("/");
			// if(BaseController.urlMenuMap.containsKey("/"+action[0])){
			// menuId=BaseController.urlMenuMap.get("/"+action[0]);
			// }
			// }
			if (pageMenuId > -1) {
				menuId = pageMenuId;
			}
			if (menuId == -1) {
				logger.error("当前数据权限所在菜单为空!!!!!");
			}
			Map<Long, List<Long>> otherDataPvCreaterIdMap = su.getOtherDataPvCreaterIdMap();
			List<Long> dataPvUser = ((List<Long>) otherDataPvCreaterIdMap.get(menuId));
			StringBuffer sb = new StringBuffer();
			// 如果不是admin执行下面数据权限
			if (999999 != su.getId()) {
				// 如果是渠道管理员只有渠道权限
				if (su.getUserExpandMap() != null) {
					String isChannelAdmin = StringUtils.trim(su.getUserExpandMap().get("isChannelAdmin"));
					if ("1".equals(isChannelAdmin)) {
						return sb.toString();
					} else {
						if (dataPvUser != null && dataPvUser.size() > 0) {
							sb.append(" (").append(create_by).append(" = '").append(su.getId()).append("'");
							// 默认前台创建的数据当前渠道的人可以看
							sb.append(" OR ").append(create_by).append(" =-100");
							// 我可以看当前菜单下那些人创建的数据
							sb.append(" OR ").append(create_by).append(" IN (");
							for (int i = 0, len = dataPvUser.size(); i < len; i++) {
								sb.append(dataPvUser.get(i));
								if (i < dataPvUser.size() - 1) {
									sb.append(",");
								}
							}
							sb.append(")");
							 // 如果有外界类拼接外接类权限
							if (!StringUtils.hasText(datapvoutclass)) {
								String sql = getOutClassConditionSql(datapvoutclass, context);
								sb.append(" OR ").append(sql);
							}
							sb.append(" )");
						} else {
							sb.append(" (").append(create_by).append(" = '").append(su.getId()).append("'");
							sb.append(" OR ").append(create_by).append(" =-100");
							 // 如果有外界类拼接外接类权限
							if (StringUtils.hasText(datapvoutclass)) {
								String sql = getOutClassConditionSql(datapvoutclass, context);
								sb.append(" OR ").append(sql);
							}
							sb.append(" )");
						}
					}
				}
			}
			return sb.toString();

		} catch (Exception e) {
			logger.error(e);
		}
		return "";
	}

	@SuppressWarnings("rawtypes")
	private static String getOutClassConditionSql(String datapvoutclass, HashMap<Object, Object> initmap) {
		String str = "";
		Class c = null;
		try {
			if (StringUtils.hasText(datapvoutclass)) {
				c = Class.forName(datapvoutclass);
				PurviewPlusInterface outclass = (PurviewPlusInterface) c.newInstance();
				outclass.setContext(initmap);
				String condition = outclass.getSQL();
				if (StringUtils.hasText(condition)) {
					str = condition;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			c = null;
		}
		return str;
	}
}
