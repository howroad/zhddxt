package com.project.vo;

/**
 * 
 * @author 赵子墨
 *
 */
public class RenewalVO {
	private String rcode;
	private String userName;
	private String userTel;
	private String rsGrade;
	private String rsArea;
	private String rsDate;
	private String rsDesc;
	private String rsNum;

	public RenewalVO() {
	}

	public RenewalVO(String rcode, String userName, String userTel, String rsGrade, String rsArea, String rsDate,
			String rsDesc, String rsNum) {
		this.rcode = rcode;
		this.userName = userName;
		this.userTel = userTel;
		this.rsGrade = rsGrade;
		this.rsArea = rsArea;
		this.rsDate = rsDate;
		this.rsDesc = rsDesc;
		this.rsNum = rsNum;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
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

	public String getRsNum() {
		return rsNum;
	}

	public void setRsNum(String rsNum) {
		this.rsNum = rsNum;
	}

}
