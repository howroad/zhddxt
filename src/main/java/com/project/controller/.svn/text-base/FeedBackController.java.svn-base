package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.dto.FeedBackDto;
import com.project.service.IFeedbackService;

/**
 * 
 * @author 赵子墨
 *
 */
@Controller
@RequestMapping("feedBack")
public class FeedBackController {

	@Autowired
	private IFeedbackService feedbackService;

	@RequestMapping("findAllFeedBacks")
	@ResponseBody
	public List<FeedBackDto> findAllRenewals(String RId) {
		return feedbackService.findAllFeedBacks(RId);
	}
	
	@RequestMapping("findfeedBack")
	@ResponseBody
	public FeedBackDto findRenewal(String fbId) {
		return feedbackService.findFeedBack(fbId);
	}
	
}
