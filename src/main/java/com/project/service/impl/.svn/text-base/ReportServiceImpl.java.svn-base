package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IHisreportDao;
import com.project.dao.IReportDao;
import com.project.dto.ReportDetailsDto;
import com.project.dto.ReportTableDto;
import com.project.entity.HistoryEntity;
import com.project.entity.ReportEntity;
import com.project.service.IReportService;
import com.project.util.DateUtil;
import com.project.util.InitDataUtil;

/**
 * 
 * @author 赵子墨
 *
 */
@Service("reportService")
public class ReportServiceImpl implements IReportService {
	@Autowired
	private IReportDao reportDao;
	@Autowired
	private IHisreportDao hisreportDao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ReportTableDto> findAllReports(String RRegion, String RType, String RGrade, Integer RStatus) {
		StringBuilder ql = new StringBuilder(
				"select r.r_id as RId,r.r_code as RCode,r.r_name as RName,dq.data_value as RRegion,lx.data_value as RType,"
						+ "dj.data_value as RGrade,r.r_date as RDate,r.r_status as RStatus "
						+ "from dis_report r JOIN sys_data dq on dq.data_key=r.r_region "
						+ "JOIN sys_data lx ON lx.data_key=r.r_type JOIN sys_data dj ON dj.data_key=r.r_grade "
						+ "WHERE dq.data_type='DQ' AND lx.data_type='SJLX' AND dj.data_type='SJDJ' and r.r_status = ? ");
		List params = new ArrayList();
		params.add(RStatus);
		if (RRegion != null && !"".equals(RRegion)) {
			ql.append(" and r.r_region = ? ");
			params.add(RRegion);
		}
		if (RType != null && !"".equals(RType)) {
			ql.append(" and r.r_type = ? ");
			params.add(RType);
		}
		if (RGrade != null && !"".equals(RGrade)) {
			ql.append(" and r.r_grade = ? ");
			params.add(RGrade);
		}
		ql.append(" ORDER BY r.r_date DESC");
		return reportDao.listBySQL(ql.toString(), ReportTableDto.class, params.toArray());
	}

	@Override
	public ReportDetailsDto findReport(String RId) {
		return reportDao.uniqueResultBySQL(
				"select r.r_id as RId,r.r_code as RCode,r.r_name as RName,r.r_address as RAddress,"
						+ "dq.data_value as RRegion,lx.data_value as RType,dj.data_value as RGrade,"
						+ "r.r_reporter as RReporter,r.r_report_tel as RReportTel,r.r_initial_loss as RInitialLoss,"
						+ "r.r_initial_casualties as RInitialCasualties,r.r_date as RDate,r.r_status as RStatus,"
						+ "r.r_area as RArea,r.r_desc as RDesc,r.r_image as RImage "
						+ "from dis_report r JOIN sys_data dq on dq.data_key=r.r_region "
						+ "JOIN sys_data lx ON lx.data_key=r.r_type JOIN sys_data dj ON dj.data_key=r.r_grade "
						+ "WHERE dq.data_type='DQ' AND lx.data_type='SJLX' AND dj.data_type='SJDJ' and r.r_id = ? ",
				ReportDetailsDto.class, RId);
	}

	@Override
	public boolean updateRStatus(String RId, Integer RStatus) {
		ReportEntity report = reportDao.load(RId);
		report.setRStatus(RStatus);
		if(reportDao.update(report)) {
			if (RStatus == 3) {
				HistoryEntity history = new HistoryEntity(report.getRCode(), report.getPlanningEntity().getPlanName(),
						report.getRName(), report.getRRegion(), report.getRAddress(), report.getRGrade(), report.getRType(),
						report.getRDate(), DateUtil.getTime(), report.getRReporter(), report.getRReportTel(),
						report.getRInitialLoss(), report.getRInitialLoss(), report.getRInitialCasualties(),
						report.getRInitialCasualties(), report.getRArea(), report.getRImage(), report.getRDesc());
				hisreportDao.save(history);
				return true;
			} else {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean saveReport(ReportEntity report) {
		report.setRRegion(InitDataUtil.getKey("DQ", report.getRRegion()));
		report.setRType(InitDataUtil.getKey("SJLX", report.getRType()));
		report.setRGrade(InitDataUtil.getKey("SJDJ", report.getRGrade()));
		return reportDao.save(report) != null;
	}

	@Override
	public ReportEntity getReportByCode(String RCode) {
		return reportDao.uniqueResult("from ReportEntity where RCode=?0", RCode);
	}

	@Override
	public ReportEntity findReportEntity(String RId) {
		return reportDao.get(RId);
	}

	@Override
	public boolean updateReport(ReportEntity report) {
		return reportDao.update(report);
	}

	
}
