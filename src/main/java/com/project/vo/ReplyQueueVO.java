package com.project.vo;

/**
 * 
 * @author 赵子墨
 *
 */
public class ReplyQueueVO {
	private String sign;
	private String message;
	private String rCode;
	private String orgCode;
	private String orgUser;
	private String orgTel;

	public ReplyQueueVO() {
	}

	public ReplyQueueVO(String sign, String message, String rCode, String orgCode, String orgUser, String orgTel) {
		super();
		this.sign = sign;
		this.message = message;
		this.rCode = rCode;
		this.orgCode = orgCode;
		this.orgUser = orgUser;
		this.orgTel = orgTel;
	}

	public String getOrgUser() {
		return orgUser;
	}

	public void setOrgUser(String orgUser) {
		this.orgUser = orgUser;
	}

	public String getOrgTel() {
		return orgTel;
	}

	public void setOrgTel(String orgTel) {
		this.orgTel = orgTel;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getrCode() {
		return rCode;
	}

	public void setrCode(String rCode) {
		this.rCode = rCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

}
