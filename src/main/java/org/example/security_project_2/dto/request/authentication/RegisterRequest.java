package org.example.security_project_2.dto.request.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.security_project_2.model.AppUser}
 */
@Value
@Builder
@AllArgsConstructor

public class RegisterRequest implements Serializable {
    String firstname;
    String lastname;
    String email;
    String password;
}