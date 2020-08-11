package com.lumendata.attribute.clusterkeys.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.language.Metaphone;
import org.springframework.stereotype.Service;

import com.lumendata.common.model.ClusterKeys;
import com.lumendata.common.model.Customer;

@Service
public class ClusterKeysService {
	
	private static final String MMYYYY = "MMYYYY";
	private static final String DD_MM_YYYY = "dd/MM/yyyy";
	private static final String REGEX = "[^a-zA-Z0-9]";

	public ClusterKeys getClusterKeys(Customer customer) {
		
		ClusterKeys clusterKeys = new ClusterKeys();
		
		getfirstNameMetaPhoneNumKey(customer, clusterKeys);
		getPhoneNumberKey(customer, clusterKeys);
		getNationalIdKey(customer, clusterKeys);
		getEmailKey(customer, clusterKeys);
		getdobGivenNameFirstNameKey(customer, clusterKeys);
		getFirstNameDOBKey(customer, clusterKeys);
		getLastNameDOBKey(customer, clusterKeys);
		
		return clusterKeys;
		
	}

	private void getfirstNameMetaPhoneNumKey(Customer customer, ClusterKeys clusterKeys) {
		
		String metaFirstNameKey = "";
		if(customer.getName().size() > 0 && customer.getName().get(0) != null) {
			Metaphone metaphone = new Metaphone();
			metaphone.setMaxCodeLen(4);
			metaFirstNameKey = metaphone.metaphone(customer.getName().get(0).getFN());
		}
		
		clusterKeys.setFirstNameMetaPhoneNumKey(metaFirstNameKey.concat(extractePhoneNumberAsKey(customer, 7)));
		
	}

	

	private void getPhoneNumberKey(Customer customer, ClusterKeys clusterKeys) {
		clusterKeys.setPhoneNumberKey(extractePhoneNumberAsKey(customer, 6));
	}

	private void getNationalIdKey(Customer customer, ClusterKeys clusterKeys) {
		String nationalKey = "";
		if(customer.getSSN() != null && customer.getSSN().length() <= 10) {
			nationalKey = customer.getSSN();
		}else {
			nationalKey = customer.getSSN().substring(0, 10);
		}
		clusterKeys.setNationalIdKey(nationalKey);
	}

	private void getEmailKey(Customer customer, ClusterKeys clusterKeys) {
		
		if(customer.getEmail().size() > 0 && customer.getEmail().get(0) != null
				&& customer.getEmail().get(0).getEmail() != null) {
			
			if(customer.getEmail().get(0).getEmail().replaceAll(REGEX, "").length() <= 15){
				clusterKeys.setEmailKey(customer.getEmail().get(0).getEmail().toUpperCase()
						.replaceAll(REGEX, ""));
			}else {
				clusterKeys.setEmailKey(customer.getEmail().get(0).getEmail().toUpperCase()
						.replaceAll(REGEX, "").substring(0,15));
			}
		}
	}

	private void getdobGivenNameFirstNameKey(Customer customer, ClusterKeys clusterKeys){
		if(customer.getDob() != null) {
			SimpleDateFormat sdf=new SimpleDateFormat(DD_MM_YYYY);  
			Date date;
			try {
				date = sdf.parse(customer.getDob());
				SimpleDateFormat sdf1 = new SimpleDateFormat(MMYYYY);
				String dobKey = sdf1.format(date);
				
				String firstNameKey = "";
				String lastNameKey = "";
				if(customer.getName().size() > 0 && customer.getName().get(0) != null
						&& customer.getName().get(0).getFN() != null ) {
					firstNameKey = customer.getName().get(0).getFN().toUpperCase().substring(0, 3);
				}
				if(customer.getName().size() > 0 && customer.getName().get(0) != null
						&& customer.getName().get(0).getLN() != null ) {
					lastNameKey = customer.getName().get(0).getLN().toUpperCase().substring(0, 3);
				}
				
				clusterKeys.setDobGivenNameFirstNameKey(dobKey.concat(lastNameKey).concat(firstNameKey));
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void getFirstNameDOBKey(Customer customer, ClusterKeys clusterKeys) {
		
		SimpleDateFormat sdf=new SimpleDateFormat(DD_MM_YYYY);  
		Date date;
		try {
			date = sdf.parse(customer.getDob());
			SimpleDateFormat sdf1 = new SimpleDateFormat(MMYYYY);
			String dobKey = sdf1.format(date);
			
			String firstNameKey = "";
			
			if(customer.getName().size() > 0 && customer.getName().get(0) != null
					&& customer.getName().get(0).getFN() != null 
					&& customer.getName().get(0).getLN().length() <= 4) {
				firstNameKey = customer.getName().get(0).getFN().toUpperCase();
			}else {
				firstNameKey = customer.getName().get(0).getFN().toUpperCase().substring(0, 4);
			}
			clusterKeys.setFirstNameDOBKey(firstNameKey.concat(dobKey));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	private void getLastNameDOBKey(Customer customer, ClusterKeys clusterKeys) {

		SimpleDateFormat sdf=new SimpleDateFormat(DD_MM_YYYY);  
		Date date;
		try {
			date = sdf.parse(customer.getDob());
			SimpleDateFormat sdf1 = new SimpleDateFormat(MMYYYY);
			String dobKey = sdf1.format(date);
			
			String lastNameKey = "";
			
			if(customer.getName().size() > 0 && customer.getName().get(0) != null
					&& customer.getName().get(0).getLN() != null 
					&& customer.getName().get(0).getLN().length() <= 4) {
				lastNameKey = customer.getName().get(0).getLN().toUpperCase();
			}else {
				lastNameKey = customer.getName().get(0).getLN().toUpperCase().substring(0, 4);
			}
			clusterKeys.setLastNameDOBKey(lastNameKey.concat(dobKey));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	private String extractePhoneNumberAsKey(Customer customer, int numberOfDigit) {
		String phoneNumberKey = "";
		if(customer.getPhone().size() > 0 && customer.getPhone().get(0) != null) {
			if(customer.getPhone().get(0).getPhone().toString().length() <= numberOfDigit) {
				phoneNumberKey = customer.getPhone().get(0).getPhone().toString();
			}else {
				phoneNumberKey = customer.getPhone().get(0).getPhone().toString().substring(
						customer.getPhone().get(0).getPhone().toString().length()-numberOfDigit, 
						customer.getPhone().get(0).getPhone().toString().length());
			}
		}
		return phoneNumberKey;
	}

}
