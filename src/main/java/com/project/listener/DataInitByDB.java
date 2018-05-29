package com.project.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;
import com.project.util.InitDataUtil;
import com.project.util.InitPowerUtil;
import com.project.util.InitRoleUtil;

/**
 * 启动Tomcat加载数据库数据到内存
 * 
 * @author 赵子墨
 *
 */
public class DataInitByDB implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		Driver d = null;
		while (drivers.hasMoreElements()) {
			try {
				d = drivers.nextElement();
				DriverManager.deregisterDriver(d);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		AbandonedConnectionCleanupThread.checkedShutdown();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext context = sce.getServletContext();
			context.setAttribute("DataMap", InitDataUtil.initData(context));
			context.setAttribute("roleMap", InitRoleUtil.initRole(context));
			context.setAttribute("powerMap", InitPowerUtil.initPower(context));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
