package com.Wilson.Carrinho.services;

import com.Wilson.Carrinho.entity.Computer;
import com.Wilson.Carrinho.entity.User;
import com.Wilson.Carrinho.repositories.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private UserService userService;

    public Computer findById(Long id) {
        Optional<Computer> computer = this.computerRepository.findById(id);
        if (computer.isPresent()) {
            return computer.get();
        } else {
            throw new RuntimeException("Computador não registrado!");
        }
    }

    public Computer adicionar(Computer computer) {
       User user = this.userService.findById(computer.getUser().getUserId());

       computer.setComputer_id(null);
       computer.setUser(user);

       computer = this.computerRepository.save(computer);
       return computer;
    }

    public void deletar(Long id) {
       if(!this.computerRepository.existsById(id)) {
           throw new RuntimeException("Computador com ID " + id + " não encontrado.");
       }
           try {
               this.computerRepository.deleteById(id);
           } catch (Exception e) {
               throw new RuntimeException("Erro ao tentar deletar o computador: " + e.getMessage());
           }
       }

    public Computer update(Computer computer) {
       Computer newUpdate = findById(computer.getComputer_id());

       newUpdate.setMotherboard(computer.getMotherboard());
       newUpdate.setCpu(computer.getCpu());
       newUpdate.setGabinete(computer.getGabinete());
       newUpdate.setGpu(computer.getGpu());
       newUpdate.setMemoryRam(computer.getMemoryRam());
       newUpdate.setCooler(computer.getCooler());
       newUpdate.setPowerSupply(computer.getPowerSupply());

       return this.computerRepository.save(newUpdate);



    }
}
