package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author 赵子墨
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "sys_user_role", catalog = "zhddxt")
public class UserRoleEntity implements java.io.Serializable {

	private String urId;
	private RoleEntity roleEntity;
	private UserEntity userEntity;

	/** default constructor */
	public UserRoleEntity() {
	}

	/** full constructor */
	public UserRoleEntity(RoleEntity roleEntity, UserEntity userEntity) {
		this.roleEntity = roleEntity;
		this.userEntity = userEntity;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ur_id", unique = true, nullable = false, length = 36)
	public String getUrId() {
		return this.urId;
	}

	public void setUrId(String urId) {
		this.urId = urId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public RoleEntity getRoleEntity() {
		return this.roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public UserEntity getUserEntity() {
		return this.userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

}