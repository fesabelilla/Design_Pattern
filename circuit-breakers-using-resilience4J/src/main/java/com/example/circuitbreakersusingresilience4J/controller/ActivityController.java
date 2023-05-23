package com.example.circuitbreakersusingresilience4J.controller;

import com.example.circuitbreakersusingresilience4J.model.Activity;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
Resilience4j : https://resilience4j.readme.io/docs/circuitbreaker
Tutorial : https://www.youtube.com/watch?v=3-ChrD3Zosg
For Health Check : http://localhost:8080/actuator/health
 */


@RestController
@RequestMapping("/activity")
public class ActivityController {

    private RestTemplate restTemplate;
    private final String BORED_API = "https://www.boredapi.com/api/activity";

    public ActivityController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    @CircuitBreaker(name = "randomActivity", fallbackMethod = "fallbackRandomActivity")
    public String getRandomActivity() {
        ResponseEntity<Activity> responseEntity = restTemplate.getForEntity(BORED_API, Activity.class);
        Activity activity = responseEntity.getBody();

        System.out.println("Activity Received: " + activity.getActivity());
        return activity.getActivity();
    }

    public String fallbackRandomActivity(Throwable throwable) {
        return "Fallback Random Activity";
    }
}
