package com.project.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "dis_report", catalog = "zhddxt")
public class ReportEntity implements java.io.Serializable {

	private String RId;
	private PlanningEntity planningEntity;
	private String RCode;
	private String RName;
	private String RRegion;
	private String RAddress;
	private String RGrade;
	private String RType;
	private String RDate;
	private String RReporter;
	private String RReportTel;
	private String RInitialLoss;
	private String RFinalLoss;
	private String RInitialCasualties;
	private String RFinalCasualties;
	private String RArea;
	private String RImage;
	private String RDesc;
	private Integer RStatus;
	private Set<FeedBackEntity> feedBackEntities = new HashSet<FeedBackEntity>(0);
	private Set<RenewalEntity> renewalEntities = new HashSet<RenewalEntity>(0);
	private Set<SchedulingEntity> schedulingEntities = new HashSet<SchedulingEntity>(0);

	/** default constructor */
	public ReportEntity() {
	}

	/** full constructor */
	public ReportEntity(PlanningEntity planningEntity, String RCode, String RName, String RRegion, String RAddress,
			String RGrade, String RType, String RDate, String RReporter, String RReportTel, String RInitialLoss,
			String RFinalLoss, String RInitialCasualties, String RFinalCasualties, String RArea, String RImage,
			String RDesc, Integer RStatus, Set<FeedBackEntity> feedBackEntities, Set<RenewalEntity> renewalEntities,
			Set<SchedulingEntity> schedulingEntities) {
		this.planningEntity = planningEntity;
		this.RCode = RCode;
		this.RName = RName;
		this.RRegion = RRegion;
		this.RAddress = RAddress;
		this.RGrade = RGrade;
		this.RType = RType;
		this.RDate = RDate;
		this.RReporter = RReporter;
		this.RReportTel = RReportTel;
		this.RInitialLoss = RInitialLoss;
		this.RFinalLoss = RFinalLoss;
		this.RInitialCasualties = RInitialCasualties;
		this.RFinalCasualties = RFinalCasualties;
		this.RArea = RArea;
		this.RImage = RImage;
		this.RDesc = RDesc;
		this.RStatus = RStatus;
		this.feedBackEntities = feedBackEntities;
		this.renewalEntities = renewalEntities;
		this.schedulingEntities = schedulingEntities;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "r_id", unique = true, nullable = false, length = 36)
	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_id")
	public PlanningEntity getPlanningEntity() {
		return this.planningEntity;
	}

	public void setPlanningEntity(PlanningEntity planningEntity) {
		this.planningEntity = planningEntity;
	}

	@Column(name = "r_code", length = 32)
	public String getRCode() {
		return this.RCode;
	}

	public void setRCode(String RCode) {
		this.RCode = RCode;
	}

	@Column(name = "r_name", length = 24)
	public String getRName() {
		return this.RName;
	}

	public void setRName(String RName) {
		this.RName = RName;
	}

	@Column(name = "r_region", length = 24)
	public String getRRegion() {
		return this.RRegion;
	}

	public void setRRegion(String RRegion) {
		this.RRegion = RRegion;
	}

	@Column(name = "r_address", length = 100)

	public String getRAddress() {
		return this.RAddress;
	}

	public void setRAddress(String RAddress) {
		this.RAddress = RAddress;
	}

	@Column(name = "r_grade", length = 24)

	public String getRGrade() {
		return this.RGrade;
	}

	public void setRGrade(String RGrade) {
		this.RGrade = RGrade;
	}

	@Column(name = "r_type", length = 24)
	public String getRType() {
		return this.RType;
	}

	public void setRType(String RType) {
		this.RType = RType;
	}

	@Column(name = "r_date", length = 19, columnDefinition = "DATETIME")
	public String getRDate() {
		return this.RDate;
	}

	public void setRDate(String RDate) {
		this.RDate = RDate;
	}

	@Column(name = "r_reporter", length = 24)
	public String getRReporter() {
		return this.RReporter;
	}

	public void setRReporter(String RReporter) {
		this.RReporter = RReporter;
	}

	@Column(name = "r_report_tel", length = 24)
	public String getRReportTel() {
		return this.RReportTel;
	}

	public void setRReportTel(String RReportTel) {
		this.RReportTel = RReportTel;
	}

	@Column(name = "r_initial_loss", length = 24)
	public String getRInitialLoss() {
		return this.RInitialLoss;
	}

	public void setRInitialLoss(String RInitialLoss) {
		this.RInitialLoss = RInitialLoss;
	}

	@Column(name = "r_final_loss", length = 24)
	public String getRFinalLoss() {
		return this.RFinalLoss;
	}

	public void setRFinalLoss(String RFinalLoss) {
		this.RFinalLoss = RFinalLoss;
	}

	@Column(name = "r_initial_casualties", length = 24)
	public String getRInitialCasualties() {
		return this.RInitialCasualties;
	}

	public void setRInitialCasualties(String RInitialCasualties) {
		this.RInitialCasualties = RInitialCasualties;
	}

	@Column(name = "r_final_casualties", length = 24)
	public String getRFinalCasualties() {
		return this.RFinalCasualties;
	}

	public void setRFinalCasualties(String RFinalCasualties) {
		this.RFinalCasualties = RFinalCasualties;
	}

	@Column(name = "r_area", length = 24)
	public String getRArea() {
		return this.RArea;
	}

	public void setRArea(String RArea) {
		this.RArea = RArea;
	}

	@Column(name = "r_image", length = 100)
	public String getRImage() {
		return this.RImage;
	}

	public void setRImage(String RImage) {
		this.RImage = RImage;
	}

	@Column(name = "r_desc")
	public String getRDesc() {
		return this.RDesc;
	}

	public void setRDesc(String RDesc) {
		this.RDesc = RDesc;
	}

	@Column(name = "r_status")
	public Integer getRStatus() {
		return this.RStatus;
	}

	public void setRStatus(Integer RStatus) {
		this.RStatus = RStatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reportEntity")
	@JsonIgnore
	public Set<FeedBackEntity> getFeedBackEntities() {
		return this.feedBackEntities;
	}

	public void setFeedBackEntities(Set<FeedBackEntity> feedBackEntities) {
		this.feedBackEntities = feedBackEntities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reportEntity")
	@JsonIgnore
	public Set<RenewalEntity> getRenewalEntities() {
		return this.renewalEntities;
	}

	public void setRenewalEntities(Set<RenewalEntity> renewalEntities) {
		this.renewalEntities = renewalEntities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reportEntity")
	@JsonIgnore
	public Set<SchedulingEntity> getSchedulingEntities() {
		return this.schedulingEntities;
	}

	public void setSchedulingEntities(Set<SchedulingEntity> schedulingEntities) {
		this.schedulingEntities = schedulingEntities;
	}

}