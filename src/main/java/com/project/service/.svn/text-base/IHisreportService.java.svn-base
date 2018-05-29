package com.project.service;

import com.project.entity.HistoryEntity;
import com.project.util.PageBean;

public interface IHisreportService {

	/**
	 * 获得通过分页和模糊查询后的pagebean
	 * @param rhType 事件类型
	 * @param rhGrade 事件等级
	 * @param rhRegion 事件地点
	 * @param pageNo 当前页数
	 * @param pageSize 一页显示几条数据
	 * @return PageBean
	 */
	public PageBean<HistoryEntity> findByHistory(String rhType,String rhGrade,String rhRegion,int pageNo,int pageSize);

	/**
	 * 根据历史事件ID查询历史事件
	 * @param rhId 事件ID
	 * @return HistoryEntity
	 */
	public HistoryEntity findHistory(String rhId);
	
	/**
	 * 根据事件类型查询该类事件发生的次数
	 * @param dataType 数据类型
	 * @param param 条件
	 * @return 事件数量
	 */
	public Long countHistory(String dataType, String param);
	
}
