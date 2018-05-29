/**
 * 
 */
package com.project.service;

import java.util.List;
import java.util.Set;

import com.project.entity.PowerEntity;
import com.project.entity.RoleEntity;

/**
 * @author howroad
 * @Date 2018年5月9日
 * @version 1.0
 */
public interface IRoleService {
	/**
	 * 查询所有角色
	 * 
	 * @return 角色集合
	 */
	public List<RoleEntity> findAllRole();

	/**
	 * 添加角色
	 * 
	 * @param role
	 *            角色实体
	 * @return 主键
	 */
	public String addRole(RoleEntity role);

	/**
	 * 通过用户名查询角色信息
	 * 
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(String userName);

	/**
	 * 添加角色权限
	 * 
	 * @param powers
	 * @param roleId
	 * @return 是否成功
	 */
	public boolean addRolePower(List<String> powers, String roleId);

	/**
	 * 批量添加角色用户
	 * 
	 * @param users
	 * @param roleId
	 * @return 成功或失败
	 */
	public boolean addUserRole(List<String> users, String roleId);

	/**
	 * 批量删除角色用户
	 * 
	 * @param users
	 * @param roleId
	 * @return 成功或失败
	 */
	public boolean delUserRole(List<String> users, String roleId);

	/**
	 * 查询该角色下所有的权限
	 * 
	 * @param roleId
	 * @return
	 */
	public List<PowerEntity> findAllPowerInRole(String roleId);

	/**
	 * 查询不在该角色下的所有的权限
	 * 
	 * @param roleId
	 * @return
	 */
	public List<PowerEntity> findAllPowerNotInRole(String roleId);

	/**
	 * 批量添加角色权限
	 * 
	 * @param users
	 * @param roleId
	 * @return 成功或失败
	 */
	public boolean addPowers(List<String> powers, String roleId);

	/**
	 * 批量删除角色权限
	 * 
	 * @param users
	 * @param roleId
	 * @return 成功或失败
	 */
	public boolean delPowers(List<String> powers, String roleId);

	/**
	 * 查询该用户是否有此权限
	 * 
	 * @param powerName
	 * @return boolean
	 */
	public boolean checkPower(String powerName, String userId);

}
