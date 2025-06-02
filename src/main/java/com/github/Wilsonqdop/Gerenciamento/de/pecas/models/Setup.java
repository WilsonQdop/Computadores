package com.github.Wilsonqdop.Gerenciamento.de.pecas.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Setup {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "setup", cascade = CascadeType.ALL)
    private List<Piece> piece;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Piece> getPiece() {
        return piece;
    }

    public void setPiece(List<Piece> piece) {
        this.piece = piece;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
