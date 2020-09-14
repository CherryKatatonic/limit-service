package com.katgrennan.currencyexchange.limitservice;

import com.katgrennan.currencyexchange.limitservice.bean.LimitConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

    @GetMapping("/limits")
    public LimitConfiguration getLimitsFromConfig() {
        return new LimitConfiguration(1000, 1);
    }

}
