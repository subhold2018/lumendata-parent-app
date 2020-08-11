package com.lumendata.attribute.score.service;

import org.springframework.stereotype.Service;

import com.lumendata.attribute.score.model.AddressModel;

@Service
public class AddressScoreService {

	public Integer getAddressScore(AddressModel address1, AddressModel address2) {
		
		if(address1 == null || address2 == null) {
			return 0;
		}
		if(exactMatchAddress(address1, address2)) {
			return 100;
		}
		
		if(matchAddressWords(address1, address2)) {
			return 35;
		}
		
		if(matchZipCodeDigits(address1, address2)) {
			return 4;
		}
		
		if(address1.getCity() != null && address1.getCity().equalsIgnoreCase(address2.getCity())) {
			return 3;
		}
		
		return 0;
		
	}
	
	private Boolean matchZipCodeDigits(AddressModel address1, AddressModel address2) {
		
		if(address1.getZip() >= 1000 && address2.getZip() >= 1000 ) {
			if(Integer.parseInt(String.valueOf(address1.getZip()).substring(0,4)) 
					== Integer.parseInt(String.valueOf(address2.getZip()).substring(0,4))) {
				return Boolean.TRUE;
			}
		}
		
		return Boolean.FALSE;
	}
	
	private Boolean matchAddressWords(AddressModel address1, AddressModel address2) {
		
		if(address1.getAddressLine1() != null && address1.getAddressLine1().equalsIgnoreCase(address2.getAddressLine1())
				&& address1.getAddressLine1() != null && address1.getAddressLine2().equalsIgnoreCase(address2.getAddressLine2())
				&& address1.getCity() != null && address1.getCity().equalsIgnoreCase(address2.getCity())
				&& address1.getState() != null && address1.getState().equalsIgnoreCase(address2.getState())){
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}
	
	private Boolean exactMatchAddress(AddressModel address1, AddressModel address2) {
		
		if(address1.getAddressLine1() != null && address1.getAddressLine1().equalsIgnoreCase(address2.getAddressLine1()) 
				&& address1.getAddressLine2() != null && address1.getAddressLine2().equalsIgnoreCase(address2.getAddressLine2())
				&& address1.getCity() != null &&  address1.getCity().equalsIgnoreCase(address2.getCity())
				&& address1.getState() != null && address1.getState().equalsIgnoreCase(address2.getState())
				&& address1.getZip() == address2.getZip()){
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}
	
}
