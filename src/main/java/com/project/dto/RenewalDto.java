package com.project.dto;

import java.io.Serializable;

/**
 * 续报dto
 * 
 * @author 赵子墨
 *
 */
@SuppressWarnings("serial")
public class RenewalDto implements Serializable {

	private String rsId;
	private String rsPerson;
	private String rsTel;
	private String rsGrade;
	private String rsArea;
	private String rsDate;
	private String rsDesc;
	private String rsCasualties;

	public RenewalDto() {
		super();
	}

	public RenewalDto(String rsId, String rsPerson, String rsTel, String rsDate, String rsGrade) {
		super();
		this.rsId = rsId;
		this.rsPerson = rsPerson;
		this.rsTel = rsTel;
		this.rsDate = rsDate;
		this.rsGrade = rsGrade;
	}

	public RenewalDto(String rsId, String rsPerson, String rsTel, String rsGrade, String rsArea, String rsDate,
			String rsDesc, String rsCasualties) {
		super();
		this.rsId = rsId;
		this.rsPerson = rsPerson;
		this.rsTel = rsTel;
		this.rsGrade = rsGrade;
		this.rsArea = rsArea;
		this.rsDate = rsDate;
		this.rsDesc = rsDesc;
		this.rsCasualties = rsCasualties;
	}

	public String getRsId() {
		return rsId;
	}

	public void setRsId(String rsId) {
		this.rsId = rsId;
	}

	public String getRsPerson() {
		return rsPerson;
	}

	public void setRsPerson(String rsPerson) {
		this.rsPerson = rsPerson;
	}

	public String getRsTel() {
		return rsTel;
	}

	public void setRsTel(String rsTel) {
		this.rsTel = rsTel;
	}

	public String getRsGrade() {
		return rsGrade;
	}

	public void setRsGrade(String rsGrade) {
		this.rsGrade = rsGrade;
	}

	public String getRsArea() {
		return rsArea;
	}

	public void setRsArea(String rsArea) {
		this.rsArea = rsArea;
	}

	public String getRsDate() {
		return rsDate;
	}

	public void setRsDate(String rsDate) {
		this.rsDate = rsDate;
	}

	public String getRsDesc() {
		return rsDesc;
	}

	public void setRsDesc(String rsDesc) {
		this.rsDesc = rsDesc;
	}

	public String getRsCasualties() {
		return rsCasualties;
	}

	public void setRsCasualties(String rsCasualties) {
		this.rsCasualties = rsCasualties;
	}

	@Override
	public String toString() {
		return "RenewalDto [rsId=" + rsId + ", rsPerson=" + rsPerson + ", rsTel=" + rsTel + ", rsGrade=" + rsGrade
				+ ", rsArea=" + rsArea + ", rsDate=" + rsDate + ", rsDesc=" + rsDesc + ", rsCasualties=" + rsCasualties
				+ "]";
	}

}
