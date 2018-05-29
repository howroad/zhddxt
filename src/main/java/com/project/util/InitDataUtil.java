package com.project.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.project.entity.DataEntity;
import com.project.service.IDataService;

/**
 * 初始化数据
 * 
 * @author 赵子墨
 *
 */
public class InitDataUtil {

	private static Map<String, Map<String, String>> DataMap = new HashMap<String, Map<String, String>>();

	public static Map<String, Map<String, String>> initData(ServletContext app) {
		IDataService dataService = (IDataService) (WebApplicationContextUtils.getRequiredWebApplicationContext(app))
				.getBean("dataService");
		List<String> dataTypeList = dataService.getAllType();
		// 添加所有的数据信息
		for (String string : dataTypeList) {
			List<DataEntity> dataList = dataService.findAllDatas(string);
			Map<String, String> tempMap = new HashMap<String, String>();
			for (DataEntity data : dataList) {
				tempMap.put(data.getDataKey(), data.getDataValue());
			}
			DataMap.put(string, tempMap);
		}
		return DataMap;
	}

	public static String getValue(String type, String key) {
		return DataMap.get(type).get(key);
	}

	public static String getKey(String type, String value) {
		Map<String, String> map = DataMap.get(type);
		for (String getKey : map.keySet()) {
			if (map.get(getKey).equals(value)) {
				return getKey;
			}
		}
		return null;
	}

}
