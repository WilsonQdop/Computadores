package com.Wilson.Carrinho.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Entity
@Table(name = "tb_computer")
@AllArgsConstructor
@Getter
@Setter
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computer_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "motherboard_id")
    private Shopping motherboard;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpu_id")
    private Shopping cpu;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gpu_id")
    private Shopping gpu;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memoryRam_id")
    private Shopping memoryRam;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "powerSupply_id")
    private Shopping powerSupply;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cooler_id")
    private Shopping cooler;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_id")
    private Shopping storage;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gabinete_id")
    private Shopping gabinete;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Computer(Shopping motherboard, Shopping cpu, Shopping gpu, Shopping memoryRam, Shopping powerSupply, Shopping cooler, Shopping storage, Shopping gabinete) {
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.gpu = gpu;
        this.memoryRam = memoryRam;
        this.powerSupply = powerSupply;
        this.cooler = cooler;
        this.storage = storage;
        this.gabinete =gabinete;
    }
    public Computer() {}

   
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
