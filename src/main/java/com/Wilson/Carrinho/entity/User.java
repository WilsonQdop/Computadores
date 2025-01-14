package com.Wilson.Carrinho.entity;

import com.Wilson.Carrinho.dtos.UserDTO;
import com.Wilson.Carrinho.enums.Profiles;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "name")
    @NotBlank(message = "Nome está vazio")
    private String name;
    @Column(name = "password" )
    @NotBlank(message =  "Senha está vazio")
    private String password;
    @Column(name = "email", unique = true )
    @NotBlank(message = "Email está vazio")
    private String email;

    @OneToMany(orphanRemoval = true, mappedBy = "user")
    @JsonManagedReference
    private List<Computer> computerList = new ArrayList<Computer>();

    public User() {}

    public User(String name, String password, String email) {

        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(UserDTO userDTO) {
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = userDTO.password();
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @CollectionTable(name = "user_profile")
    private Set<Integer> profiles = new HashSet<>();

    public Set<Profiles> getProfiles() {
        return this.profiles.stream().map(Profiles::returnRole).collect(Collectors.toSet());
    }

    public void addProfile(Profiles profiles) {
        this.profiles.add(profiles.getCode());
    }


}
