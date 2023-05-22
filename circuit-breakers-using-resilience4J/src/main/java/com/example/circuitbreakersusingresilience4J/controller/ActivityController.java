package com.example.circuitbreakersusingresilience4J.controller;

import com.example.circuitbreakersusingresilience4J.model.Activity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    private RestTemplate restTemplate;
    private final String BORED_API = "https://www.boredapi.com/api/activity";

    public ActivityController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String getRandomActivity() {
        ResponseEntity<Activity> responseEntity = restTemplate.getForEntity(BORED_API, Activity.class);
        Activity activity = responseEntity.getBody();

        System.out.println("Activity Received: " + activity.getActivity());
        return activity.getActivity();
    }
}
