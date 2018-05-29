package com.project.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.project.entity.RoleEntity;
import com.project.service.IRoleService;

/**
 * 初始化数据
 * 
 * @author 赵子墨
 *
 */
public class InitRoleUtil {

	private static Map<String, String> roleMap = new HashMap<String, String>();

	public static Map<String, String> initRole(ServletContext app) {
		IRoleService roleService = (IRoleService) (WebApplicationContextUtils.getRequiredWebApplicationContext(app))
				.getBean("roleService");
		List<RoleEntity> roleList = roleService.findAllRole();
		for (RoleEntity role : roleList) {
			roleMap.put(role.getRoleId(), role.getRoleName());
		}
		return roleMap;
	}

	public static String getValue(String key) {
		return roleMap.get(key);
	}

	public static String getKey(String value) {
		for (String getKey : roleMap.keySet()) {
			if (roleMap.get(getKey).equals(value)) {
				return getKey;
			}
		}
		return null;
	}

}
