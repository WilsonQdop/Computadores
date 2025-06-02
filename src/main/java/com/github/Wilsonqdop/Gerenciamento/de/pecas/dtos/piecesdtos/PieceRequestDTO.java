package com.github.Wilsonqdop.Gerenciamento.de.pecas.dtos.piecesdtos;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.enums.PieceCategory;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Piece;
import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Tag;

import java.math.BigDecimal;
import java.util.List;

public record PieceRequestDTO (String name, PieceCategory category, String description, BigDecimal price
        , String nameStore, String url, List<String> tags){
}
