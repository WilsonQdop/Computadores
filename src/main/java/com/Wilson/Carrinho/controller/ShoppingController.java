package com.Wilson.Carrinho.controller;

import com.Wilson.Carrinho.entity.Shopping;
import com.Wilson.Carrinho.repositories.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
    @Autowired
    private ShoppingRepository shoppingRepository;

    @PostMapping
    public ResponseEntity<Shopping> createShopping(@RequestBody Shopping shopping) {
        Shopping savedShopping = shoppingRepository.save(shopping);
        return ResponseEntity.ok(savedShopping);
    }

}
