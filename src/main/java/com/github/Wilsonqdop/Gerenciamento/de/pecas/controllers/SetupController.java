package com.github.Wilsonqdop.Gerenciamento.de.pecas.controllers;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.setupdto.RequestSetupDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.setupdto.ResponseSetupDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Setup;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.services.SetupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("setup")
public class SetupController {
    private final SetupService setupService;

    public SetupController (SetupService setupService) {
        this.setupService = setupService;
    }

    @PostMapping
    public ResponseEntity<ResponseSetupDTO> createSetup (@RequestBody RequestSetupDTO dto) {
        ResponseSetupDTO setup = this.setupService.createSetup(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(setup);
    }

    @GetMapping("name")
    public ResponseEntity<Setup> getSetupByName(@RequestParam String name) {
        Setup setup = this.setupService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(setup);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSetup (@PathVariable Long id) {
        this.setupService.deleteSetup(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
