package com.project.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "sys_user", catalog = "zhddxt")
public class UserEntity implements java.io.Serializable {

	private String userId;
	private String userName;
	private String userPassword;
	private String userRname;
	private String userGender;
	private String userBirth;
	private String userTel;
	private String userAddress;
	private String userEmail;
	private String userDate;
	private Integer userStatus;
	private String userPic;
	private Set<SchedulingEntity> schedulingEntities = new HashSet<SchedulingEntity>(0);
	private Set<UserRoleEntity> userRoleEntities = new HashSet<UserRoleEntity>(0);

	/** default constructor */
	public UserEntity() {
	}

	public UserEntity(String userId, String userName, String userRname, String userGender, String userTel,
			String userAddress) {
		this.userId = userId;
		this.userName = userName;
		this.userRname = userRname;
		this.userGender = userGender;
		this.userTel = userTel;
		this.userAddress = userAddress;
	}

	/** full constructor */
	public UserEntity(String userName, String userPassword, String userRname, String userGender, String userBirth,
			String userTel, String userAddress, String userEmail, String userDate, Integer userStatus,
			String userPic, Set<SchedulingEntity> schedulingEntities, Set<UserRoleEntity> userRoleEntities) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRname = userRname;
		this.userGender = userGender;
		this.userBirth = userBirth;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userDate = userDate;
		this.userStatus = userStatus;
		this.userPic = userPic;
		this.schedulingEntities = schedulingEntities;
		this.userRoleEntities = userRoleEntities;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", unique = true, nullable = false, length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", length = 32)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_password", length = 32)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_rname", length = 32)
	public String getUserRname() {
		return this.userRname;
	}

	public void setUserRname(String userRname) {
		this.userRname = userRname;
	}

	@Column(name = "user_gender", length = 10)
	public String getUserGender() {
		return this.userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	@Column(name = "user_birth", length = 10, columnDefinition = "DATE")
	public String getUserBirth() {
		return this.userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	@Column(name = "user_tel", length = 15)
	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	@Column(name = "user_address", length = 100)
	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Column(name = "user_email", length = 50)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "user_date", length = 19, columnDefinition = "DATETIME")
	public String getUserDate() {
		return this.userDate;
	}

	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}

	@Column(name = "user_status")
	public Integer getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	@Column(name = "user_pic")
	public String getUserPic() {
		return this.userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userEntity")
	@JsonIgnore
	public Set<SchedulingEntity> getSchedulingEntities() {
		return this.schedulingEntities;
	}

	public void setSchedulingEntities(Set<SchedulingEntity> schedulingEntities) {
		this.schedulingEntities = schedulingEntities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userEntity")
	@JsonIgnore
	public Set<UserRoleEntity> getUserRoleEntities() {
		return this.userRoleEntities;
	}

	public void setUserRoleEntities(Set<UserRoleEntity> userRoleEntities) {
		this.userRoleEntities = userRoleEntities;
	}

}