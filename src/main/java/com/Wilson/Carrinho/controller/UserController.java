package com.Wilson.Carrinho.controller;

import com.Wilson.Carrinho.dtos.UserDTO;
import com.Wilson.Carrinho.entity.User;
import com.Wilson.Carrinho.services.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) throws Exception {
       User newUser = this.userService.createUser(userDTO);
        return new ResponseEntity<> (newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) throws Exception{
        User user = this.userService.findById(id);
       return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        try {
            List<User> findAll = this.userService.findAll();
            return ResponseEntity.ok().body(findAll);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
}
