package com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);
}
