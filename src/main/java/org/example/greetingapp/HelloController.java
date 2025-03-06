package org.example.greetingapp;

import org.example.greetingapp.Model.Greeting;
import org.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    // UC1: Say "Hello World"
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    // UC2: Say Hello with Name as Query Parameter
    @GetMapping("/hello/query")
    public String sayHelloQuery(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    // 3. Say Hello with Name in Path Variable

    @GetMapping("/hello/param/{name}")
    public String sayHelloPath(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // 4
    @Autowired
    private GreetingRepository greetingRepository;

    @PostMapping("/greeting")
    public String generateGreeting(@RequestBody Greeting greeting) {
        String message;

        if (greeting.getFirstName() != null && greeting.getLastName() != null) {
            message = "Hello, " + greeting.getFirstName() + " " + greeting.getLastName() + "!";
        } else if (greeting.getFirstName() != null) {
            message = "Hello, " + greeting.getFirstName() + "!";
        } else if (greeting.getLastName() != null) {
            message = "Hello, " + greeting.getLastName() + "!";
        } else {
            message = "Hello, World!";
        }

        greeting.setMessage(message);
        greetingRepository.save(greeting);
        return message;
    }

    @GetMapping("/greeting/{id}")
    public Greeting getGreeting(@PathVariable Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

// UC6 getting all the greeting
    @GetMapping("/greeting")
    public List<Greeting> getGreetings() {
        return greetingRepository.findAll();
    }


}
