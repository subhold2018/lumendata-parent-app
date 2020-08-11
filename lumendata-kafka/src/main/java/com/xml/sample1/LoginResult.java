package com.xml.sample1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LoginResult", namespace = "http://test.org/ADMail_Service")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginResult {
	
	@XmlElement(name = "ErrorMessage", namespace = "http://test.org/ADMail_Service")
	private String errorMessage;
	
	@XmlElement(name = "Status", namespace = "http://test.org/ADMail_Service")
	private String status;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoginResult [errorMessage=" + errorMessage + ", status=" + status + "]";
	}
	
}
