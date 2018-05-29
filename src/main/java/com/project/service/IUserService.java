package com.project.service;

import java.util.List;

import com.project.dto.UserDto;
import com.project.entity.UserEntity;
import com.project.util.PageBean;

/**
 * 
 * @author 赵子墨
 *
 */
public interface IUserService {

	/**
	 * 查询所有用户
	 * 
	 * @return 所有用户
	 */
	public List<UserEntity> findAllUser();

	/**
	 * 登录验证
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return 用户实体
	 */
	public UserEntity login(String userName, String password);

	/**
	 * 分页查询用户
	 * 
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @return PageBean对象
	 */
	public PageBean<UserEntity> pageBeanAll(int pageNo, int pageSize);

	/**
	 * 通过用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	public UserDto getByUserName(String userName);

	/**
	 * 获得分页后的User信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param userName
	 * @param roleId
	 * @return pageBean
	 */
	public PageBean<UserEntity> pageBeanAll(int pageNo, int pageSize, String userName, String roleId);

	/**
	 * 显示该机构中该角色管理的所有用户
	 * 
	 * @param roleId
	 * @return list
	 */
	public List<UserEntity> findAllUserInRole(String roleId);

	/**
	 * 显示该机构中不属于该角色的用户
	 * 
	 * @param roleId
	 * @return
	 */
	public List<UserEntity> findAllUserNotInRole(String roleId);

	/**
	 * 查询用户的所有信息
	 * 
	 * @param userId
	 * @return 用户Bean
	 */
	public UserEntity showUser(String userId);

}
