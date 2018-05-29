package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IPlanningDao;
import com.project.entity.PlanningEntity;
@Repository
public class PlanningDaoImpl extends BasicDaoAdapter<PlanningEntity, String> implements IPlanningDao{

}
