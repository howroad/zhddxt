package com.project.service;

import java.util.List;

import com.project.entity.DataEntity;

/**
 * 
 * @author 赵子墨
 *
 */
public interface IDataService {

	/**
	 * 根据数据类型获取数据
	 * 
	 * @param dataType
	 *            数据类型
	 * @return 数据集合
	 */
	public List<DataEntity> findAllDatas(String dataType);

	/**
	 * 根据数据类型和key值获取对应value
	 * 
	 * @param dataType
	 *            数据类型
	 * @param dataKey
	 *            key值
	 * @return value值
	 */
	public String getValue(String dataType, String dataKey);

	/**
	 * 获得所有类型
	 * 
	 * @return list
	 */
	public List<String> getAllType();
}
