package org.example.security_project_2.dto.response.authentication;

import lombok.Value;

import java.io.Serializable;


@Value
public class AuthenticationResponse implements Serializable {
    String token;
}