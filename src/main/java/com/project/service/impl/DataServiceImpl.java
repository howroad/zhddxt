package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IDataDao;
import com.project.entity.DataEntity;
import com.project.service.IDataService;

/**
 * 
 * @author 赵子墨
 *
 */
@Service("dataService")
public class DataServiceImpl implements IDataService {

	@Autowired
	private IDataDao dataDao;
	
	@Override
	public List<DataEntity> findAllDatas(String dataType) {
		return dataDao.list("from DataEntity where dataType=?0", dataType);
	}

	@Override
	public String getValue(String dataType, String dataKey) {
		return dataDao.uniqueResult("select dataValue from DataEntity where dataType=?0 and dataKey=?1", dataType, dataKey);
	}

	@Override
	public List<String> getAllType() {
		return dataDao.list("select DISTINCT new java.lang.String(dataType) from DataEntity");
	}

}
