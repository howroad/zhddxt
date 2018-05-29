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
@Table(name = "eme_planning", catalog = "zhddxt")
public class PlanningEntity implements java.io.Serializable {

	private String planId;
	private String planName;
	private String planType;
	private String planGrade;
	private String planDescribe;
	private Integer planPeopleNum;
	private Integer planCarNum;

	/** default constructor */
	public PlanningEntity() {
	}

	/** full constructor */
	public PlanningEntity(String planName, String planType, String planGrade, String planDescribe,
			Integer planPeopleNum, Integer planCarNum) {
		this.planName = planName;
		this.planType = planType;
		this.planGrade = planGrade;
		this.planDescribe = planDescribe;
		this.planPeopleNum = planPeopleNum;
		this.planCarNum = planCarNum;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "plan_id", unique = true, nullable = false, length = 36)
	public String getPlanId() {
		return this.planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	@Column(name = "plan_name", length = 24)
	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	@Column(name = "plan_type", length = 24)
	public String getPlanType() {
		return this.planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	@Column(name = "plan_grade", length = 24)

	public String getPlanGrade() {
		return this.planGrade;
	}

	public void setPlanGrade(String planGrade) {
		this.planGrade = planGrade;
	}

	@Column(name = "plan_describe")

	public String getPlanDescribe() {
		return this.planDescribe;
	}

	public void setPlanDescribe(String planDescribe) {
		this.planDescribe = planDescribe;
	}

	@Column(name = "plan_people_num")
	public Integer getPlanPeopleNum() {
		return this.planPeopleNum;
	}

	public void setPlanPeopleNum(Integer planPeopleNum) {
		this.planPeopleNum = planPeopleNum;
	}

	@Column(name = "plan_car_num")
	public Integer getPlanCarNum() {
		return this.planCarNum;
	}

	public void setPlanCarNum(Integer planCarNum) {
		this.planCarNum = planCarNum;
	}

}