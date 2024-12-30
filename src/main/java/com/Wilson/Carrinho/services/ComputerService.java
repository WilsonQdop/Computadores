package com.Wilson.Carrinho.services;

import com.Wilson.Carrinho.entity.Computer;
import com.Wilson.Carrinho.entity.User;
import com.Wilson.Carrinho.interfaces.ComputerInterface;
import com.Wilson.Carrinho.repositories.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ComputerService implements ComputerInterface {

    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private UserService userService;

    @Override
    public Computer findById(Long id) throws Exception{
        Optional<Computer> computer = this.computerRepository.findById(id);
        if (computer.isPresent()) {
            return computer.get();
        } else {
            throw new Exception("Computador com o id: " + id + " não registrado!");
        }
    }
    @Override
    public Computer adicionar(Computer computer) throws Exception{
       User user = this.userService.findById(computer.getUser().getUserId());

       computer.setComputer_id(null);
       computer.setUser(user);

       computer = this.computerRepository.save(computer);
       return computer;
    }

    @Override
    public void deletar(Long id) throws Exception{
       if(!this.computerRepository.existsById(id)) {
           throw new Exception("Computador com ID " + id + " não encontrado.");
       }
           try {
               this.computerRepository.deleteById(id);
           } catch (Exception e) {
               throw new Exception("Erro ao tentar deletar o computador: " + e.getMessage());
           }
       }

    @Override
    public Computer update(Computer computer) throws Exception {
       Computer newUpdate = findById(computer.getComputer_id());

       newUpdate.setMotherboard(computer.getMotherboard());
       newUpdate.setCpu(computer.getCpu());
       newUpdate.setGabinete(computer.getGabinete());
       newUpdate.setGpu(computer.getGpu());
       newUpdate.setMemoryRam(computer.getMemoryRam());
       newUpdate.setCooler(computer.getCooler());
       newUpdate.setPowerSupply(computer.getPowerSupply());
       newUpdate.setStorage(computer.getStorage());

       return this.computerRepository.save(newUpdate);



    }
}
