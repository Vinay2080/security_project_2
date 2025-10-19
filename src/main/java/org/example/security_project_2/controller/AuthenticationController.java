package org.example.security_project_2.controller;

import lombok.RequiredArgsConstructor;
import org.example.security_project_2.dto.request.authentication.AuthenticationRequest;
import org.example.security_project_2.dto.response.authentication.AuthenticationResponse;
import org.example.security_project_2.dto.request.authentication.RegisterRequest;
import org.example.security_project_2.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));

    }

    // todo create service layer and also mapper along with it and implement them
}
