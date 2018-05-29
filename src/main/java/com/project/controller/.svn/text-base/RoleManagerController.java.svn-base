package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.entity.PowerEntity;
import com.project.entity.RoleEntity;
import com.project.entity.UserEntity;
import com.project.service.IRoleService;
import com.project.service.IUserService;
import com.project.util.InitRoleUtil;
import com.project.util.PageBean;

@Controller
@RequestMapping("role")
public class RoleManagerController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	/**
	 * 查询所有角色
	 * 
	 * @param pageNo
	 *            查询的页码数
	 * @return
	 */
	// 这里写该方法对应的权限名字(powerName,可以先不写)
	@RequestMapping("roleManager")
	@ResponseBody
	public PageBean<UserEntity> userList(String pageNo) {
		int pageNoValue = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);
		return userService.pageBeanAll(pageNoValue, 5);
	}

	@RequestMapping("addRole")
	@ResponseBody
	public boolean addRole(@RequestParam(value = "powerIds", required = false) List<String> powerIds, RoleEntity role,
			HttpServletRequest request) {
		String roleId = roleService.addRole(role);
		roleService.addRolePower(powerIds, roleId);
		request.getServletContext().setAttribute("roleMap", InitRoleUtil.initRole(request.getServletContext()));
		return true;
	}

	@RequestMapping("findAllUserInRole")
	@ResponseBody
	public List<UserEntity> findAllUserInRole(String roleId, HttpServletRequest request) {
		return userService.findAllUserInRole(roleId);
	}

	@RequestMapping("findAllUserNotInRole")
	@ResponseBody
	public List<UserEntity> findAllUserNotInRole(String roleId, HttpServletRequest request) {
		return userService.findAllUserNotInRole(roleId);
	}

	@RequestMapping("updateRoleUser")
	@ResponseBody
	public boolean updateRoleUser(@RequestParam(value = "addUsers", required = false) List<String> addUsers,
			@RequestParam(value = "delUsers", required = false) List<String> delUsers, String roleId) {
		roleService.addUserRole(addUsers, roleId);
		roleService.delUserRole(delUsers, roleId);
		return true;
	}

	@RequestMapping("findAllPowerInRole")
	@ResponseBody
	public List<PowerEntity> findAllPowerInRole(String roleId) {
		return roleService.findAllPowerInRole(roleId);
	}

	@RequestMapping("findAllPowerNotInRole")
	@ResponseBody
	public List<PowerEntity> findAllPowerNotInRole(String roleId) {
		return roleService.findAllPowerNotInRole(roleId);
	}

	@RequestMapping("updateRolePower")
	@ResponseBody
	public boolean updateRolePower(@RequestParam(value = "addPowers", required = false) List<String> addPowers,
			@RequestParam(value = "delPowers", required = false) List<String> delPowers, String roleId) {
		roleService.addRolePower(addPowers, roleId);
		roleService.delPowers(delPowers, roleId);
		return true;
	}
}
