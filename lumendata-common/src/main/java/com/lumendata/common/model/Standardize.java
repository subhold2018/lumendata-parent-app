package com.lumendata.common.model;

public class Standardize {
	
	private String givenName;
	private String standardizedName;
	private String gender;
	
	public Standardize() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Standardize(String givenName, String standardizedName, String gender) {
		super();
		this.givenName = givenName;
		this.standardizedName = standardizedName;
		this.gender = gender;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getStandardizedName() {
		return standardizedName;
	}
	public void setStandardizedName(String standardizedName) {
		this.standardizedName = standardizedName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "StandardizedName [givenName=" + givenName + ", standardizedName=" + standardizedName + ", gender="
				+ gender + "]";
	}
	
}
