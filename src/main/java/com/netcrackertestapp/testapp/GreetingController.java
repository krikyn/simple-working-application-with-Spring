package com.netcrackertestapp.testapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String greeting(Map<String, Object> model) {
        Iterable<People> users = userRepository.findAll();

        model.put("users", users);

        return "test";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<People> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {

        People n = new People();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

}