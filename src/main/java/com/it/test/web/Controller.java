package com.it.test.web;

import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private RuntimeService runtimeService;

    public Controller(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @GetMapping("/demarrer")
    public ResponseEntity<String> demarrer() {
        return ResponseEntity.ok().body("Le process a démarré");
    }

    @GetMapping("/notification")
    public ResponseEntity<String> envoyerNotification(@RequestParam(name = "email") String email) {
        runtimeService.startProcessInstanceByKey("recruitmentProcess",
                Map.of("sendNotification", true, "candidateEmail", email));
        return ResponseEntity.ok().body("Notification envoyée à " + email);
    }
}
