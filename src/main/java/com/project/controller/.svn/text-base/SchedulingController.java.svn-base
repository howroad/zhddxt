package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.SchedulingDto;
import com.project.entity.ReportEntity;
import com.project.entity.SchedulingEntity;
import com.project.entity.UserEntity;
import com.project.mq.IMqSenderService;
import com.project.service.IInformationService;
import com.project.service.IPlanningService;
import com.project.service.IReportService;
import com.project.service.ISchedulingService;
import com.project.service.IUserService;
import com.project.util.DateUtil;
import com.project.vo.SchedulingVO;
import com.project.vo.TaskTopicVO;

/**
 * 
 * @author 赵子墨
 *
 */
@Controller
@RequestMapping("scheduling")
public class SchedulingController {
	@Autowired
	private IReportService reportService;
	@Autowired
	private ISchedulingService schedulingService;
	@Autowired
	private IInformationService informationService;
	@Autowired
	private IMqSenderService mqSenderService;
	@Autowired
	private IPlanningService planningService;
	@Autowired
	private IUserService userService;

	@RequestMapping("findAllSchedulings")
	@ResponseBody
	public List<SchedulingDto> findAllSchedulings(String RId) {
		return schedulingService.findAllSchedulings(RId);
	}

	@RequestMapping("sendScheduling")
	@ResponseBody
	public boolean sendScheduling() throws JsonProcessingException {
		TaskTopicVO task = new TaskTopicVO("YY0001", "20180518111817WHQHZSJ", "10", "2", "sajkdhdjaksd", "QJ",
				"武侯区火灾事件", "1");
		ObjectMapper obj = new ObjectMapper();
		mqSenderService.sendMsgTopic(obj.writeValueAsString(task));
		return true;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("updateCount")
	@ResponseBody
	public boolean updateCount(@RequestParam(required = false, value = "list[]") List<String> list,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<SchedulingVO> scheList = null;
		Object obj = session.getAttribute("scheList");
		if (obj == null) {
			scheList = new ArrayList<SchedulingVO>();
		} else {
			scheList = (List<SchedulingVO>) session.getAttribute("scheList");
		}
		SchedulingVO sv = new SchedulingVO(list.get(0), list.get(1), list.get(2));
		for (int i = 0; i < scheList.size(); i++) {
			if (scheList.get(i).getOrgCode().equals(list.get(0))) {
				scheList.remove(i);
			}
		}
		scheList.add(sv);
		session.setAttribute("scheList", scheList);
		return true;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("delRes")
	@ResponseBody
	public boolean delRes(String orgCode, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<SchedulingVO> scheList = (List<SchedulingVO>) session.getAttribute("scheList");
		for (int i = 0; i < scheList.size(); i++) {
			if (scheList.get(i).getOrgCode().equals(orgCode)) {
				scheList.remove(i);
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("addSchedulings")
	@ResponseBody
	public boolean addSchedulings(String RId, String planId, HttpServletRequest request)
			throws JsonProcessingException {
		HttpSession session = request.getSession();
		List<SchedulingVO> scheList = (List<SchedulingVO>) session.getAttribute("scheList");
		for (int i = 0; i < scheList.size(); i++) {
			if ("".equals(scheList.get(i).getOrgCode())) {
				scheList.remove(i);
			}
		}
		ReportEntity report = reportService.findReportEntity(RId);
		report.setPlanningEntity(planningService.findById(planId));
		reportService.updateReport(report);
		UserEntity u = new UserEntity();
		u.setUserId(userService.getByUserName((String)SecurityUtils.getSubject().getPrincipal()).getUserId());
		List<SchedulingEntity> list = new ArrayList<SchedulingEntity>();
		for (SchedulingVO schedulingVO : scheList) {
			SchedulingEntity schedulingEntity = new SchedulingEntity();
			schedulingEntity.setReportEntity(report);
			schedulingEntity.setInformationEntity(informationService.findResByCode(schedulingVO.getOrgCode()));
			schedulingEntity.setSchCar(Integer.parseInt(schedulingVO.getrCurrentCar()));
			schedulingEntity.setSchPerson(Integer.parseInt(schedulingVO.getrCurrentPerson()));
			schedulingEntity.setSchDate(DateUtil.getTime());
			schedulingEntity.setSchStatus(0);
			schedulingEntity.setUserEntity(u);
			list.add(schedulingEntity);
		}
		for (SchedulingEntity schedulingEntity : list) {
			TaskTopicVO task = new TaskTopicVO(schedulingEntity.getInformationEntity().getResCode(),
					schedulingEntity.getReportEntity().getRCode(), schedulingEntity.getSchPerson().toString(),
					schedulingEntity.getSchCar().toString(), schedulingEntity.getReportEntity().getRAddress(),
					schedulingEntity.getReportEntity().getRType(), schedulingEntity.getReportEntity().getRName(),
					schedulingEntity.getReportEntity().getRGrade());
			ObjectMapper obj = new ObjectMapper();
			mqSenderService.sendMsgTopic(obj.writeValueAsString(task));
		}
		schedulingService.addSchedulings(list);
		scheList.clear();
		return reportService.updateRStatus(RId, 2);
	}
}
