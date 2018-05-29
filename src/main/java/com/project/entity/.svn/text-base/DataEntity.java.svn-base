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
@Table(name = "sys_data", catalog = "zhddxt")
public class DataEntity implements java.io.Serializable {

	private String dataId;
	private String dataType;
	private String dataKey;
	private String dataValue;
	private String dataDesc;

	/** default constructor */
	public DataEntity() {
	}

	/** full constructor */
	public DataEntity(String dataType, String dataKey, String dataValue, String dataDesc) {
		this.dataType = dataType;
		this.dataKey = dataKey;
		this.dataValue = dataValue;
		this.dataDesc = dataDesc;
	}

	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "data_id", unique = true, nullable = false, length = 36)
	public String getDataId() {
		return this.dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	@Column(name = "data_type", length = 24)
	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Column(name = "data_key", length = 24)
	public String getDataKey() {
		return this.dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	@Column(name = "data_value", length = 24)
	public String getDataValue() {
		return this.dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	@Column(name = "data_desc", length = 100)
	public String getDataDesc() {
		return this.dataDesc;
	}

	public void setDataDesc(String dataDesc) {
		this.dataDesc = dataDesc;
	}

}