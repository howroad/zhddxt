package com.test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.service.IInformationService;
import com.project.service.IPlanningService;
import com.project.service.ISchedulingService;

public class schTest {

	private ClassPathXmlApplicationContext context = null;
	private IPlanningService ps = null;
	private IInformationService is = null;
	private ISchedulingService ss = null;

	@Before
	public void load() {
		context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		ps = (IPlanningService) context.getBean("planningService");
		is = (IInformationService) context.getBean("informaticaService");
		ss = (ISchedulingService) context.getBean("schedulingService");
	}

	@Test
	public void test() {
		try {
			System.out.println(ps.findByPlan("hz", "2", 1, 4).getList().get(0).getPlanName());
			System.out.println(ps.findById("1").getPlanGrade());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		try {
			System.out.println(is.findByInformation(1, 5, "xf", "wh").getList().size());
			System.out.println(is.findAllInformations("xf", "wh"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test3() {
		try {
			System.out.println(ss.findAllSchedulings("1"));
			System.out.println(ss.updateStatus("1", 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
