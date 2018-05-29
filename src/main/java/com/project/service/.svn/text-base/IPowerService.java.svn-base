package com.project.service;

import java.util.List;
import java.util.Set;

import com.project.entity.PowerEntity;

/**
 * 
 * @author 赵子墨
 *
 */
public interface IPowerService {
	/**
	 * 根据角色id查询权限
	 * 
	 * @param userId
	 *            角色id
	 * @return 权限集合
	 */
	public List<PowerEntity> findPowerByUserId(String userId);

	/**
	 * 查询所有权限
	 * 
	 * @return 权限集合
	 */
	public List<PowerEntity> findAllPower();
	
	/**
	 * 通过用户名查询权限信息
	 * 
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String userName);
	
}
