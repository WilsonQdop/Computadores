package com.Wilson.Carrinho.services;

import com.Wilson.Carrinho.dtos.UserDTO;
import com.Wilson.Carrinho.entity.User;
import com.Wilson.Carrinho.enums.Profiles;
import com.Wilson.Carrinho.interfaces.UserInterface;
import com.Wilson.Carrinho.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements UserInterface {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserDTO userDTO) throws Exception {

        if(userDTO == null) {
            throw new IllegalArgumentException("Algum dado nulo");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(userDTO.password());

        User user = new User(userDTO.name(), encodedPassword, userDTO.email());

        user.setProfiles(Stream.of(Profiles.USER.getCode()).collect(Collectors.toSet()));


        this.userRepository.save(user);
        return user;
    }

    public void update(User user) throws Exception {
        User newUser = findById(user.getUserId());

        newUser.setName(user.getName()); newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        String encodedPassowrd = bCryptPasswordEncoder.encode(user.getPassword());

        this.userRepository.save(newUser);


    }

    @Override
    public User findById(Long id) throws Exception{
        Optional<User> user = this.userRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw  new Exception("Usuário não encontrado! Id: " + id);
        }
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }


}
