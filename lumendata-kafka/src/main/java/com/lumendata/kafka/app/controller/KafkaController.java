package com.lumendata.kafka.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lumendata.kafka.app.service.ProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
	
	@Autowired
	private ProducerService producer;
	
	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message){
		producer.sendMessage(message);
	}
}