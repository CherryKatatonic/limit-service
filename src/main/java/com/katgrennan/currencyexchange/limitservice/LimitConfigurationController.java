package com.katgrennan.currencyexchange.limitservice;

import com.katgrennan.currencyexchange.limitservice.bean.LimitConfiguration;
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
    public LimitConfiguration getLimitsFromConfig() {
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

}
