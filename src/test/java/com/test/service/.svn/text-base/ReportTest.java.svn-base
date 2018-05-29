package com.test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.service.IReportService;

public class ReportTest {

	private ClassPathXmlApplicationContext context = null;
	private IReportService rs = null;

	@Before
	public void load() {
		context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		rs = (IReportService) context.getBean("reportService");
	}
	
	@Test
	public void test() {
		try{
			System.out.println(rs.findAllReports("wh", "hz", "2", 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		try{
			System.out.println(rs.findReport("1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		try{
			System.out.println(rs.updateRStatus("1", 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
