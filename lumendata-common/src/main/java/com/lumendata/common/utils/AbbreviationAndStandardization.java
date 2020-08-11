package com.lumendata.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.lumendata.common.model.Standardize;

public class AbbreviationAndStandardization {

	private static Map<String, String> abbreviations = new HashMap<>();

	private static Map<String, Standardize> standardizations = new HashMap<>();

	private static AbbreviationAndStandardization abbreviationAndStandardization = new AbbreviationAndStandardization();

	private static int objectCounter;

	public Map<String, String> getAbbreviation() {
		return abbreviations;
	}

	private String putAbbreviation(String name, String abbreviation) {
		return abbreviations.put(name.toUpperCase(), abbreviation);
	}

	public Map<String, Standardize> getStandardization() {
		return standardizations;
	}

	private Standardize putStandardization(String name, Standardize standardize) {
		return standardizations.put(name.toUpperCase(), standardize);
	}

	public static AbbreviationAndStandardization getAbbreviationAndStandardization() {
		if(objectCounter == 0) {
			AbbreviationAndStandardization.setAbbreviations(abbreviationAndStandardization);
			AbbreviationAndStandardization.setStandardizedName(abbreviationAndStandardization);
			++objectCounter;
		}
		return abbreviationAndStandardization;
	}

	private static void setAbbreviations(AbbreviationAndStandardization abbreviation){

		String abbreviationsData = getResourceFile("files/abbreviation.txt");

		for(String str: abbreviationsData.split("\n")) {
			String[] strArr = str.trim().split(",");
			abbreviation.putAbbreviation(strArr[0], strArr[1]);
		}

	}

	private static void setStandardizedName(AbbreviationAndStandardization abbreviation){

		String standardizedNamesData = getResourceFile("files/standardized.txt");

		for(String str: standardizedNamesData.split("\n")) {
			String[] strArr = str.trim().split(",");
			abbreviation.putStandardization(strArr[0], new Standardize(strArr[0], strArr[1], strArr[2]));
		}

	}

	private static String getResourceFile(String fileName) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String result = null;
		try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
			result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
