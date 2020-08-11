package com.lumendata.attribute.score.service;

import java.util.Map;

import org.apache.commons.codec.language.Metaphone;
import org.apache.commons.codec.language.Soundex;
import org.springframework.stereotype.Service;

import com.lumendata.common.model.Standardize;
import com.lumendata.common.utils.AbbreviationAndStandardization;
import com.lumendata.common.utils.CommonUtils;

@Service
public class NameScoreService {
	
	AbbreviationAndStandardization abbriAndStandard = AbbreviationAndStandardization.getAbbreviationAndStandardization();

	public Integer getNameScore(String name1, String name2) {
		
		if(null == name1 || name1.isEmpty() || null == name2 || name2.isEmpty()) {
			return 0;
		}

		String[] name1Arr = name1.split(" ");
		String[] name2Arr = name2.split(" ");

		if(name1Arr.length < 2 || name2Arr.length <2) {
			return 0;
		}
		
		if(name1.equalsIgnoreCase(name2)) {
			return 100;
		}

		if(name1Arr[1].equalsIgnoreCase(name2Arr[1]) 
				&& (name2Arr[0].equalsIgnoreCase(abbriAndStandard.getAbbreviation().get(name1Arr[0].toUpperCase()))
						|| name1Arr[0].equalsIgnoreCase(abbriAndStandard.getAbbreviation().get(name2Arr[0].toUpperCase())))) {
			return 95; 
		}

		if (name1Arr.length == name2Arr.length && name1Arr[1].equalsIgnoreCase(name2Arr[1]) 
				&& new Soundex().encode(name1Arr[0]).equalsIgnoreCase(new Soundex().encode(name2Arr[0])) ) {
			return 85;
		}

		String maxString = name1.length() >= name2.length() ? name1 : name2;

		if((maxString.equals(name2) && maxString.contains(name1Arr[0]) && maxString.contains(name1Arr[1]) 
				&& maxString.substring(maxString.lastIndexOf(" ")).trim().equalsIgnoreCase(name1Arr[1])) 
				|| (maxString.equals(name1) && maxString.contains(name2Arr[0]) && maxString.contains(name2Arr[1]) 
				&& maxString.substring(maxString.lastIndexOf(" ")).trim().equalsIgnoreCase(name2Arr[1]))) { 

			return 60; 

		}

		if(name1Arr.length == name2Arr.length && CommonUtils.calculateDistanceDP(name1Arr[1], name2Arr[1]) <= 2 
				&& getStandardizedAbbreviatedName(name1Arr[0], name2Arr[0])) {
			return 50;
		}

		if(name1Arr.length == name2Arr.length && CommonUtils.calculateDistanceDP(name1, name2) <= 2 ) {
			return 25; 
		}
		
		if(name1Arr.length == name2Arr.length &&name1.substring(0,3).equalsIgnoreCase(name2.substring(0,3))
				&& CommonUtils.calculateDistanceDP(name1Arr[1], name2Arr[1]) <= 2 ) {
			return 18; 
		}
		
		if((name1Arr.length != name2Arr.length 
				&& maxString.equals(name2)
				&& !maxString.contains(name1Arr[0])
				&& !maxString.contains(name1Arr[1])
				&& name1.startsWith(maxString.substring(0,2)))
				|| (name1Arr.length != name2Arr.length 
				&& maxString.equals(name1)
				&& !maxString.contains(name2Arr[0])
				&& !maxString.contains(name2Arr[1])
				&& name2.startsWith(maxString.substring(0,2)))){
			return 16;
		}
		
		if( name1.toLowerCase().contains(name2.toLowerCase()) 
				|| name2.toLowerCase().contains(name1.toLowerCase())) {
			return 12; 
		}
		
		if((name1Arr.length != name2Arr.length
				&& maxString.equals(name2)
				&& name1Arr[0].equalsIgnoreCase(name2Arr[0])
				&& !name1Arr[1].equalsIgnoreCase(name2Arr[2])
				|| name1Arr.length != name2Arr.length
				&& maxString.equals(name1)
				&& name2Arr[0].equalsIgnoreCase(name1Arr[0])
				&& !name2Arr[1].equalsIgnoreCase(name1Arr[2]))
				&& CommonUtils.calculateDistanceDP(name1Arr[1], name2Arr[1]) <= 2 ) {
			return 10; 
		}
		
		if(abbriAndStandard.getStandardization().get(name1Arr[0].toUpperCase()) != null
				&& abbriAndStandard.getStandardization().get(name2Arr[0].toUpperCase()) != null
				&& abbriAndStandard.getStandardization().get(name1Arr[0].toUpperCase()).getStandardizedName()
				.equalsIgnoreCase(abbriAndStandard.getStandardization().get(name2Arr[0]
						.toUpperCase()).getStandardizedName())
				&& new Metaphone().isMetaphoneEqual(name1Arr[1], name2Arr[1])) {
			return 8; 
		}
		
		if(!name1Arr[1].equalsIgnoreCase(name2Arr[1])
				&& checkNameStandardization(name1Arr[0], name2Arr[0])) {
			return 3; 
		}
		

		if(!name1Arr[0].equalsIgnoreCase(name2Arr[0]) && name1Arr[1].equalsIgnoreCase(name2Arr[1])
				&& abbriAndStandard.getStandardization().get(name1Arr[0].toUpperCase()) == null 
				|| abbriAndStandard.getStandardization().get(name2Arr[0].toUpperCase()) == null) {
			return -70; 
		}
		
		if(!name1Arr[0].equalsIgnoreCase(name2Arr[0]) && name1Arr[1].equalsIgnoreCase(name2Arr[1])
				&& !genderCheckByFirstName(name1Arr[0], name2Arr[0])) {
			return -75; 
		}

		return 0;
	}

	private Boolean getStandardizedAbbreviatedName(String str1, String str2) {

		for(Map.Entry<String,String> eachEntry : abbriAndStandard.getAbbreviation().entrySet()) {
			if(eachEntry.getValue().equalsIgnoreCase(str2)) {
				Standardize standardize = abbriAndStandard.getStandardization().get(eachEntry.getKey().toUpperCase());
				if(str1.equalsIgnoreCase(standardize.getStandardizedName())) {
					return Boolean.TRUE;
				}
			}
			if(eachEntry.getValue().equalsIgnoreCase(str1)) {
				Standardize standardize = abbriAndStandard.getStandardization().get(eachEntry.getKey().toUpperCase());
				if(str2.equalsIgnoreCase(standardize.getStandardizedName())) {
					return Boolean.TRUE;
				}
			}
		}

		return Boolean.FALSE;
	}
	
	private Boolean checkNameStandardization(String name1, String name2) {
		
		if(abbriAndStandard.getStandardization() != null
				&& abbriAndStandard.getStandardization().get(name1.toUpperCase()) != null
				&& abbriAndStandard.getStandardization().get(name2.toUpperCase()) != null
				&& abbriAndStandard.getStandardization().get(name1.toUpperCase()).getStandardizedName()
				.equalsIgnoreCase( abbriAndStandard.getStandardization().get(name2.toUpperCase()).getStandardizedName())
				&& abbriAndStandard.getStandardization().get(name1.toUpperCase()).getGender()
				.equalsIgnoreCase("F")
				&& abbriAndStandard.getStandardization().get(name2.toUpperCase()).getGender()
				.equalsIgnoreCase("F")) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	private Boolean genderCheckByFirstName(String firstName1, String firstName2){
		
		if(abbriAndStandard.getStandardization().get(firstName1.toUpperCase()) != null
			&& abbriAndStandard.getStandardization().get(firstName2.toUpperCase()) != null
			&& abbriAndStandard.getStandardization().get(firstName1.toUpperCase()).getGender()
			.equals(abbriAndStandard.getStandardization().get(firstName2.toUpperCase()).getGender())){
				return Boolean.TRUE;
			}
		
		return Boolean.FALSE;
	}

}
