package com.project.dto;

import java.io.Serializable;

/**
 * 突发事件详情dto
 * 
 * @author 赵子墨
 *
 */
@SuppressWarnings("serial")
public class ReportDetailsDto implements Serializable {
	private String RId;
	private String RCode;
	private String RName;
	private String RRegion;
	private String RRegionKey;
	private String RAddress;
	private String RGrade;
	private String RType;
	private String RDate;
	private String RReporter;
	private String RReportTel;
	private String RInitialLoss;
	private String RInitialCasualties;
	private String RArea;
	private String RImage;
	private String RDesc;
	private Integer RStatus;

	public ReportDetailsDto() {
	}

	public ReportDetailsDto(String rId, String rCode, String rName, String rRegion, String rAddress, String rGrade,
			String rType, String rDate, String rReporter, String rReportTel, String rInitialLoss,
			String rInitialCasualties, String rArea, String rImage, String rDesc, Integer rStatus) {
		super();
		RId = rId;
		RCode = rCode;
		RName = rName;
		RRegion = rRegion;
		RAddress = rAddress;
		RGrade = rGrade;
		RType = rType;
		RDate = rDate;
		RReporter = rReporter;
		RReportTel = rReportTel;
		RInitialLoss = rInitialLoss;
		RInitialCasualties = rInitialCasualties;
		RArea = rArea;
		RImage = rImage;
		RDesc = rDesc;
		RStatus = rStatus;
	}

	public String getRRegionKey() {
		return RRegionKey;
	}

	public void setRRegionKey(String rRegionKey) {
		RRegionKey = rRegionKey;
	}

	public String getRId() {
		return RId;
	}

	public void setRId(String rId) {
		RId = rId;
	}

	public String getRCode() {
		return RCode;
	}

	public void setRCode(String rCode) {
		RCode = rCode;
	}

	public String getRName() {
		return RName;
	}

	public void setRName(String rName) {
		RName = rName;
	}

	public String getRRegion() {
		return RRegion;
	}

	public void setRRegion(String rRegion) {
		RRegion = rRegion;
	}

	public String getRAddress() {
		return RAddress;
	}

	public void setRAddress(String rAddress) {
		RAddress = rAddress;
	}

	public String getRGrade() {
		return RGrade;
	}

	public void setRGrade(String rGrade) {
		RGrade = rGrade;
	}

	public String getRType() {
		return RType;
	}

	public void setRType(String rType) {
		RType = rType;
	}

	public String getRDate() {
		return RDate;
	}

	public void setRDate(String rDate) {
		RDate = rDate;
	}

	public String getRReporter() {
		return RReporter;
	}

	public void setRReporter(String rReporter) {
		RReporter = rReporter;
	}

	public String getRReportTel() {
		return RReportTel;
	}

	public void setRReportTel(String rReportTel) {
		RReportTel = rReportTel;
	}

	public String getRInitialLoss() {
		return RInitialLoss;
	}

	public void setRInitialLoss(String rInitialLoss) {
		RInitialLoss = rInitialLoss;
	}

	public String getRInitialCasualties() {
		return RInitialCasualties;
	}

	public void setRInitialCasualties(String rInitialCasualties) {
		RInitialCasualties = rInitialCasualties;
	}

	public String getRArea() {
		return RArea;
	}

	public void setRArea(String rArea) {
		RArea = rArea;
	}

	public String getRImage() {
		return RImage;
	}

	public void setRImage(String rImage) {
		RImage = rImage;
	}

	public String getRDesc() {
		return RDesc;
	}

	public void setRDesc(String rDesc) {
		RDesc = rDesc;
	}

	public Integer getRStatus() {
		return RStatus;
	}

	public void setRStatus(Integer rStatus) {
		RStatus = rStatus;
	}

	@Override
	public String toString() {
		return "ReportDetailsDto [RId=" + RId + ", RCode=" + RCode + ", RName=" + RName + ", RRegion=" + RRegion
				+ ", RAddress=" + RAddress + ", RGrade=" + RGrade + ", RType=" + RType + ", RDate=" + RDate
				+ ", RReporter=" + RReporter + ", RReportTel=" + RReportTel + ", RInitialLoss=" + RInitialLoss
				+ ", RInitialCasualties=" + RInitialCasualties + ", RArea=" + RArea + ", RImage=" + RImage + ", RDesc="
				+ RDesc + ", RStatus=" + RStatus + "]";
	}

}
