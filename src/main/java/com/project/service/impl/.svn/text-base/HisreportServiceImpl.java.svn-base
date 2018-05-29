package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IHisreportDao;
import com.project.entity.HistoryEntity;
import com.project.service.IHisreportService;
import com.project.util.InitDataUtil;
import com.project.util.PageBean;

@Service
public class HisreportServiceImpl implements IHisreportService {

	@Autowired
	private IHisreportDao hisreportDao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageBean<HistoryEntity> findByHistory(String rhType, String rhGrade, String rhRegion, int pageNo,
			int pageSize) {
		String str = "";
		List params = new ArrayList();
		if (rhType != null && !"".equals(rhType)) {
			str += " and rhType = ? ";
			params.add(rhType);
		}
		if (rhGrade != null && !"".equals(rhGrade)) {
			str += " and rhGrade = ? ";
			params.add(rhGrade);
		}
		if (rhRegion != null && !"".equals(rhRegion)) {
			str += " and rhRegion = ? ";
			params.add(rhRegion);
		}
		String hql = "from HistoryEntity where 1=1 " + str +" ORDER BY rhEndDate DESC";
		String hql2 = "select count(rhId) from HistoryEntity where 1=1 " + str;
		PageBean<HistoryEntity> page = hisreportDao.findAllPage(hql, hql2, pageNo, pageSize, params.toArray());
		List<HistoryEntity> list = page.getList();
		for (HistoryEntity historyEntity : list) {
			historyEntity.setRhGrade(InitDataUtil.getValue("SJDJ", historyEntity.getRhGrade()));
			historyEntity.setRhRegion(InitDataUtil.getValue("DQ", historyEntity.getRhRegion()));
			historyEntity.setRhType(InitDataUtil.getValue("SJLX", historyEntity.getRhType()));
		}
		return page;
	}

	@Override
	public HistoryEntity findHistory(String rhId) {
		HistoryEntity historyEntity = hisreportDao.get(rhId);
		historyEntity.setRhGrade(InitDataUtil.getValue("SJDJ", historyEntity.getRhGrade()));
		historyEntity.setRhRegion(InitDataUtil.getValue("DQ", historyEntity.getRhRegion()));
		historyEntity.setRhType(InitDataUtil.getValue("SJLX", historyEntity.getRhType()));
		return historyEntity;
	}

	@Override
	public Long countHistory(String dataType, String param) {
		String hql="select count(rhId) from HistoryEntity ";
		if("DQ".equalsIgnoreCase(dataType)) {
			hql += "where rhRegion = ?0";
		} else if("SJLX".equalsIgnoreCase(dataType)) {
			hql += "where rhType = ?0";
		} else {
			hql += "where rhGrade = ?0";
		}
		return hisreportDao.getCount(hql, param);
	}

}
