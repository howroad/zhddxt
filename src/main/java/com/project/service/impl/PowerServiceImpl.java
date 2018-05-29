package com.project.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IPowerDao;
import com.project.entity.PowerEntity;
import com.project.service.IPowerService;

/**
 * 
 * @author 赵子墨
 *
 */
@Service("powerService")
public class PowerServiceImpl implements IPowerService {
	@Autowired
	private IPowerDao powerDao;

	@Override
	public List<PowerEntity> findPowerByUserId(String userId) {
		return powerDao.list("select p.powerId,p.powerName,p.powerDesc from PowerEntity p "
				+ "join p.rolePowerEntities rp join rp.roleEntity r "
				+ "join r.userRoleEntities ur join ur.userEntity u where u.userId=?0", userId);
	}

	@Override
	public List<PowerEntity> findAllPower() {
		return powerDao.list();
	}

	@Override
	public Set<String> getPermissions(String userName) {
		List<String> permissionsList = powerDao.list("select p.powerDesc from PowerEntity p "
				+ "join p.rolePowerEntities rp join rp.roleEntity r "
				+ "join r.userRoleEntities ur join ur.userEntity u where u.userName=?0", userName);
		return new HashSet<String>(permissionsList);
	}

}
