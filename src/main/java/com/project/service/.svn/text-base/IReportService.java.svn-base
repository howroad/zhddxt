package com.project.service;

import java.util.List;

import com.project.dto.ReportDetailsDto;
import com.project.dto.ReportTableDto;
import com.project.entity.ReportEntity;

/**
 * 
 * @author 赵子墨
 *
 */
public interface IReportService {

	/**
	 * 根据条件查询突发事件
	 * 
	 * @param RRegion
	 *            地区
	 * @param RType
	 *            类型
	 * @param RGrade
	 *            等级
	 * @param RStatus
	 *            1:未调度 2:进行中 3:已完成
	 * @return 突发事件集合
	 */
	public List<ReportTableDto> findAllReports(String RRegion, String RType, String RGrade, Integer RStatus);

	/**
	 * 根据id查询事件详情
	 * 
	 * @param RId
	 *            事件id
	 * @return 事件实体
	 */
	public ReportDetailsDto findReport(String RId);

	/**
	 * 根据id查询事件详情
	 * 
	 * @param RId
	 *            事件id
	 * @return 事件实体
	 */
	public ReportEntity findReportEntity(String RId);

	/**
	 * 修改事件状态
	 * 
	 * @param RId
	 *            事件id
	 * @param RStatus
	 *            事件状态
	 * @return 成功为true，否则false
	 */
	public boolean updateRStatus(String RId, Integer RStatus);

	/**
	 * 添加事件
	 * 
	 * @param report
	 *            事件
	 * @return boolean
	 */
	public boolean saveReport(ReportEntity report);

	/**
	 * 根据事件标号获取事件
	 * 
	 * @param RCode
	 *            事件编号
	 * @return 事件
	 */
	public ReportEntity getReportByCode(String RCode);

	/**
	 * 修改事件
	 * 
	 * @param report
	 *            事件
	 * @return boolean
	 */
	public boolean updateReport(ReportEntity report);

}
