package com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Role;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

    boolean existsByName(String roleName);
}
