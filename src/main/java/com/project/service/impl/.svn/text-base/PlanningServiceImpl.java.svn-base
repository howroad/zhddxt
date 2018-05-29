package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IPlanningDao;
import com.project.entity.PlanningEntity;
import com.project.service.IPlanningService;
import com.project.util.PageBean;

@Service("planningService")
public class PlanningServiceImpl implements IPlanningService {

	@Autowired
	private IPlanningDao planningDao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageBean<PlanningEntity> findByPlan(String planType, String planGrade, int pageNo, int pageSize) {
		String str = "";
		List params = new ArrayList();
		if (planType != null && !"".equals(planType)) {
			str += " and planType = ? ";
			params.add(planType);
		}
		if (planGrade != null && !"".equals(planGrade)) {
			str += " and planGrade = ? ";
			params.add(planGrade);
		}
		String hql = " from PlanningEntity where 1=1 " + str;
		String hql2 = "select count(planId) from PlanningEntity where 1=1 " + str;
		return planningDao.findAllPage(hql, hql2, pageNo, pageSize, params.toArray());
	}

	@Override
	public PlanningEntity findById(String planId) {
		return planningDao.get(planId);
	}

	@Override
	public void addPlanning(PlanningEntity plan) {
		planningDao.save(plan);
	}

	@Override
	public void updatePlanning(PlanningEntity plan) {
		planningDao.update(plan);
	}

	@Override
	public void deletePlanning(PlanningEntity plan) {
		planningDao.delete(plan);
	}

}
