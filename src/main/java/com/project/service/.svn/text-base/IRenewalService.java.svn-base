package com.project.service;

import java.util.List;

import com.project.dto.RenewalDto;
import com.project.entity.RenewalEntity;

/**
 * 
 * @author 赵子墨
 *
 */
public interface IRenewalService {

	/**
	 * 根据事件id查询续报信息列表
	 * 
	 * @param RId
	 *            事件id
	 * @return 反馈集合
	 */
	public List<RenewalDto> findAllRenewals(String RId);

	/**
	 * 根据续报id查询详情
	 * 
	 * @param fbId
	 *            续报id
	 * @return 反馈详情
	 */
	public RenewalDto findRenewal(String rsId);

	/**
	 * 添加续报
	 * 
	 * @param renewal
	 *            续报
	 * @return boolean
	 */
	public boolean saveRenewal(RenewalEntity renewal);

}
