package com.github.Wilsonqdop.Gerenciamento.de.pecas.services;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.piecesdtos.PieceRequestDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.piecesdtos.PieceResponseDTO;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Piece;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Tag;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories.PieceRepository;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PieceService {
    private final PieceRepository pieceRepository;
    private final TagRepository tagRepository;

    public PieceService (PieceRepository pieceRepository, TagRepository tagRepository) {
        this.pieceRepository = pieceRepository;
        this.tagRepository = tagRepository;
    }

    public Piece findById(Long id) {
        return this.pieceRepository.findById(id).orElseThrow(() -> new RuntimeException("Peça com id " + id +
                " não encontrada"));
    }

    public PieceResponseDTO createPiece (PieceRequestDTO dto) {
        Piece newPiece = new Piece();
        newPiece.setName(dto.name());
        newPiece.setCategory(dto.category());
        newPiece.setDescription(dto.description());
        newPiece.setPrice(dto.price());
        newPiece.setNameStore(dto.nameStore());
        newPiece.setUrl(dto.url());

        List<Tag> tags = dto.tags().stream()
                .map(tagName -> tagRepository.findByName(tagName)
                        .orElseGet(() -> tagRepository.save(new Tag(tagName))))
                .toList();

        newPiece.setTags(tags);

        Piece savedPiece = this.pieceRepository.save(newPiece);

        return new PieceResponseDTO(savedPiece.getName(), savedPiece.getCategory(), savedPiece.getDescription()
        , savedPiece.getPrice(), savedPiece.getNameStore(), savedPiece.getUrl(), savedPiece.getDateTime()
                ,savedPiece.getTags()
                .stream()
                .map(Tag::getName)
                .toList());
    }

    public PieceResponseDTO updatePiece(PieceRequestDTO dto, Long id) {
        Piece piece = this.findById(id);

        piece.setName(dto.name());
        piece.setUrl(dto.url());
        piece.setPrice(dto.price());
        piece.setDescription(dto.description());
        piece.setNameStore(dto.nameStore());
        piece.setCategory(dto.category());
        List<Tag> tags = dto.tags().stream()
                .map(tagName -> tagRepository.findByName(tagName)
                        .orElseGet(() -> tagRepository.save(new Tag(tagName))))
                .collect(Collectors.toList());

        piece.setTags(tags);

        Piece updatesPiece = this.pieceRepository.save(piece);

        return new PieceResponseDTO(updatesPiece.getName(), updatesPiece.getCategory(), updatesPiece.getDescription()
                , updatesPiece.getPrice(), updatesPiece.getNameStore(), updatesPiece.getUrl(), updatesPiece.getDateTime()
                ,updatesPiece.getTags()
                .stream()
                .map(Tag::getName)
                .toList());
    }

    public void deletePiece (Long id) {
        Piece piece = findById(id);

        this.pieceRepository.delete(piece);
    }
}
