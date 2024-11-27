package org.ocbc.testgitproject.controller;

import org.ocbc.testgitproject.DTO.Employee;
import org.ocbc.testgitproject.DTO.User1;
import org.ocbc.testgitproject.DTO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    @PostMapping("/create")
    public String sayHello(@RequestBody Employee employee) {

        RestTemplate restTemplate = new RestTemplate();

        String name = restTemplate.getForObject("http://localhost:8080/hello1", String.class);
        System.out.println(String.format("Hello %s!", name));
        return String.format("Hello %s!",employee.getName());
    }
    @PostMapping("/createuser")
    public User1 createUser(@RequestBody User1 user) {

        return userRepository.save(user);
    }
}

