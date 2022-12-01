package br.com.rodrigoeduque.pets.controller;

import br.com.rodrigoeduque.pets.model.Pet;
import br.com.rodrigoeduque.pets.model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class PetRequest {

    @NotBlank
    private String nome;

    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;

    @NotNull
    private Tipo tipo;

    @NotBlank
    private String raca;

    public PetRequest(String nome, LocalDate dataNascimento, Tipo tipo, String raca) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
        this.raca = raca;
    }

    public PetRequest() {
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getRaca() {
        return raca;
    }

    public Pet toPet() {
        return new Pet(nome, dataNascimento, tipo, raca);
    }
}
