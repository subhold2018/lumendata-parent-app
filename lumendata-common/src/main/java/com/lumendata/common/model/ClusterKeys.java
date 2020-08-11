package com.lumendata.common.model;

public class ClusterKeys {

	private String firstNameMetaPhoneNumKey;
	private String phoneNumberKey;
	private String nationalIdKey;
	private String emailKey;
	private String dobGivenNameFirstNameKey;
	private String firstNameDOBKey;
	private String lastNameDOBKey;
	
	public ClusterKeys() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClusterKeys(String firstNameMetaPhoneNumKey, String phoneNumberKey, String nationalIdKey, String emailKey,
			String dobGivenNameFirstNameKey, String firstNameDOBKey, String lastNameDOBKey) {
		super();
		this.firstNameMetaPhoneNumKey = firstNameMetaPhoneNumKey;
		this.phoneNumberKey = phoneNumberKey;
		this.nationalIdKey = nationalIdKey;
		this.emailKey = emailKey;
		this.dobGivenNameFirstNameKey = dobGivenNameFirstNameKey;
		this.firstNameDOBKey = firstNameDOBKey;
		this.lastNameDOBKey = lastNameDOBKey;
	}

	public String getFirstNameMetaPhoneNumKey() {
		return firstNameMetaPhoneNumKey;
	}

	public void setFirstNameMetaPhoneNumKey(String firstNameMetaPhoneNumKey) {
		this.firstNameMetaPhoneNumKey = firstNameMetaPhoneNumKey;
	}

	public String getPhoneNumberKey() {
		return phoneNumberKey;
	}

	public void setPhoneNumberKey(String phoneNumberKey) {
		this.phoneNumberKey = phoneNumberKey;
	}

	public String getNationalIdKey() {
		return nationalIdKey;
	}

	public void setNationalIdKey(String nationalIdKey) {
		this.nationalIdKey = nationalIdKey;
	}

	public String getEmailKey() {
		return emailKey;
	}

	public void setEmailKey(String emailKey) {
		this.emailKey = emailKey;
	}

	public String getDobGivenNameFirstNameKey() {
		return dobGivenNameFirstNameKey;
	}

	public void setDobGivenNameFirstNameKey(String dobGivenNameFirstNameKey) {
		this.dobGivenNameFirstNameKey = dobGivenNameFirstNameKey;
	}

	public String getFirstNameDOBKey() {
		return firstNameDOBKey;
	}

	public void setFirstNameDOBKey(String firstNameDOBKey) {
		this.firstNameDOBKey = firstNameDOBKey;
	}

	public String getLastNameDOBKey() {
		return lastNameDOBKey;
	}

	public void setLastNameDOBKey(String lastNameDOBKey) {
		this.lastNameDOBKey = lastNameDOBKey;
	}

	@Override
	public String toString() {
		return "ClusterKeys [firstNameMetaPhoneNumKey=" + firstNameMetaPhoneNumKey + ", phoneNumberKey="
				+ phoneNumberKey + ", nationalIdKey=" + nationalIdKey + ", emailKey=" + emailKey
				+ ", dobGivenNameFirstNameKey=" + dobGivenNameFirstNameKey + ", firstNameDOBKey=" + firstNameDOBKey
				+ ", lastNameDOBKey=" + lastNameDOBKey + "]";
	}
}
