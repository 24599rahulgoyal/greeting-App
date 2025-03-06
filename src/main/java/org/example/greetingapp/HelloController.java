package org.example.greetingapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
