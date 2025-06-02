package com.github.Wilsonqdop.Gerenciamento.de.pecas.controllers;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.piecesdtos.PieceRequestDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.piecesdtos.PieceResponseDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.services.PieceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("piece")
public class PieceController {
    private final PieceService pieceService;

    public PieceController (PieceService pieceService) {
        this.pieceService = pieceService;
    }

    @PostMapping
    public ResponseEntity<PieceResponseDTO> createPiece (@RequestBody PieceRequestDTO dto) {
        PieceResponseDTO newPiece = this.pieceService.createPiece(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPiece);
    }

    @PutMapping("{id}")
    public ResponseEntity<PieceResponseDTO> updatePiece (@RequestBody PieceRequestDTO dto, @PathVariable Long id) {
        PieceResponseDTO update = this.pieceService.updatePiece(dto, id);

        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePiecee (@PathVariable Long id) {
        this.pieceService.deletePiece(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
