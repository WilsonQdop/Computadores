package com.Wilson.Carrinho.controller;

import com.Wilson.Carrinho.entity.Computer;
import com.Wilson.Carrinho.services.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping("/{id}")
    public ResponseEntity<Computer> findById(@PathVariable  Long id) throws Exception {
            Computer computer = this.computerService.findById(id);
            return ResponseEntity.ok(computer);
    }

    @PostMapping
    public ResponseEntity<Void> adicionarComputer(@RequestBody Computer computer) throws Exception {
        this.computerService.adicionar(computer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(computer.getComputer_id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComoputador(@PathVariable Long id) throws Exception {
        this.computerService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarComputador(@PathVariable Long id, @RequestBody Computer computer) throws Exception {
        computer.setComputer_id(id);
        this.computerService.update(computer);
        return ResponseEntity.ok().build();
    }

}
