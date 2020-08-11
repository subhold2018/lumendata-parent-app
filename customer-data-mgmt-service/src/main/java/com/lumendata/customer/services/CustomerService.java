package com.lumendata.customer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumendata.common.entities.CustomerEntity;
import com.lumendata.customer.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public CustomerEntity saveCustomer(CustomerEntity customer) {
		return customerRepository.save(customer);
	}

	public CustomerEntity findCustomerByGUID(String guid) {
		return customerRepository.findByGuid(guid);
	}
	
	public Iterable<CustomerEntity> findAll() {
		return customerRepository.findAll();
	}
}
