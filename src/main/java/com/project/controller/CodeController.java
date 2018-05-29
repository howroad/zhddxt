package com.project.controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.service.ICodeService;
import com.project.service.impl.CodeServiceImpl;

/**
 * 
 * @author 赵子墨
 *
 */
@Controller
@RequestMapping("code")
public class CodeController {
	@Autowired
	private ICodeService codeService;

	@RequestMapping("getCode")
	@ResponseBody
	public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 接收客户端传递的createTypeFlag标识
		String createTypeFlag = request.getParameter("createTypeFlag");
		// 1.在内存中创建一张图片
		BufferedImage bi = new BufferedImage(CodeServiceImpl.WIDTH, CodeServiceImpl.HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 2.得到图片
		Graphics g = bi.getGraphics();
		// 3.设置图片的背影色
		codeService.setBackGround(g);
		// 4.设置图片的边框
		codeService.setBorder(g);
		// 5.在图片上画干扰线
		codeService.drawRandomLine(g);
		// 6.写在图片上随机数
		// 根据客户端传递的createTypeFlag标识生成验证码图片
		String random = codeService.drawRandomNum((Graphics2D) g, createTypeFlag);
		// 7.将随机数存在session中
		request.getSession().setAttribute("code", random);
		// 8.设置响应头通知浏览器以图片的形式打开
		// 等同于response.setHeader("Content-Type", "image/jpeg");
		response.setContentType("image/jpeg");
		// 9.设置响应头控制浏览器不要缓存
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		// 10.将图片写给浏览器
		ImageIO.write(bi, "jpg", response.getOutputStream());
	}

	@RequestMapping("checkCode")
	@ResponseBody
	public boolean checkCode(HttpServletRequest request, String code) {
		String oldCode = (String) request.getSession().getAttribute("code");
		if (code == null || oldCode == null || !code.equalsIgnoreCase(oldCode)) {
			return false;
		} else {
			return true;
		}
	}

}
