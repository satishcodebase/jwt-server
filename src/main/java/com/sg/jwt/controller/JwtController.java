package com.sg.jwt.controller;

import com.sg.jwt.dto.JwtRequest;
import com.sg.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class JwtController {

    @Autowired
    JwtService jwtService;

    @PostMapping("/token")
    public String getToken(@RequestBody JwtRequest authRequest) {
        return jwtService.generateToken(authRequest.getUserName());
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        jwtService.validateToken(token);
        return "Token is valid";
    }

    @GetMapping("/welcome")
    public String greetings(@RequestParam("name") String name) {

        return "welcome " + name + " to JWT service";
    }
}
