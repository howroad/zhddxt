package com.test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.service.IFeedbackService;

public class FeedBackTest {

	private ClassPathXmlApplicationContext context = null;
	private IFeedbackService fs = null;

	@Before
	public void load() {
		context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		fs = (IFeedbackService) context.getBean("feedbackService");
	}
	
	@Test
	public void test() {
		try{
			System.out.println(fs.findAllFeedBacks("1"));
			System.out.println(fs.findFeedBack("1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
