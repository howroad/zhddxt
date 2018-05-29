package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.ISchedulingDao;
import com.project.entity.SchedulingEntity;

/**
 * 
 * @author 赵子墨
 *
 */
@Repository
public class SchedulingDaoImpl extends BasicDaoAdapter<SchedulingEntity, String> implements ISchedulingDao {

}
