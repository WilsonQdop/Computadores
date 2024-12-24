package com.Wilson.Carrinho.services;

import com.Wilson.Carrinho.dtos.UserDTO;
import com.Wilson.Carrinho.entity.User;
import com.Wilson.Carrinho.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDTO) {
        User user = new User(userDTO);
        this.userRepository.save(user);
        return user;
    }

    public User findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            throw  new RuntimeException("Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName());
        }
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }


}
