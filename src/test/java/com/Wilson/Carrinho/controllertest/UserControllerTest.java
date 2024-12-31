package com.Wilson.Carrinho.controllertest;

import com.Wilson.Carrinho.controller.UserController;
import com.Wilson.Carrinho.entity.User;
import com.Wilson.Carrinho.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserController userController;

    @MockBean
    UserRepository userRepository;

    @Test
    void findAll() {
        List<User> users = new ArrayList<>();

        users.add(new User(1L, "Wilson", "123", "Wilson.test@gmail.com"));
        users.add(new User(2L, "Vilson", "123", "Vicente.test@gmail.com"));

        when(this.userRepository.findAll()).thenReturn(users);

        ResponseEntity<List<User>> retorno = this.userController.findAllUsers();
        assertEquals(HttpStatus.OK, retorno.getStatusCode());
        assertEquals(2, retorno.getBody().size());
    }
}
