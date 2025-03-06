package com.example.greetingApp.controller;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // UC1 - Basic GET Request
    @GetMapping
    public Map<String, String> getGreeting() {
        return Map.of("message", "Hello, this is a GET request!");
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> request) {
        return Map.of("message", "Hello, this is a POST request!", "received", request.get("name"));
    }

    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> request) {
        return Map.of("message", "Hello, this is a PUT request!", "updated", request.get("name"));
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        return Map.of("message", "Hello, this is a DELETE request!");
    }

    // UC2 - Simple Greeting
    @GetMapping("/simple")
    public Map<String, String> getSimpleGreeting() {
        return Map.of("message", greetingService.getSimpleGreeting());
    }

    // UC3 - Personalized Greeting
    @GetMapping("/personalized")
    public Map<String, String> getPersonalizedGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return Map.of("message", greetingService.getPersonalizedGreeting(firstName, lastName));
    }

    // UC4 - Save a Greeting
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Map<String, String> request) {
        return greetingService.saveGreeting(request.get("message"));
    }

    // UC4 - Get all saved greetings
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // UC4 - Get a specific greeting by ID
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // UC5 - Get Greeting Message by ID
    @GetMapping("/message/{id}")
    public Map<String, String> getGreetingMessageById(@PathVariable Long id) {
        return Map.of("message", greetingService.findGreetingMessageById(id));
    }
    // UC6 - Get all greeting messages (Only messages, not full objects)
    @GetMapping("/messages")
    public List<String> getAllGreetingMessages() {
        return greetingService.getAllGreetingMessages();
    }
    // UC7 - Update a greeting message by ID
    @PutMapping("/update/{id}")
    public Optional<Greeting> updateGreeting(@PathVariable Long id, @RequestBody Map<String, String> request) {
        return greetingService.updateGreeting(id, request.get("message"));
    }
    // UC8 - Delete a greeting message by ID
    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteGreeting(@PathVariable Long id) {
        boolean isDeleted = greetingService.deleteGreeting(id);
        if (isDeleted) {
            return Map.of("message", "Greeting deleted successfully!");
        } else {
            return Map.of("error", "Greeting not found!");
        }
    }



}
