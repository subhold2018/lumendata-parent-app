package com.ld.app.kafka.consumer;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;

import com.lumendata.attribute.ScoreApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScoreApp.class)
public class ConsumerTest {

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;

	private static final String TOPIC = "customer_guid";

	@Test
	public void testConsumer(){
		ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(TOPIC, "207UK0I4A3GC0WP");
		assertNotNull(send);
	}

}
