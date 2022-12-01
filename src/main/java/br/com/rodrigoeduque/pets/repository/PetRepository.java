package br.com.rodrigoeduque.pets.repository;

import br.com.rodrigoeduque.pets.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
