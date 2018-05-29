package com.project.util;

/**
 * 
 * @author 赵子墨
 *
 */
public class ReportBean<E> {

	private String sign;

	private E data;

	public ReportBean() {
	}

	public ReportBean(String sign, E data) {
		this.sign = sign;
		this.data = data;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ReportBean [sign=" + sign + ", data=" + data + "]";
	}

}
