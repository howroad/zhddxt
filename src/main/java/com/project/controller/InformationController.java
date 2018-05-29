package com.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.InformationEntity;
import com.project.service.IInformationService;
import com.project.util.ExcelImport;
import com.project.util.PageBean;
import com.project.vo.TestVO;

@Controller
@RequestMapping("information")
public class InformationController {

	@Autowired
	private IInformationService informationService;

	@RequestMapping("listpage.do")
	@ResponseBody
	public PageBean<InformationEntity> listPage(String resType, String resRegion, int pageNo) {
		PageBean<InformationEntity> page = informationService.findByInformation(pageNo, 5, resType, resRegion);
		return page;
	}
	
	@RequestMapping("findInformations")
	@ResponseBody
	public List<InformationEntity> findInformations(String resType, String resRegion) {
		return informationService.findInformations(resType, resRegion);
	}
	
	@RequestMapping(value = "/findResByCodes")  
	@ResponseBody
	public List<TestVO> findResByCodes(@RequestParam(required = false, value = "list[]") List<String> list) {
		TestVO test1 = new TestVO("YY0001", "锦江区医院", 10, 5);
		TestVO test2 = new TestVO("WJ0002", "锦江区警局", 10, 5);
		TestVO test3 = new TestVO("SADASDSAD222", "锦江区消防大队", 10, 5);
		List<TestVO> li = new ArrayList<TestVO>();
		li.add(test1);
		li.add(test2);
		li.add(test3);
		return li;
	}
	
	@RequestMapping("uploadInformation")
	@ResponseBody
	public boolean uploadInformation(@RequestParam("xlsFile") MultipartFile file) throws Exception {
		Map<String, String> header = new HashMap<String, String>();
		header.put("资源名", "resName");
		header.put("资源类型", "resType");
		header.put("资源地区", "resRegion");
		header.put("负责人", "resPerson");
		header.put("负责人电话", "resTel");
		header.put("组织机构代码号", "resCode");
		ExcelImport export = new ExcelImport(header);
		export.init(file.getInputStream());
		List<InformationEntity> inforList = export.bindToModels(InformationEntity.class, false);
		informationService.addInformations(inforList);
		return true;
	}
	
}
