package com.project.dto;

import java.io.Serializable;

/**
 * 调度Dto
 * 
 * @author 赵子墨
 *
 */
@SuppressWarnings("serial")
public class SchedulingDto implements Serializable {

	private String schId;
	private String resName;
	private String userRname;
	private Integer schCar;
	private Integer schPerson;
	private String schDate;
	private Integer schStatus;

	public SchedulingDto() {
	}

	public SchedulingDto(String schId, String resName, String userRname, Integer schCar, Integer schPerson,
			String schDate, Integer schStatus) {
		super();
		this.schId = schId;
		this.resName = resName;
		this.userRname = userRname;
		this.schCar = schCar;
		this.schPerson = schPerson;
		this.schDate = schDate;
		this.schStatus = schStatus;
	}

	public String getSchId() {
		return schId;
	}

	public void setSchId(String schId) {
		this.schId = schId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getUserRname() {
		return userRname;
	}

	public void setUserRname(String userRname) {
		this.userRname = userRname;
	}

	public Integer getSchCar() {
		return schCar;
	}

	public void setSchCar(Integer schCar) {
		this.schCar = schCar;
	}

	public Integer getSchPerson() {
		return schPerson;
	}

	public void setSchPerson(Integer schPerson) {
		this.schPerson = schPerson;
	}

	public String getSchDate() {
		return schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	public Integer getSchStatus() {
		return schStatus;
	}

	public void setSchStatus(Integer schStatus) {
		this.schStatus = schStatus;
	}

	@Override
	public String toString() {
		return "SchedulingDto [schId=" + schId + ", resName=" + resName + ", userRname=" + userRname + ", schCar="
				+ schCar + ", schPerson=" + schPerson + ", schDate=" + schDate + ", schStatus=" + schStatus + "]";
	}

}
