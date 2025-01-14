package com.Wilson.Carrinho.servicetest;


import com.Wilson.Carrinho.entity.User;
import com.Wilson.Carrinho.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void findById() {
        //User user = new User(1L, "Wilson", "123", "wilson.alt@f4.com");
        //User user1 = new User(2L, "Vilson", "123", "Vilson.alt@f4.com");

        List<User> users = new ArrayList<>();
       // users.add(user);
       // users.add(user1);

        List<User> resp = this.userService.findAll();
        assertEquals(users.size(), resp.size());

    }

}
