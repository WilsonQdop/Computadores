package com.github.Wilsonqdop.Gerenciamento.de.pecas.controllers;


import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.userdtos.CreateUserDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.enums.RoleValues;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Role;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.User;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories.RoleRepository;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, RoleRepository roleRepository,
                          BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @PostMapping("/create")
    public ResponseEntity<Void> createUser (@RequestBody CreateUserDTO createUserDTO) {

        Role basicRole = this.roleRepository.findByName(RoleValues.BASIC.name());
        Optional<User> userEmailFromDb = userRepository.findByEmail(createUserDTO.email());

        if(userEmailFromDb.isPresent()) {
            throw  new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        
        User newUser = new User();
        newUser.setName(createUserDTO.name());
        newUser.setEmail(createUserDTO.email());
        newUser.setPassword(passwordEncoder.encode(createUserDTO.password()));
        newUser.setRoles(Set.of(basicRole));

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<List<User>> listUsers() {
        var listUsers = this.userRepository.findAll();

        return ResponseEntity.status(HttpStatus.CREATED).body(listUsers);
    }
}
