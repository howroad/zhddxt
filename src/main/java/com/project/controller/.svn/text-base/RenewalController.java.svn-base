package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.dto.RenewalDto;
import com.project.service.IRenewalService;
import com.project.util.InitDataUtil;

/**
 * 
 * @author 赵子墨
 *
 */
@Controller
@RequestMapping("renewal")
public class RenewalController {

	@Autowired
	private IRenewalService renewalService;

	@RequestMapping("findAllRenewals")
	@ResponseBody
	public List<RenewalDto> findAllRenewals(String RId) {
		List<RenewalDto> list = renewalService.findAllRenewals(RId);
		for (RenewalDto renewalDto : list) {
			renewalDto.setRsGrade(InitDataUtil.getValue("SJDJ", renewalDto.getRsGrade()));
		}
		return list;
	}

	@RequestMapping("findRenewal")
	@ResponseBody
	public RenewalDto findRenewal(String rsId) {
		RenewalDto renewal = renewalService.findRenewal(rsId);
		renewal.setRsGrade(InitDataUtil.getValue("SJDJ", renewal.getRsGrade()));
		return renewal;
	}

}
