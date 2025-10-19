package org.example.security_project_2.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.security_project_2.configuration.JwtServices;
import org.example.security_project_2.dto.request.authentication.AuthenticationRequest;
import org.example.security_project_2.dto.request.authentication.RegisterRequest;
import org.example.security_project_2.dto.response.authentication.AuthenticationResponse;
import org.example.security_project_2.mapper.RegisterRequestMapper;
import org.example.security_project_2.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RegisterRequestMapper registerRequestMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtServices jwtServices;
    private final AuthenticationManager authenticationManager;


    @Transactional
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var appUser = registerRequestMapper.registerRequestToUser(registerRequest);
        appUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(appUser);

        var jwtToken = jwtServices.generateToken(appUser);

        return new AuthenticationResponse(jwtToken);

    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var appUser = userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow(()-> new UsernameNotFoundException("email not found enter a valid email"));

        var jwtToken = jwtServices.generateToken(appUser);
        return new AuthenticationResponse(jwtToken);
    }
}
