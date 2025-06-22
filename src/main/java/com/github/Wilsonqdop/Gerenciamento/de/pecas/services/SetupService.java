package com.github.Wilsonqdop.Gerenciamento.de.pecas.services;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.piecesdtos.PieceResponseDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.setupdto.RequestSetupDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.setupdto.ResponseSetupDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Setup;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.User;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories.SetupRepository;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories.UserRepository;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SetupService {
    private final SetupRepository setupRepository;
    private final UserRepository userRepository;

    public SetupService (SetupRepository setupRepository, UserRepository userRepository) {
        this.setupRepository = setupRepository;
        this.userRepository = userRepository;
    }

    public Setup findById(Long id) {
        return this.setupRepository.findById(id).orElseThrow(() -> new RuntimeException("Setup não encontrado"));
    }

    public Setup findByName (String name) {
        return this.setupRepository.findByName(name).orElseThrow(() ->
                new RuntimeException("Setup não encontrado") );
    }

    public ResponseSetupDTO createSetup (RequestSetupDTO dto, JwtAuthenticationToken token) {
        Optional<User> user = this.userRepository.findById(UUID.fromString(token.getName()));

        Setup setup = new Setup();
        setup.setUser(user.get());
        setup.setName(dto.name());

        this.setupRepository.save(setup);
        return new ResponseSetupDTO(setup.getName());

    }

    public void deleteSetup (Long id) {
        Setup setup = this.findById(id);

        this.setupRepository.delete(setup);
    }


}
