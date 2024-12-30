package com.Wilson.Carrinho.interfaces;

import com.Wilson.Carrinho.dtos.UserDTO;
import com.Wilson.Carrinho.entity.User;

import java.util.List;

public interface UserInterface {
    public User findById(Long id) throws Exception;

    public User createUser(UserDTO userDTO);

    public List<User> findAll();

}
