package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IInformationDao;
import com.project.entity.InformationEntity;
@Repository
public class InformationDaoImpl extends BasicDaoAdapter<InformationEntity, String> implements IInformationDao{

}
