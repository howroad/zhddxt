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
@Table(name = "res_information", catalog = "zhddxt")
public class InformationEntity implements java.io.Serializable {

	private String resId;
	private String resName;
	private String resType;
	private String resRegion;
	private String resPerson;
	private String resTel;
	private String resCode;
	private Set<FeedBackEntity> feedBackEntities = new HashSet<FeedBackEntity>(0);
	private Set<SchedulingEntity> schedulingEntities = new HashSet<SchedulingEntity>(0);

	/** default constructor */
	public InformationEntity() {
	}

	public InformationEntity(String resId, String resName, String resCode) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resCode = resCode;
	}

	public InformationEntity(String resId, String resName, String resType, String resRegion, String resPerson,
			String resTel, String resCode) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resType = resType;
		this.resRegion = resRegion;
		this.resPerson = resPerson;
		this.resTel = resTel;
		this.resCode = resCode;
	}

	/** full constructor */
	public InformationEntity(String resName, String resType, String resRegion, String resPerson, String resTel,
			String resCode, Set<FeedBackEntity> feedBackEntities, Set<SchedulingEntity> schedulingEntities) {
		this.resName = resName;
		this.resType = resType;
		this.resRegion = resRegion;
		this.resPerson = resPerson;
		this.resTel = resTel;
		this.resCode = resCode;
		this.feedBackEntities = feedBackEntities;
		this.schedulingEntities = schedulingEntities;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "res_id", unique = true, nullable = false, length = 36)
	public String getResId() {
		return this.resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	@Column(name = "res_name", length = 24)
	public String getResName() {
		return this.resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	@Column(name = "res_type", length = 24)
	public String getResType() {
		return this.resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	@Column(name = "res_region", length = 24)
	public String getResRegion() {
		return this.resRegion;
	}

	public void setResRegion(String resRegion) {
		this.resRegion = resRegion;
	}

	@Column(name = "res_person", length = 24)
	public String getResPerson() {
		return this.resPerson;
	}

	public void setResPerson(String resPerson) {
		this.resPerson = resPerson;
	}

	@Column(name = "res_tel", length = 24)
	public String getResTel() {
		return this.resTel;
	}

	public void setResTel(String resTel) {
		this.resTel = resTel;
	}

	@Column(name = "res_code", length = 32)
	public String getResCode() {
		return this.resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "informationEntity")
	@JsonIgnore
	public Set<FeedBackEntity> getFeedBackEntities() {
		return this.feedBackEntities;
	}

	public void setFeedBackEntities(Set<FeedBackEntity> feedBackEntities) {
		this.feedBackEntities = feedBackEntities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "informationEntity")
	@JsonIgnore
	public Set<SchedulingEntity> getSchedulingEntities() {
		return this.schedulingEntities;
	}

	public void setSchedulingEntities(Set<SchedulingEntity> schedulingEntities) {
		this.schedulingEntities = schedulingEntities;
	}

}