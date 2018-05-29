/**
 * 
 */
package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IUserRoleDao;
import com.project.entity.UserRoleEntity;

/**
 * @author howroad
 * @Date 2018年5月18日
 * @version 1.0
 */
@Repository("userRoleDao")
public class UserRoleDaoImpl extends BasicDaoAdapter<UserRoleEntity, String> implements IUserRoleDao {

}
