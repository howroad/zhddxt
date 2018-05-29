package com.project.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.project.entity.PowerEntity;
import com.project.service.IPowerService;

/**
 * 初始化数据
 * 
 * @author 赵子墨
 *
 */
public class InitPowerUtil {

	private static Map<String, String> powerMap = new HashMap<String, String>();

	public static Map<String, String> initPower(ServletContext app) {
		IPowerService powerService = (IPowerService) (WebApplicationContextUtils.getRequiredWebApplicationContext(app))
				.getBean("powerService");
		List<PowerEntity> powerList = powerService.findAllPower();
		for (PowerEntity power : powerList) {
			powerMap.put(power.getPowerId(), power.getPowerName());
		}
		return powerMap;
	}

	public static String getValue(String key) {
		return powerMap.get(key);
	}

	public static String getKey(String value) {
		for (String getKey : powerMap.keySet()) {
			if (powerMap.get(getKey).equals(value)) {
				return getKey;
			}
		}
		return null;
	}

}
