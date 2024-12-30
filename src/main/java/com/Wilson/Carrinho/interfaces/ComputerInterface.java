package com.Wilson.Carrinho.interfaces;

import com.Wilson.Carrinho.entity.Computer;

public interface ComputerInterface {
    public Computer findById(Long id) throws Exception;

    public Computer adicionar(Computer computer) throws Exception;

    public void deletar(Long id) throws Exception;

    public Computer update(Computer computer) throws Exception;
}
