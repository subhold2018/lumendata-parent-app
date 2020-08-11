package com.lumendata.kafka.app.service;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	private static final Logger LOG = LoggerFactory.getLogger(ConsumerService.class);

	@KafkaListener(topics = "${kafka.message.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void listenConsumerGroup(String message) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		System.out.println(message);
		LOG.debug("The message received " + message);

		//got xml
		//generated json
		//publish
	}

	@KafkaListener(topics = "${kafka.message.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void listenConsumerGroup1(String message) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		System.out.println(message);
		LOG.debug("The message received " + message);

		//got json
		//generated json
		//publish
		// neo4 rest endpoint
	}
	
	@KafkaListener(topics = "${kafka.message.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void listenConsumerGroup2(String message) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		System.out.println(message);
		LOG.debug("The message received " + message);

		//got json
		//generated json
		//publish
	}
	

}