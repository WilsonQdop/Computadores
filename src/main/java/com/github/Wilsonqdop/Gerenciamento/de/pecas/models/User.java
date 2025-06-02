package com.github.Wilsonqdop.Gerenciamento.de.pecas.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Setup> setups;

    @OneToOne(mappedBy = "user")
    private AuthCredential credential;

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

    public List<Setup> getSetups() {
        return setups;
    }

    public void setSetups(List<Setup> setups) {
        this.setups = setups;
    }
}
