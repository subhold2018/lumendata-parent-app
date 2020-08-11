package com.lumendata.attribute.kafka.listener;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lumendata.attribute.clusterkeys.service.ClusterKeysService;
import com.lumendata.common.entities.CustomerEntity;
import com.lumendata.common.model.ClusterKeys;
import com.lumendata.common.model.Customer;
import com.lumendata.common.utils.CommonUtils;

@Service
public class Consumer {

	private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

	@Value("${customer.data.mgmt.service.baseurl}")
	private String neo4JIngesterBaseUrl;
	
	@Autowired
	private ClusterKeysService clusterKeysService;
	
	@KafkaListener(topics = "${kafka.message.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void listenConsumerGroup(String message) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		
		System.out.println(message);
		LOG.debug("The message received " + message);
		try {
			CustomerEntity customer = getCustomerByGUID(message);
			System.out.println(customer.toString());
			ClusterKeys clusterKeys = getClusterKeys(customer);
			
			System.out.println(clusterKeys.toString());
			
			
		}catch (Exception e) {
			LOG.error("Error occured " + e.getMessage());
			System.out.println("Error occured " + e.getMessage());
		}
	}

	private CustomerEntity getCustomerByGUID(String guid) throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = neo4JIngesterBaseUrl.concat(guid);
		URI uri = new URI(baseUrl);

		ResponseEntity<CustomerEntity> customer = restTemplate.getForEntity(uri, CustomerEntity.class);
		if(customer != null) {
			LOG.debug("The customer received " +customer.getBody());
			System.out.println(customer.toString());
			return customer.getBody();
		}
		return null;
	}
	
	private ClusterKeys getClusterKeys(CustomerEntity customerEntity) {
		
		Customer customer = new Customer();
		
		CommonUtils.getCustomerFromEntity(customerEntity, customer);
		
		return clusterKeysService.getClusterKeys(customer);
	}

}