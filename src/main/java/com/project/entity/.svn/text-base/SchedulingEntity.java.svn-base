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
@Table(name = "dis_scheduling", catalog = "zhddxt")
public class SchedulingEntity implements java.io.Serializable {

	private String schId;
	private ReportEntity reportEntity;
	private InformationEntity informationEntity;
	private UserEntity userEntity;
	private Integer schCar;
	private Integer schPerson;
	private String schDate;
	private Integer schStatus;

	/** default constructor */
	public SchedulingEntity() {
	}

	/** full constructor */
	public SchedulingEntity(ReportEntity reportEntity, InformationEntity informationEntity, UserEntity userEntity,
			Integer schCar, Integer schPerson, String schDate, Integer schStatus) {
		this.reportEntity = reportEntity;
		this.informationEntity = informationEntity;
		this.userEntity = userEntity;
		this.schCar = schCar;
		this.schPerson = schPerson;
		this.schDate = schDate;
		this.schStatus = schStatus;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "sch_id", unique = true, nullable = false, length = 36)
	public String getSchId() {
		return this.schId;
	}

	public void setSchId(String schId) {
		this.schId = schId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "r_id")
	public ReportEntity getReportEntity() {
		return this.reportEntity;
	}

	public void setReportEntity(ReportEntity reportEntity) {
		this.reportEntity = reportEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "info_id")
	public InformationEntity getInformationEntity() {
		return this.informationEntity;
	}

	public void setInformationEntity(InformationEntity informationEntity) {
		this.informationEntity = informationEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public UserEntity getUserEntity() {
		return this.userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Column(name = "sch_car")
	public Integer getSchCar() {
		return this.schCar;
	}

	public void setSchCar(Integer schCar) {
		this.schCar = schCar;
	}

	@Column(name = "sch_person")
	public Integer getSchPerson() {
		return this.schPerson;
	}

	public void setSchPerson(Integer schPerson) {
		this.schPerson = schPerson;
	}

	@Column(name = "sch_date", length = 19, columnDefinition = "DATETIME")
	public String getSchDate() {
		return this.schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	@Column(name = "sch_status")
	public Integer getSchStatus() {
		return this.schStatus;
	}

	public void setSchStatus(Integer schStatus) {
		this.schStatus = schStatus;
	}

}