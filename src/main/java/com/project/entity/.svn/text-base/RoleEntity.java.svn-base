package com.project.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author 赵子墨
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "sys_role", catalog = "zhddxt")
public class RoleEntity implements java.io.Serializable {

	private String roleId;
	private String roleName;
	private String roleDesc;
	private Set<RolePowerEntity> rolePowerEntities = new HashSet<RolePowerEntity>(0);
	private Set<UserRoleEntity> userRoleEntities = new HashSet<UserRoleEntity>(0);

	/** default constructor */
	public RoleEntity() {
	}

	/** full constructor */
	public RoleEntity(String roleName, String roleDesc, Set<RolePowerEntity> rolePowerEntities,
			Set<UserRoleEntity> userRoleEntities) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.rolePowerEntities = rolePowerEntities;
		this.userRoleEntities = userRoleEntities;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "role_id", unique = true, nullable = false, length = 36)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name", length = 32)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "role_desc", length = 100)
	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleEntity")
	@JsonIgnore
	public Set<RolePowerEntity> getRolePowerEntities() {
		return this.rolePowerEntities;
	}

	public void setRolePowerEntities(Set<RolePowerEntity> rolePowerEntities) {
		this.rolePowerEntities = rolePowerEntities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleEntity")
	@JsonIgnore
	public Set<UserRoleEntity> getUserRoleEntities() {
		return this.userRoleEntities;
	}

	public void setUserRoleEntities(Set<UserRoleEntity> userRoleEntities) {
		this.userRoleEntities = userRoleEntities;
	}

}