package com.project.service;

import java.util.List;

import com.project.entity.InformationEntity;
import com.project.util.PageBean;

public interface IInformationService {

	/**
	 * 获得分页和模糊查询的InformaticaEntity集合
	 * 
	 * @param pageNo
	 *            当前显示页面的页数
	 * @param pageSize
	 *            一共显示几条数据
	 * @param resType
	 *            输入的资源类型
	 * @param resRegion
	 *            输入的资源地区
	 * @return pagebean
	 */
	public PageBean<InformationEntity> findByInformation(int pageNo, int pageSize, String resType, String resRegion);

	/**
	 * 条件查询资源信息
	 * 
	 * @param resType
	 *            资源类型
	 * @param resRegion
	 *            资源地区
	 * @return 集合
	 */
	public List<InformationEntity> findAllInformations(String resType, String resRegion);

	/**
	 * 批量添加资源信息
	 * 
	 * @param list
	 *            资源集合
	 * @return boolean
	 */
	public boolean addInformations(List<InformationEntity> list);

	/**
	 * 条件查询查询资源集合
	 * 
	 * @param resType
	 *            资源类型
	 * @param resRegion
	 *            资源地区
	 * @return 集合
	 */
	public List<InformationEntity> findInformations(String resType, String resRegion);

	/**
	 * 根据code查资源
	 * 
	 * @param resCode
	 *            组织的代码号
	 * @return 资源
	 */
	public InformationEntity findResByCode(String resCode);
}
