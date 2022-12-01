package br.com.rodrigoeduque.pets.controller;

import br.com.rodrigoeduque.pets.model.Pet;
import br.com.rodrigoeduque.pets.repository.PetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    PetRepository repository;

    @PostMapping
    public ResponseEntity<Object> cadastrarNovo(@RequestBody @Valid PetRequest request){

        Pet pet = request.toPet();

        repository.save(pet);

        URI uri = UriComponentsBuilder.fromPath("/pets/{id}").buildAndExpand(pet.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
