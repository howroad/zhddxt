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
@Table(name = "dis_feedback", catalog = "zhddxt")
public class FeedBackEntity implements java.io.Serializable {

	private String fbId;
	private ReportEntity reportEntity;
	private InformationEntity informationEntity;
	private String fbPerson;
	private String fbTel;
	private String fbDate;
	private String fbDetails;

	/** default constructor */
	public FeedBackEntity() {
	}

	/** full constructor */
	public FeedBackEntity(ReportEntity reportEntity, InformationEntity informationEntity, String fbPerson, String fbTel,
			String fbDate, String fbDetails) {
		this.reportEntity = reportEntity;
		this.informationEntity = informationEntity;
		this.fbPerson = fbPerson;
		this.fbTel = fbTel;
		this.fbDate = fbDate;
		this.fbDetails = fbDetails;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "fb_id", unique = true, nullable = false, length = 36)
	public String getFbId() {
		return this.fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
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

	@Column(name = "fb_person", length = 24)
	public String getFbPerson() {
		return this.fbPerson;
	}

	public void setFbPerson(String fbPerson) {
		this.fbPerson = fbPerson;
	}

	@Column(name = "fb_tel", length = 24)
	public String getFbTel() {
		return this.fbTel;
	}

	public void setFbTel(String fbTel) {
		this.fbTel = fbTel;
	}

	@Column(name = "fb_date", length = 19, columnDefinition = "DATETIME")
	public String getFbDate() {
		return this.fbDate;
	}

	public void setFbDate(String fbDate) {
		this.fbDate = fbDate;
	}

	@Column(name = "fb_details")
	public String getFbDetails() {
		return this.fbDetails;
	}

	public void setFbDetails(String fbDetails) {
		this.fbDetails = fbDetails;
	}

}