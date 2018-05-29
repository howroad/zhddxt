package com.project.dto;

import java.io.Serializable;

/**
 * 反馈dto
 * 
 * @author 赵子墨
 *
 */
@SuppressWarnings("serial")
public class FeedBackDto implements Serializable {

	private String fbId;
	private String resName;
	private String fbPerson;
	private String fbTel;
	private String fbDate;
	private String fbDetails;

	public FeedBackDto() {
	}

	public FeedBackDto(String fbId, String resName, String fbPerson, String fbTel, String fbDate) {
		super();
		this.fbId = fbId;
		this.resName = resName;
		this.fbPerson = fbPerson;
		this.fbTel = fbTel;
		this.fbDate = fbDate;
	}

	public FeedBackDto(String fbId, String resName, String fbPerson, String fbTel, String fbDate, String fbDetails) {
		super();
		this.fbId = fbId;
		this.resName = resName;
		this.fbPerson = fbPerson;
		this.fbTel = fbTel;
		this.fbDate = fbDate;
		this.fbDetails = fbDetails;
	}

	public String getFbId() {
		return fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getFbPerson() {
		return fbPerson;
	}

	public void setFbPerson(String fbPerson) {
		this.fbPerson = fbPerson;
	}

	public String getFbTel() {
		return fbTel;
	}

	public void setFbTel(String fbTel) {
		this.fbTel = fbTel;
	}

	public String getFbDate() {
		return fbDate;
	}

	public void setFbDate(String fbDate) {
		this.fbDate = fbDate;
	}

	public String getFbDetails() {
		return fbDetails;
	}

	public void setFbDetails(String fbDetails) {
		this.fbDetails = fbDetails;
	}

	@Override
	public String toString() {
		return "FeedBackDto [fbId=" + fbId + ", resName=" + resName + ", fbPerson=" + fbPerson + ", fbTel=" + fbTel
				+ ", fbDate=" + fbDate + ", fbDetails=" + fbDetails + "]";
	}

}
