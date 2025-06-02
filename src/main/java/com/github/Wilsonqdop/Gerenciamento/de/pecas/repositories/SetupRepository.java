package com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Setup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SetupRepository extends JpaRepository<Setup, Long> {

    Optional<Setup> findByName(String name);
}
