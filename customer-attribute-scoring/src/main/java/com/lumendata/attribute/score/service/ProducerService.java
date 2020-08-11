package com.lumendata.attribute.score.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	private static final Logger LOG = LoggerFactory.getLogger(ProducerService.class);

	@Autowired
	private ProducerService producerService;

	public void sendMessage(String message){
		LOG.debug("Produced Message: "+ message);
		producerService.sendMessage(message);
	}

}
