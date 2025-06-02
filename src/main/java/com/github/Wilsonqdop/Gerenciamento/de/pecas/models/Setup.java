package com.github.Wilsonqdop.Gerenciamento.de.pecas.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Setup {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "setup", cascade = CascadeType.ALL)
    private List<Piece> piece;

    @ManyToOne
    private User user;

}
