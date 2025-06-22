package com.github.Wilsonqdop.Gerenciamento.de.pecas.cofig;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.enums.RoleValues;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Role;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.User;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories.RoleRepository;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminUserConfig(RoleRepository roleRepository, UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Role roleAdmin = roleRepository.findByName(RoleValues.ADMIN.name());

        var userAdmin = userRepository.findByEmail("admin");

        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setEmail("Admin@Admin.com");
            admin.setName("admin");
            admin.setPassword(bCryptPasswordEncoder.encode("123"));
            admin.getRoles().add(roleAdmin);

            userRepository.save(admin);
            System.out.println("Usuário admin criado com sucesso!");
        } else {
            System.out.println("Usuários já cadastrados. Nenhuma ação realizada.");
        }
    }
}
