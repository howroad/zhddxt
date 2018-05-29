package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.entity.UserEntity;

/**
 * 
 * @author 赵子墨
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public String index() {
		return "redirect:/login.jsp";
	}

	@RequestMapping("/login")
	public String login(UserEntity user, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			return "redirect:/jsp/index.jsp";
		}
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPassword());
		try {
			subject.login(token);
			return "redirect:/jsp/index.jsp";
		} catch (Exception e) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "redirect:/login.jsp";
		}
	}

	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			// session 会销毁，在SessionListener监听session销毁，清理权限缓存
			subject.logout();
		}
		return "redirect:/login.jsp";
	}

}
