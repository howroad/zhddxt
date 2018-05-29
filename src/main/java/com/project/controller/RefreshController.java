package com.project.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.util.InitDataUtil;
import com.project.util.InitPowerUtil;
import com.project.util.InitRoleUtil;

/**
 * 
 * @author 赵子墨
 *
 */
@Controller
public class RefreshController {

	@RequestMapping("reload")
	public void url(HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		context.setAttribute("DataMap", InitDataUtil.initData(context));
	}
	
	@RequestMapping("reloadRole")
	public void url2(HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		context.setAttribute("roleMap", InitRoleUtil.initRole(context));
		context.setAttribute("powerMap", InitPowerUtil.initPower(context));
	}
	
	@RequestMapping("reloadPower")
	public void url3(HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		context.setAttribute("powerMap", InitPowerUtil.initPower(context));
	}
}
