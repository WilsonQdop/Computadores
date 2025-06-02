package com.github.Wilsonqdop.Gerenciamento.de.pecas.repositories;

import com.github.Wilsonqdop.Gerenciamento.de.pecas.models.Piece;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PieceRepository extends JpaRepository<Piece, Long> {
}
