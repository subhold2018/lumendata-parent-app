package com.lumendata.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeetu
 */
@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public String healthCheck(){
        return "Success";
    }
}
