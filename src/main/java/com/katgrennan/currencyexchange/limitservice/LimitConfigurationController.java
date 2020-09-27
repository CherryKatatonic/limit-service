package com.katgrennan.currencyexchange.limitservice;

import com.katgrennan.currencyexchange.limitservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

    // Import properties from Cloud Config Server through Configuration component
    @Autowired
    Configuration configuration;

    // GET endpoint to get instance limits
    @GetMapping("/limits")
    @HystrixCommand(fallbackMethod = "fallbackGetLimitsFromConfig")
    public LimitConfiguration getLimitsFromConfig() {
        LimitConfiguration config = new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
        if (config.getMaximum() == 0) {
            throw new RuntimeException("LimitService: Spring Cloud Config unavailable - Falling back on default limits");
        }
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

    public LimitConfiguration fallbackGetLimitsFromConfig() {
        return new LimitConfiguration(1, 999);
    }

}
