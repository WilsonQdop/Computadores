package com.github.Wilsonqdop.Gerenciamento.de.pecas.services;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.piecesdtos.PieceResponseDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.setupdto.RequestSetupDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.setupdto.ResponseSetupDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Setup;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories.SetupRepository;
import org.springframework.stereotype.Service;

@Service
public class SetupService {
    private final SetupRepository setupRepository;

    public SetupService (SetupRepository setupRepository) {
        this.setupRepository = setupRepository;
    }

    public Setup findById(Long id) {
        return this.setupRepository.findById(id).orElseThrow(() -> new RuntimeException("Setup não encontrado"));
    }

    public Setup findByName (String name) {
        return this.setupRepository.findByName(name).orElseThrow(() ->
                new RuntimeException("Setup não encontrado") );
    }

    public ResponseSetupDTO createSetup (RequestSetupDTO dto) {
        Setup setup = new Setup();

        setup.setName(dto.name());

        this.setupRepository.save(setup);
        return new ResponseSetupDTO(setup.getName());

    }

    public void deleteSetup (Long id) {
        Setup setup = this.findById(id);

        this.setupRepository.delete(setup);
    }


}
