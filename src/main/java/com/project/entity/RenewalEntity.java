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
@Table(name = "dis_renewal", catalog = "zhddxt")
public class RenewalEntity implements java.io.Serializable {

	private String rsId;
	private ReportEntity reportEntity;
	private String rsPerson;
	private String rsTel;
	private String rsGrade;
	private String rsArea;
	private String rsDate;
	private String rsDesc;
	private String rsCasualties;

	/** default constructor */
	public RenewalEntity() {
	}

	/** full constructor */
	public RenewalEntity(ReportEntity reportEntity, String rsPerson, String rsTel, String rsGrade, String rsArea,
			String rsDate, String rsDesc, String rsCasualties) {
		this.reportEntity = reportEntity;
		this.rsPerson = rsPerson;
		this.rsTel = rsTel;
		this.rsGrade = rsGrade;
		this.rsArea = rsArea;
		this.rsDate = rsDate;
		this.rsDesc = rsDesc;
		this.rsCasualties = rsCasualties;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rs_id", unique = true, nullable = false, length = 36)
	public String getRsId() {
		return this.rsId;
	}

	public void setRsId(String rsId) {
		this.rsId = rsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "r_id")
	public ReportEntity getReportEntity() {
		return this.reportEntity;
	}

	public void setReportEntity(ReportEntity reportEntity) {
		this.reportEntity = reportEntity;
	}

	@Column(name = "rs_person", length = 24)
	public String getRsPerson() {
		return this.rsPerson;
	}

	public void setRsPerson(String rsPerson) {
		this.rsPerson = rsPerson;
	}

	@Column(name = "rs_tel", length = 24)
	public String getRsTel() {
		return this.rsTel;
	}

	public void setRsTel(String rsTel) {
		this.rsTel = rsTel;
	}

	@Column(name = "rs_grade", length = 24)

	public String getRsGrade() {
		return this.rsGrade;
	}

	public void setRsGrade(String rsGrade) {
		this.rsGrade = rsGrade;
	}

	@Column(name = "rs_area", length = 24)

	public String getRsArea() {
		return this.rsArea;
	}

	public void setRsArea(String rsArea) {
		this.rsArea = rsArea;
	}

	@Column(name = "rs_date", length = 19, columnDefinition = "DATETIME")
	public String getRsDate() {
		return this.rsDate;
	}

	public void setRsDate(String rsDate) {
		this.rsDate = rsDate;
	}

	@Column(name = "rs_desc")
	public String getRsDesc() {
		return this.rsDesc;
	}

	public void setRsDesc(String rsDesc) {
		this.rsDesc = rsDesc;
	}

	@Column(name = "rs_casualties", length = 24)
	public String getRsCasualties() {
		return this.rsCasualties;
	}

	public void setRsCasualties(String rsCasualties) {
		this.rsCasualties = rsCasualties;
	}

}