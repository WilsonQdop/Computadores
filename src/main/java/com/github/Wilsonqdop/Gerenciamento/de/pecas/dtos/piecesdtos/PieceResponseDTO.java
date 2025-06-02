package com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.piecesdtos;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.enums.PieceCategory;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Tag;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PieceResponseDTO (String name, PieceCategory category, String description, BigDecimal price
        , String nameStore, String url, LocalDateTime dateTime, List<String> tags) {
}
