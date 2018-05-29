package com.project.service;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 * @author 赵子墨
 *
 */
public interface ICodeService {

	public void setBackGround(Graphics g);
	
	public void setBorder(Graphics g);
	
	public void drawRandomLine(Graphics g);
	
	public String drawRandomNum(Graphics2D g,String... createTypeFlag);
	
	public String createRandomChar(Graphics2D g,String baseChar);
	
}
