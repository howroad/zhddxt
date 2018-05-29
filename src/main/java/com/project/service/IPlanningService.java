package com.project.service;

import com.project.entity.PlanningEntity;
import com.project.util.PageBean;

public interface IPlanningService {

	/**
	 * 获取通过分页和模糊查后的pagebean
	 * 
	 * @param planType
	 *            预案类型
	 * @param planGrade
	 *            预案等级
	 * @param pageNo
	 *            当前显示的页数
	 * @param pageSize
	 *            一页显示几条数据
	 * @return pagebean
	 */
	public PageBean<PlanningEntity> findByPlan(String planType, String planGrade, int pageNo, int pageSize);

	/**
	 * 根据预案ID查询预案实体
	 * 
	 * @param planId
	 *            预案ID
	 */
	public PlanningEntity findById(String planId);

	/**
	 * 添加预案
	 * 
	 * @param plan
	 *            传入一个预案实体PlanningEntity
	 */
	public void addPlanning(PlanningEntity plan);

	/**
	 * 修改预案
	 * 
	 * @param plan
	 *            传入一个预案实体PlanningEntity
	 */
	public void updatePlanning(PlanningEntity plan);

	/**
	 * 删除预案
	 * 
	 * @param plan
	 *            传入一个预案实体PlanningEntity
	 */
	public void deletePlanning(PlanningEntity plan);
}
