package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author 赵子墨
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "his_report", catalog = "zhddxt")
public class HistoryEntity implements java.io.Serializable {

	private String rhId;
	private String rhCode;
	private String planName;
	private String rhName;
	private String rhRegion;
	private String rhAddress;
	private String rhGrade;
	private String rhType;
	private String rhStartDate;
	private String rhEndDate;
	private String RReporter;
	private String RReportTel;
	private String RInitialLoss;
	private String RFinalLoss;
	private String RInitialCasualties;
	private String RFinalCasualties;
	private String RArea;
	private String RImage;
	private String RDesc;

	/** default constructor */
	public HistoryEntity() {
	}

	/** full constructor */
	public HistoryEntity(String rhCode, String planName, String rhName, String rhRegion, String rhAddress,
			String rhGrade, String rhType, String rhStartDate, String rhEndDate, String RReporter,
			String RReportTel, String RInitialLoss, String RFinalLoss, String RInitialCasualties,
			String RFinalCasualties, String RArea, String RImage, String RDesc) {
		this.rhCode = rhCode;
		this.planName = planName;
		this.rhName = rhName;
		this.rhRegion = rhRegion;
		this.rhAddress = rhAddress;
		this.rhGrade = rhGrade;
		this.rhType = rhType;
		this.rhStartDate = rhStartDate;
		this.rhEndDate = rhEndDate;
		this.RReporter = RReporter;
		this.RReportTel = RReportTel;
		this.RInitialLoss = RInitialLoss;
		this.RFinalLoss = RFinalLoss;
		this.RInitialCasualties = RInitialCasualties;
		this.RFinalCasualties = RFinalCasualties;
		this.RArea = RArea;
		this.RImage = RImage;
		this.RDesc = RDesc;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rh_id", unique = true, nullable = false, length = 36)
	public String getRhId() {
		return this.rhId;
	}

	public void setRhId(String rhId) {
		this.rhId = rhId;
	}

	@Column(name = "rh_code", length = 32)
	public String getRhCode() {
		return this.rhCode;
	}

	public void setRhCode(String rhCode) {
		this.rhCode = rhCode;
	}

	@Column(name = "plan_name", length = 32)
	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	@Column(name = "rh_name", length = 24)
	public String getRhName() {
		return this.rhName;
	}

	public void setRhName(String rhName) {
		this.rhName = rhName;
	}

	@Column(name = "rh_region", length = 24)
	public String getRhRegion() {
		return this.rhRegion;
	}

	public void setRhRegion(String rhRegion) {
		this.rhRegion = rhRegion;
	}

	@Column(name = "rh_address", length = 100)
	public String getRhAddress() {
		return this.rhAddress;
	}

	public void setRhAddress(String rhAddress) {
		this.rhAddress = rhAddress;
	}

	@Column(name = "rh_grade", length = 24)
	public String getRhGrade() {
		return this.rhGrade;
	}

	public void setRhGrade(String rhGrade) {
		this.rhGrade = rhGrade;
	}

	@Column(name = "rh_type", length = 24)
	public String getRhType() {
		return this.rhType;
	}

	public void setRhType(String rhType) {
		this.rhType = rhType;
	}

	@Column(name = "rh_start_date", length = 19, columnDefinition = "DATETIME")
	public String getRhStartDate() {
		return this.rhStartDate;
	}

	public void setRhStartDate(String rhStartDate) {
		this.rhStartDate = rhStartDate;
	}

	@Column(name = "rh_end_date", length = 19, columnDefinition = "DATETIME")
	public String getRhEndDate() {
		return this.rhEndDate;
	}

	public void setRhEndDate(String rhEndDate) {
		this.rhEndDate = rhEndDate;
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

}