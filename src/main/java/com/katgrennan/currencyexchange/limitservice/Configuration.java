package com.katgrennan.currencyexchange.limitservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// Declare Component for Autowiring in LimitConfigurationController
@Component
// Define prefix of properties to extract from .properties file
@ConfigurationProperties("limit-service")
public class Configuration {

    // Minimum/maximum # of instances running
    private int minimum;
    private int maximum;

    // Getters & Setters required for application properties
    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
