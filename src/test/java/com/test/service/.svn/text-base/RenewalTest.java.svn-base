package com.test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.service.IRenewalService;

public class RenewalTest {

	private ClassPathXmlApplicationContext context = null;
	private IRenewalService rs = null;

	@Before
	public void load() {
		context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		rs = (IRenewalService) context.getBean("renewalService");
	}
	
	@Test
	public void test() {
		try{
			System.out.println(rs.findAllRenewals("1"));
			System.out.println(rs.findRenewal("1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
