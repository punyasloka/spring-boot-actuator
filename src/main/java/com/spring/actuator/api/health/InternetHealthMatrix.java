package com.spring.actuator.api.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

@Component
public class InternetHealthMatrix implements HealthIndicator  {


    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        Health health = null;
        HashMap<String, String> healthUpMap = new HashMap<>();
        healthUpMap.put("Success Code", "Active Internet Connection");
        HashMap<String, String> healthDownMap = new HashMap<>();
        healthDownMap.put("Failure Code", "No Active Internet Connection");
        health =checkInternet() == true ? Health.up().withDetails(healthUpMap).build() : Health.down().withDetails(healthDownMap).build();
        return health;
    }

    private boolean checkInternet() {
        boolean flag = false;
        try {
            URL url = new URL("https://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
