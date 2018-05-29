package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IUserDao;
import com.project.dto.UserDto;
import com.project.entity.UserEntity;
import com.project.service.IUserService;
import com.project.util.PageBean;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Override
	public List<UserEntity> findAllUser() {
		return userDao.list();
	}

	@Override
	public UserEntity login(String userName, String password) {
		return userDao.uniqueResult("from UserEntity where userName = ?0 and userPassword = ?0", userName, password);
	}

	@Override
	public PageBean<UserEntity> pageBeanAll(int pageNo, int pageSize) {
		return userDao.findAllPage(
				"select new com.project.entity.UserEntity(u.userId,u.userRname,u.userGender,u.userName,u.userTel,u.userAddress) from UserEntity u",
				"select count(userId) from UserEntity", pageNo, pageSize);
	}

	@Override
	public UserDto getByUserName(String userName) {
		return userDao.uniqueResult(
				"select new com.project.dto.UserDto(u.userId,u.userName,u.userPassword) from UserEntity u where u.userName=?0",
				userName);
	}

	@Override
	public PageBean<UserEntity> pageBeanAll(int pageNo, int pageSize, String userName, String roleId) {
		String sql1 = "select distinct sys_user.* from sys_user left join sys_user_role "
				+ "on sys_user.user_id = sys_user_role.user_id where sys_user.user_rname like ? "
				+ "and sys_user_role.role_id like ? and sys_user.user_states = 1";
		String sql2 = "select count(distinct sys_user.user_id) from sys_user "
				+ "left join sys_user_role on sys_user.user_id = sys_user_role.user_id where sys_user.user_rname like ? "
				+ "and sys_user_role.role_id like ? and sys_user.user_states = 1";
		String userName2 = userName == null || userName.length() == 0 ? "" : userName;
		return userDao.findAllPage(sql1, sql2, pageNo, pageSize, "%" + userName2 + "%", "%" + roleId + "%");
	}

	@Override
	public List<UserEntity> findAllUserInRole(String roleId) {
		return userDao.listBySQL(
				"select distinct sys_user.* from sys_user "
						+ "left join sys_user_role on sys_user.user_id = sys_user_role.user_id where sys_user_role.role_id = ?",
				roleId);
	}

	@Override
	public List<UserEntity> findAllUserNotInRole(String roleId) {
		return userDao.listBySQL(
				"select distinct sys_user.* from sys_user where user_id NOT in "
						+ "(select user_id from sys_user_role where sys_user_role.role_id =? and user_id is not null)",
				roleId);
	}

	@Override
	public UserEntity showUser(String userId) {
		return userDao.get(userId);
	}

}
