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
@Table(name = "sys_role_power", catalog = "zhddxt")
public class RolePowerEntity implements java.io.Serializable {

	private String rpId;
	private PowerEntity powerEntity;
	private RoleEntity roleEntity;

	/** default constructor */
	public RolePowerEntity() {
	}

	/** full constructor */
	public RolePowerEntity(PowerEntity powerEntity, RoleEntity roleEntity) {
		this.powerEntity = powerEntity;
		this.roleEntity = roleEntity;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rp_id", unique = true, nullable = false, length = 36)
	public String getRpId() {
		return this.rpId;
	}

	public void setRpId(String rpId) {
		this.rpId = rpId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "power_id")
	public PowerEntity getPowerEntity() {
		return this.powerEntity;
	}

	public void setPowerEntity(PowerEntity powerEntity) {
		this.powerEntity = powerEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public RoleEntity getRoleEntity() {
		return this.roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

}