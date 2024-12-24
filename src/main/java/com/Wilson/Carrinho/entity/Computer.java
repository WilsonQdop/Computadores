package com.Wilson.Carrinho.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "tb_computer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computer_id;

    private String motherboard;
    private String cpu;
    private String gpu;
    private String memoryRam;
    private String powerSupply;
    private String cooler;
    private String gabinete;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Long getComputer_id() {
        return computer_id;
    }

//    public Computer(Shopping motherboard) {
//        this.motherboard = motherboard;
//    }

    public void setComputer_id(Long computer_id) {
        this.computer_id = computer_id;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMemoryRam() {
        return memoryRam;
    }

    public void setMemoryRam(String memoryRam) {
        this.memoryRam = memoryRam;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public String getCooler() {
        return cooler;
    }

    public void setCooler(String cooler) {
        this.cooler = cooler;
    }

    public String getGabinete() {
        return gabinete;
    }

    public void setGabinete(String gabinete) {
        this.gabinete = gabinete;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Computer computer = (Computer) object;
        return Objects.equals(computer_id, computer.computer_id) && Objects.equals(motherboard, computer.motherboard) && Objects.equals(cpu, computer.cpu) && Objects.equals(gpu, computer.gpu) && Objects.equals(memoryRam, computer.memoryRam) && Objects.equals(powerSupply, computer.powerSupply) && Objects.equals(cooler, computer.cooler) && Objects.equals(gabinete, computer.gabinete) && Objects.equals(user, computer.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(computer_id, motherboard, cpu, gpu, memoryRam, powerSupply, cooler, gabinete, user);
    }
}
