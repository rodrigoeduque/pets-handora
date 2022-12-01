package br.com.rodrigoeduque.pets.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private Tipo tipo;

    @Column(nullable = false)
    private String raca;

    public Pet(String nome, LocalDate dataNascimento, Tipo tipo, String raca) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
        this.raca = raca;
    }

    @Deprecated
    public Pet() {
    }

    public Long getId() {
        return id;
    }
}
