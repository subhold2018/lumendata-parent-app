package com.lumendata.attribute.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumendata.attribute.score.model.AddressModel;
import com.lumendata.attribute.score.service.AddressScoreService;
import com.lumendata.attribute.score.service.EmailScoreService;
import com.lumendata.attribute.score.service.NameScoreService;

@RestController
@RequestMapping(value = "/score")
public class ScoreController {

	@Autowired
	private AddressScoreService addressScoreService;
	
	@Autowired
	private EmailScoreService emailScoreService;
	
	@Autowired
	private NameScoreService nameScoreService;
	
	@PostMapping(value = "/address")
	public Integer addressScore(@RequestBody List<AddressModel> addresses){
		if(addresses.size() < 2) {
			return 0;
		}
		return addressScoreService.getAddressScore(addresses.get(0), addresses.get(1));
	}
	
	@PostMapping(value = "/email")
	public Integer emailScore(@RequestBody List<String> emails){
		
		if(emails.size() < 2) {
			return 0;
		}
		return emailScoreService.getEmailScore(emails.get(0), emails.get(1));
	}
	
	@PostMapping(value = "/name")
	public Integer nameScore(@RequestBody List<String> names){
		
		if(names.size() < 2) {
			return 0;
		}
		return nameScoreService.getNameScore(names.get(0), names.get(1));
	}
}