package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ISchedulingDao;
import com.project.dto.SchedulingDto;
import com.project.entity.SchedulingEntity;
import com.project.service.ISchedulingService;

/**
 * 
 * @author 赵子墨
 *
 */
@Service("schedulingService")
public class SchedulingServiceImpl implements ISchedulingService {

	@Autowired
	private ISchedulingDao schedulingDao;

	@Override
	public List<SchedulingDto> findAllSchedulings(String RId) {
		return schedulingDao.list("select new com.project.dto.SchedulingDto"
				+ "(schId,informationEntity.resName,userEntity.userRname,schCar,schPerson,schDate,schStatus) "
				+ "from SchedulingEntity where reportEntity.RId=?0", RId);
	}

	@Override
	public SchedulingDto findScheduling(String schId) {
		return schedulingDao.uniqueResult("", schId);
	}

	@Override
	public boolean addSchedulings(List<SchedulingEntity> list) {
		return schedulingDao.saveMany(list);
	}

	@Override
	public boolean updateStatus(String schId, Integer schStatus) {
		SchedulingEntity sch = schedulingDao.load(schId);
		sch.setSchStatus(schStatus);
		return schedulingDao.update(sch);
	}

	@Override
	public List<SchedulingEntity> findSchedulingByCode(String orgCode, String rCode) {
		return schedulingDao.list("from SchedulingEntity where informationEntity.resCode=?0 and reportEntity.RCode=?1",
				orgCode, rCode);
	}

}
