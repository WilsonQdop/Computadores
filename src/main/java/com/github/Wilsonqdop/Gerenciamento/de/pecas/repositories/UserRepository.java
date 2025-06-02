package com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
