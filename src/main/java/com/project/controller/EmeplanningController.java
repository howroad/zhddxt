package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.entity.PlanningEntity;
import com.project.service.IPlanningService;
import com.project.util.InitDataUtil;
import com.project.util.PageBean;

@Controller
@RequestMapping("planning")
public class EmeplanningController {

	@Autowired
	private IPlanningService planningService;

	@RequestMapping("findById.do")
	@ResponseBody
	public PlanningEntity findById(String planId) {
		PlanningEntity plan = planningService.findById(planId);
		plan.setPlanGrade(InitDataUtil.getValue("SJDJ", plan.getPlanGrade()));
		plan.setPlanType(InitDataUtil.getValue("SJLX", plan.getPlanType()));
		return plan;
	}

	@RequestMapping("add.do")
	@ResponseBody
	public boolean add(PlanningEntity plan) {
		planningService.addPlanning(plan);
		return true;
	}

	@RequestMapping("update.do")
	@ResponseBody
	public boolean update(String planId, String planGrade, String planDescribe, Integer planPeopleNum,
			Integer planCarNum) {
		PlanningEntity plan = planningService.findById(planId);
		plan.setPlanCarNum(planCarNum);
		plan.setPlanDescribe(planDescribe);
		plan.setPlanGrade(planGrade);
		plan.setPlanPeopleNum(planPeopleNum);
		planningService.updatePlanning(plan);
		return true;
	}

	@RequestMapping("del.do")
	@ResponseBody
	public boolean del(String planId) {
		PlanningEntity plan = planningService.findById(planId);
		planningService.deletePlanning(plan);
		return true;
	}

	@RequestMapping("listpage.do")
	@ResponseBody
	public PageBean<PlanningEntity> listPage(String planType, String planGrade, int pageNo, int pageSize) {
		PageBean<PlanningEntity> page = planningService.findByPlan(planType, planGrade, pageNo, pageSize);
		List<PlanningEntity> planList = page.getList();
		for (PlanningEntity plan : planList) {
			plan.setPlanGrade(InitDataUtil.getValue("SJDJ", plan.getPlanGrade()));
			plan.setPlanType(InitDataUtil.getValue("SJLX", plan.getPlanType()));
		}
		return page;
	}

	@RequestMapping("boxpage")
	@ResponseBody
	public PageBean<PlanningEntity> boxpage(String planType, String planGrade, int pageNo, int pageSize) {
		PageBean<PlanningEntity> page = planningService.findByPlan(InitDataUtil.getKey("SJLX", planType),
				InitDataUtil.getKey("SJDJ", planGrade), pageNo, pageSize);
		List<PlanningEntity> planList = page.getList();
		for (PlanningEntity plan : planList) {
			plan.setPlanGrade(InitDataUtil.getValue("SJDJ", plan.getPlanGrade()));
			plan.setPlanType(InitDataUtil.getValue("SJLX", plan.getPlanType()));
		}
		return page;
	}
}
