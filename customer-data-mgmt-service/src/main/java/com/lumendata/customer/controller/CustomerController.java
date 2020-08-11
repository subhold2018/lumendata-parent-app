package com.lumendata.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumendata.common.entities.CustomerEntity;
import com.lumendata.common.model.Customer;
import com.lumendata.common.utils.AlphaNumericKeygeneration;
import com.lumendata.common.utils.CommonUtils;
import com.lumendata.customer.services.CustomerService;

import io.swagger.annotations.Api;


/**
 * 
 * @author jeetu
 *
 */
@RestController
@RequestMapping("/")
@Api(value="Customer Controller")
public class CustomerController {
//	private final Logger log = Logger.getLogger(CustomerController.class.getName());
    
	@Autowired
    CustomerService customerService;

	@PostMapping(value = "/customer", produces = "application/json")
    public CustomerEntity saveCustomer(@RequestBody Customer customer){
		
		CustomerEntity customerEntity = CommonUtils.getCustomerEntityFromCustomer(customer);
		
		customerEntity.setGuid(AlphaNumericKeygeneration.randomAlphaNumeric(15));
        
		return customerService.saveCustomer(customerEntity);
    }

	@GetMapping(value = "/customer/{guid}", produces = "application/json")
    public CustomerEntity getCustomerByGUID(@PathVariable("guid") String guid){
		
		CustomerEntity customerEntity = customerService.findCustomerByGUID(guid);
        return customerEntity;
    }
	
	@GetMapping(value = "/customers", produces = "application/json")
    public Iterable<CustomerEntity> getAllCustomer(){
		
        return customerService.findAll();
    }
}
