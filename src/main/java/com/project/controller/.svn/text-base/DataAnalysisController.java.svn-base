package com.project.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.service.IHisreportService;

@Controller
@RequestMapping("dataAnalysis")
public class DataAnalysisController {
	@Autowired
	private IHisreportService hisreportService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("ceshi.do")
	@ResponseBody
	public List<Object> listData(String dataType, HttpServletRequest request){
		List<Object> list = new ArrayList<Object>();
		Map<String, Map<String, String>> dataMap = (Map<String, Map<String, String>>) request.getServletContext().getAttribute("DataMap");
		Map<String, String> map = dataMap.get(dataType);
		Set<String> dataKeys = map.keySet();
		Collection<String> dataValues = map.values();
		List<Long> count = new ArrayList<Long>();
		for (String key : dataKeys) {
			count.add(hisreportService.countHistory(dataType, key));
		}
		list.add(dataValues);
		list.add(count);
		return list;
	}
}
