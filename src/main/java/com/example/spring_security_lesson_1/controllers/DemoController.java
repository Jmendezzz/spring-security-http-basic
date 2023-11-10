package com.example.spring_security_lesson_1.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping("/hello")
  public String hello() {
    Authentication user = SecurityContextHolder.getContext().getAuthentication();
    System.out.println(user.getDetails());
    user.getAuthorities().forEach(System.out::println);

    return "Hello World!";
  }

}
