package com.project.service;

import java.util.List;

import com.project.dto.FeedBackDto;
import com.project.entity.FeedBackEntity;

/**
 * 
 * @author 赵子墨
 *
 */
public interface IFeedbackService {
	/**
	 * 根据事件id查询反馈信息列表
	 * 
	 * @param RId
	 *            事件id
	 * @return 反馈集合
	 */
	public List<FeedBackDto> findAllFeedBacks(String RId);

	/**
	 * 根据反馈id查询详情
	 * 
	 * @param fbId
	 *            反馈id
	 * @return 反馈详情
	 */
	public FeedBackDto findFeedBack(String fbId);

	/**
	 * 添加反馈
	 * 
	 * @param feedBack
	 *            反馈
	 * @return boolean
	 */
	public boolean addFeedBack(FeedBackEntity feedBack);
}
