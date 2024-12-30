package com.Wilson.Carrinho.exceptions;

import com.Wilson.Carrinho.dtos.ExceptionDTO;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity emailDuplicate (DataIntegrityViolationException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Email já cadastrado", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityActionVetoException.class)
    public ResponseEntity threat404(EntityActionVetoException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity allExceptions(Exception e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }
}
