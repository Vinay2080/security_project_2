package org.example.security_project_2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/demo")
@RequiredArgsConstructor
@RestController

public class Hello {


    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello world");
    }
}
