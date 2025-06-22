package com.github.Wilsonqdop.Gerenciamento.de.pecas.controllers;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.login.LoginRequest;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.login.LoginResponse;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Role;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController

public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public TokenController(JwtEncoder jwtEncoder, UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/login")
    private ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest) {
        var user = this.userRepository.findByEmail(loginRequest.email());

        if (user.isEmpty() || !user.get().isLoginCorrect(loginRequest, bCryptPasswordEncoder)) {
            throw new BadCredentialsException("Email or password is invalid!");
        }

        var now  = Instant.now();
        var expiresIn = 300L;

        var scopes = user.get().getRoles().
                stream()
                .map(Role::getName)
                .collect(Collectors.joining(" "));

        System.out.println("Roles do usuário: " + user.get().getRoles());

        var claims = JwtClaimsSet.builder()
                .issuer("mybackend")
                .subject(user.get().getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("scope", scopes)
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));

    }
}
