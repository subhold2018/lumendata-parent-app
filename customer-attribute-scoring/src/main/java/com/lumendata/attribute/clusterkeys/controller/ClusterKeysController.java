package com.lumendata.attribute.clusterkeys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lumendata.attribute.clusterkeys.service.ClusterKeysService;
import com.lumendata.common.model.ClusterKeys;
import com.lumendata.common.model.Customer;

@RestController
public class ClusterKeysController {

	
	@Autowired
	private ClusterKeysService clusterKeysService;
	
	@PostMapping(value = "/clusterkeys")
	public ClusterKeys addressScore(@RequestBody Customer customer){
		
		ClusterKeys clusterKeys = clusterKeysService.getClusterKeys(customer);
		
		return clusterKeys;
	
	}
	
}