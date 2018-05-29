package com.project.service;

import java.util.List;

import com.project.dto.SchedulingDto;
import com.project.entity.SchedulingEntity;

/**
 * 
 * @author 赵子墨
 *
 */
public interface ISchedulingService {

	/**
	 * 根据事件id查询调度信息列表
	 * 
	 * @param RId
	 *            事件id
	 * @return 反馈集合
	 */
	public List<SchedulingDto> findAllSchedulings(String RId);

	/**
	 * 根据调度id查询详情
	 * 
	 * @param schId
	 *            调度id
	 * @return 调度详情
	 */
	public SchedulingDto findScheduling(String schId);

	/**
	 * 根据组织代码号查询调度信息
	 * 
	 * @param orgCode
	 *            组织代码号
	 * @param RCode
	 *            事件编号
	 * @return 调度详情
	 */
	public List<SchedulingEntity> findSchedulingByCode(String orgCode, String rCode);

	/**
	 * 批量添加调度信息
	 * 
	 * @param list
	 *            调度集合
	 * @return boolean
	 */
	public boolean addSchedulings(List<SchedulingEntity> list);

	/**
	 * 修改调度状态
	 * 
	 * @param schId
	 *            调度id
	 * @param schStatus
	 *            调度状态
	 * @return boolean
	 */
	public boolean updateStatus(String schId, Integer schStatus);
}
