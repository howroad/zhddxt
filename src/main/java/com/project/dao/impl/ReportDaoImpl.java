package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IReportDao;
import com.project.entity.ReportEntity;

/**
 * 
 * @author 赵子墨
 *
 */
@Repository
public class ReportDaoImpl extends BasicDaoAdapter<ReportEntity, String> implements IReportDao {

}
