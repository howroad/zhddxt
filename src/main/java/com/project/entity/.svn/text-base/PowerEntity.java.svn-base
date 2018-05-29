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
@Table(name = "sys_power", catalog = "zhddxt")
public class PowerEntity implements java.io.Serializable {

	private String powerId;
	private String powerName;
	private String powerDesc;
	private Set<RolePowerEntity> rolePowerEntities = new HashSet<RolePowerEntity>(0);

	/** default constructor */
	public PowerEntity() {
	}

	/** full constructor */
	public PowerEntity(String powerName, String powerDesc, Set<RolePowerEntity> rolePowerEntities) {
		this.powerName = powerName;
		this.powerDesc = powerDesc;
		this.rolePowerEntities = rolePowerEntities;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "power_id", unique = true, nullable = false, length = 36)
	public String getPowerId() {
		return this.powerId;
	}

	public void setPowerId(String powerId) {
		this.powerId = powerId;
	}

	@Column(name = "power_name", length = 100)
	public String getPowerName() {
		return this.powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	@Column(name = "power_desc", length = 100)
	public String getPowerDesc() {
		return this.powerDesc;
	}

	public void setPowerDesc(String powerDesc) {
		this.powerDesc = powerDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "powerEntity")
	@JsonIgnore
	public Set<RolePowerEntity> getRolePowerEntities() {
		return this.rolePowerEntities;
	}

	public void setRolePowerEntities(Set<RolePowerEntity> rolePowerEntities) {
		this.rolePowerEntities = rolePowerEntities;
	}

}