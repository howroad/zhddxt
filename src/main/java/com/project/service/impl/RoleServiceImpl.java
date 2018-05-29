/**
 * 
 */
package com.project.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IPowerDao;
import com.project.dao.IRoleDao;
import com.project.dao.IRolePowerDao;
import com.project.dao.IUserDao;
import com.project.dao.IUserRoleDao;
import com.project.entity.PowerEntity;
import com.project.entity.RoleEntity;
import com.project.entity.RolePowerEntity;
import com.project.entity.UserRoleEntity;
import com.project.service.IRoleService;

/**
 * @author howroad
 * @Date 2018年5月9日
 * @version 1.0
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IPowerDao powerDao;
	@Autowired
	private IRolePowerDao rolePowerDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IUserRoleDao userRoleDao;

	@Override
	public List<RoleEntity> findAllRole() {
		return roleDao.list();
	}

	@Override
	public String addRole(RoleEntity role) {
		return roleDao.save(role);
	}

	@Override
	public Set<String> getRoles(String userName) {
		List<String> rolesList = roleDao
				.list("select r.roleDesc from RoleEntity r JOIN r.userRoleEntities ur JOIN ur.userEntity u"
						+ " WHERE u.userName=?0", userName);
		return new HashSet<String>(rolesList);
	}

	@Override
	public boolean addRolePower(List<String> powers, String roleId) {
		RoleEntity role = roleDao.load(roleId);
		for (String string : powers) {
			if ("null".equals(string) || "".equals(string) || null == string) {
				break;
			}
			PowerEntity power = powerDao.load(string);
			rolePowerDao.save(new RolePowerEntity(power, role));
		}
		return true;
	}

	@Override
	public boolean addUserRole(List<String> users, String roleId) {
		RoleEntity role = roleDao.get(roleId);
		for (String string : users) {
			if ("null".equals(string)) {
				break;
			}
			userRoleDao.save(new UserRoleEntity(role, userDao.get(string)));
		}
		return true;
	}

	@Override
	public boolean delUserRole(List<String> users, String roleId) {
		if (users == null || users.size() == 0 || users.get(0).equals("null")) {
			return true;
		}
		for (String string : users) {
			UserRoleEntity userRole = userRoleDao.uniqueResult(
					"from UserRoleEntity where roleEntity.roleId=?0 and userEntity.userId=?1", roleId, string);
			userRoleDao.delete(userRole);
		}
		return true;
	}

	@Override
	public List<PowerEntity> findAllPowerInRole(String roleId) {
		return powerDao.listBySQL("select distinct sys_power.* from sys_power left join sys_role_power "
				+ "on sys_role_power.power_id = sys_power.power_id where sys_role_power.role_id = ?", roleId);
	}

	@Override
	public List<PowerEntity> findAllPowerNotInRole(String roleId) {
		return powerDao.listBySQL(
				"select distinct sys_power.* from sys_power where power_id not in"
						+ "(select power_id from sys_role_power where sys_role_power.role_id= ? and power_id is not null) ",
				roleId);
	}

	@Override
	public boolean addPowers(List<String> powers, String roleId) {
		RoleEntity role = roleDao.get(roleId);
		for (String string : powers) {
			if ("null".equals(string)) {
				break;
			}
			rolePowerDao.save(new RolePowerEntity(powerDao.get(string), role));
		}
		return true;
	}

	@Override
	public boolean delPowers(List<String> powers, String roleId) {
		if (powers == null || powers.size() == 0 || powers.get(0).equals("null")) {
			return true;
		}
		for (String string : powers) {
			RolePowerEntity rolePower = userRoleDao.uniqueResult(
					"from RolePowerEntity where roleEntity.roleId=?0 and powerEntity.powerId=?1", roleId, string);
			rolePowerDao.delete(rolePower.getRpId());
		}
		return true;
	}

	@Override
	public boolean checkPower(String powerName, String userId) {
		return powerDao.countBySQL(
				"select count(0) from sys_power left join sys_role_power on sys_power.power_id = sys_role_power.power_id "
						+ "left join sys_role on sys_role.role_id = sys_role_power.role_id "
						+ "left join sys_user_role on sys_user_role.role_id = sys_role.role_id "
						+ "where sys_user_role.user_id=? and sys_power.power_name = ?",
				userId, powerName) > 0;
	}

}
