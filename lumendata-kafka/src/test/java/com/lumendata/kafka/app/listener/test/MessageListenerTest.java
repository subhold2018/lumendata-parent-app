package com.lumendata.kafka.app.listener.test;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lumendata.kafka.app.KafkaApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaApplication.class)
public class MessageListenerTest {

	private static final String ALL = "all";


	@Value(value="${spring.kafka.consumer.bootstrap-servers}")
	private String bootstrapAddress;

	Properties props = new Properties();

//	@Ignore
	@Test
	public void testSendMessage(){

		Producer<Object, String> producer = new KafkaProducer<>(props);
		ProducerRecord<Object, String> rec = new ProducerRecord<>("demo","Hi this test message");
		producer.send(rec);
		producer.close();
	}

	@Before
	public void testInit(){

		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ProducerConfig.ACKS_CONFIG, ALL);
		props.put(ProducerConfig.RETRIES_CONFIG, 5);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		props.put(SECURITY_PROTOCOL, SASL_PLAINTEXT);
//		props.put(SASL_MECHANISM, PLAIN);
	}
}
