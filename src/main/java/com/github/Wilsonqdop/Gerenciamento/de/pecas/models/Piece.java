package com.github.Wilsonqdop.Gerenciamento.de.pecas.models;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.enums.PieceCategory;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Piece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private PieceCategory category;
    private String description;
    private String url;
    private BigDecimal price;
    private String nameStore;
    private final LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne @JoinColumn(name = "setup_id")
    private Setup setup;

    @ManyToMany
    @JoinTable(
            name = "piece_tags",
            joinColumns = @JoinColumn(name = "piece_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

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

    public PieceCategory getCategory() {
        return category;
    }

    public void setCategory(PieceCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Setup getSetup() {
        return setup;
    }

    public void setSetup(Setup setup) {
        this.setup = setup;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
