package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.entity.HistoryEntity;
import com.project.service.IHisreportService;
import com.project.util.PageBean;

@Controller
@RequestMapping("history")
public class HisreportController {

	@Autowired
	private IHisreportService hisreportService;

	@RequestMapping("listpage.do")
	@ResponseBody
	public PageBean<HistoryEntity> listPage(String rhType, String rhGrade, String rhRegion, int pageNo) {
		PageBean<HistoryEntity> page = hisreportService.findByHistory(rhType, rhGrade, rhRegion, pageNo, 5);
		return page;
	}

	@RequestMapping("findById.do")
	@ResponseBody
	public HistoryEntity findById(String rhId) {
		HistoryEntity his = hisreportService.findHistory(rhId);
		return his;
	}
	
}
