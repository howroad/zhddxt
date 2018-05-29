package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IFeedbackDao;
import com.project.dto.FeedBackDto;
import com.project.entity.FeedBackEntity;
import com.project.service.IFeedbackService;

/**
 * 
 * @author 赵子墨
 *
 */
@Service("feedbackService")
public class FeedbackServiceImpl implements IFeedbackService {
	@Autowired
	private IFeedbackDao feedbackDao;

	@Override
	public List<FeedBackDto> findAllFeedBacks(String RId) {
		return feedbackDao.list(
				"select new com.project.dto.FeedBackDto(fbId,informationEntity.resName,fbPerson,fbTel,fbDate) from FeedBackEntity where reportEntity.RId=?0 ORDER BY fbDate DESC",
				RId);
	}

	@Override
	public FeedBackDto findFeedBack(String fbId) {
		return feedbackDao.uniqueResult(
				"select new com.project.dto.FeedBackDto(fbId,informationEntity.resName,fbPerson,fbTel,fbDate,fbDetails) from FeedBackEntity where fbId=?0",
				fbId);
	}

	@Override
	public boolean addFeedBack(FeedBackEntity feedBack) {
		return feedbackDao.save(feedBack) != null;
	}

}
