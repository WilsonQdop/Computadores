package com.github.Wilsonqdop.Gerenciamento.de.pecas.models;

import jakarta.persistence.*;

@Entity
public class AuthCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String role;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
