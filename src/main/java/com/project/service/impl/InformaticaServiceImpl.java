package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IInformationDao;
import com.project.entity.InformationEntity;
import com.project.service.IInformationService;
import com.project.util.InitDataUtil;
import com.project.util.PageBean;

@Service("informaticaService")
public class InformaticaServiceImpl implements IInformationService {

	@Autowired
	private IInformationDao informationDao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageBean<InformationEntity> findByInformation(int pageNo, int pageSize, String resType, String resRegion) {
		String str = "";
		List params = new ArrayList();
		if (resType != null && !"".equals(resType)) {
			str += " and resType = ? ";
			params.add(resType);
		}
		if (resRegion != null && !"".equals(resRegion)) {
			str += " and resRegion = ? ";
			params.add(resRegion);
		}
		String hql = "select new com.project.entity.InformationEntity(resId,resName,resType,resRegion,resPerson,resTel,resCode) "
				+ "from InformationEntity where 1=1 " + str;
		String hql2 = "select count(resId) from InformationEntity where 1=1 " + str;
		PageBean<InformationEntity> page = informationDao.findAllPage(hql, hql2, pageNo, pageSize, params.toArray());
		List<InformationEntity> list = page.getList();
		for (InformationEntity informationEntity : list) {
			informationEntity.setResRegion(InitDataUtil.getValue("DQ", informationEntity.getResRegion()));
			informationEntity.setResType(InitDataUtil.getValue("ZYLX", informationEntity.getResType()));
		}
		return page;
	}

	@Override
	public List<InformationEntity> findAllInformations(String resType, String resRegion) {
		return informationDao.list(
				"select new com.project.entity.InformationEntity(resId,resName,resCode) from InformationEntity where resType=?0 and resRegion=?1",
				resType, resRegion);
	}

	@Override
	public boolean addInformations(List<InformationEntity> list) {
		List<InformationEntity> orgList = informationDao.list();
		List<InformationEntity> resList = new ArrayList<InformationEntity>();
		for (InformationEntity bean : list) {
			boolean flag = true;
			for (InformationEntity newBean : orgList) {
				if (newBean.getResCode().equals(bean.getResCode())) {
					flag = false;
					break;
				}
			}
			if (flag) {
				resList.add(bean);
			}
		}
		for (InformationEntity informationEntity : resList) {
			informationEntity.setResRegion(InitDataUtil.getKey("DQ", informationEntity.getResRegion()));
			informationEntity.setResType(InitDataUtil.getKey("ZYLX", informationEntity.getResType()));
		}
		return informationDao.saveMany(resList);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<InformationEntity> findInformations(String resType, String resRegion) {
		String str = "";
		List params = new ArrayList();
		if (resType != null && !"".equals(resType)) {
			str += " and resType = ? ";
			params.add(resType);
		}
		if (resRegion != null && !"".equals(resRegion)) {
			str += " and resRegion = ? ";
			params.add(resRegion);
		}
		String hql = "select new com.project.entity.InformationEntity(resId,resName,resType,resRegion,resPerson,resTel,resCode) "
				+ "from InformationEntity where 1=1 " + str;
		List<InformationEntity> list = informationDao.list(hql, params.toArray());
		for (InformationEntity informationEntity : list) {
			informationEntity.setResRegion(InitDataUtil.getValue("DQ", informationEntity.getResRegion()));
			informationEntity.setResType(InitDataUtil.getValue("ZYLX", informationEntity.getResType()));
		}
		return list;
	}

	@Override
	public InformationEntity findResByCode(String resCode) {
		return informationDao.uniqueResult("from InformationEntity where resCode=?0", resCode);
	}

}
