package com.lumendata.attribute.score.service;

import org.springframework.stereotype.Service;

import com.lumendata.common.utils.CommonUtils;

@Service
public class EmailScoreService {

	public Integer getEmailScore(String email1, String email2) {


		if(null == email1 || email1.isEmpty() || null == email2 || email2.isEmpty()
				|| !email1.contains("@") || !email2.contains("@")) {
			return 0;
		}

		if(email1.equalsIgnoreCase(email2)) {
			return 100;
		}

		if(email1.split("@")[0].equalsIgnoreCase(email2.split("@")[0])) {
			return 75;
		}
		
		if(CommonUtils.calculateDistanceDP(email1, email2) == 1) {
			return 40;
		}

		return 0;
	}
}
