package com.github.Wilsonqdop.Gerenciamento.de.pecas.cofig;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Role;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createRoleIfNotExists("ADMIN");
        createRoleIfNotExists("BASIC");
    }

    private void createRoleIfNotExists(String roleName) {
        if (!roleRepository.existsByName(roleName)) {
            Role role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
        }
    }
}

