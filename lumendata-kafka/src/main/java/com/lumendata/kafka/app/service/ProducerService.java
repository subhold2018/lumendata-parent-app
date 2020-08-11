package com.lumendata.kafka.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	
	 private static final Logger LOG = LoggerFactory.getLogger(ProducerService.class);

	private static final String TOPIC = "demo";
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public void sendMessage(String message){
		LOG.debug(String.format("$$ -> Producing message --> %s",message));
		kafkaTemplate.send(TOPIC, message);
	}
	
}
