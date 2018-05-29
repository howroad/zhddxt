package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.dto.ReportDetailsDto;
import com.project.dto.ReportTableDto;
import com.project.service.IReportService;
import com.project.util.InitDataUtil;

/**
 * 
 * @author 赵子墨
 *
 */
@Controller
@RequestMapping("report")
public class ReportController {
	@Autowired
	private IReportService reportService;

	@RequestMapping("findAllReports")
	@ResponseBody
	public List<ReportTableDto> findAllReports(String RRegion, String RGrade, String RType, int RStatus) {
		return reportService.findAllReports(RRegion, RType, RGrade, RStatus);
	}
	
	@RequestMapping("findReport")
	@ResponseBody
	public ReportDetailsDto findReport(String RId) {
		ReportDetailsDto rdd = reportService.findReport(RId);
		rdd.setRRegionKey(InitDataUtil.getKey("DQ", rdd.getRRegion()));
		return rdd;
	}
	
	@RequestMapping("endReport")
	@ResponseBody
	public Boolean endReport(String RId) {
		return reportService.updateRStatus(RId, 3);
	}

}
