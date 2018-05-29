package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IRenewalDao;
import com.project.dto.RenewalDto;
import com.project.entity.RenewalEntity;
import com.project.service.IRenewalService;
import com.project.util.InitDataUtil;

@Service("renewalService")
public class RenewalServiceImpl implements IRenewalService {
	@Autowired
	private IRenewalDao renewalDao;

	@Override
	public List<RenewalDto> findAllRenewals(String RId) {
		return renewalDao.list(
				"select new com.project.dto.RenewalDto(rsId,rsPerson,rsTel,rsDate,rsGrade) from RenewalEntity where reportEntity.RId=?0 ORDER BY rsDate DESC",
				RId);
	}

	@Override
	public RenewalDto findRenewal(String rsId) {
		return renewalDao.uniqueResult(
				"select new com.project.dto.RenewalDto(rsId,rsPerson,rsTel,rsGrade,rsArea,rsDate,rsDesc,rsCasualties) from RenewalEntity where rsId=?0",
				rsId);
	}

	@Override
	public boolean saveRenewal(RenewalEntity renewal) {
		renewal.setRsGrade(InitDataUtil.getKey("SJDJ", renewal.getRsGrade()));
		return renewalDao.save(renewal) != null;
	}

}
