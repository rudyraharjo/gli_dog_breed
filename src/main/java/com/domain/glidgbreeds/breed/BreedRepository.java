package com.domain.glidgbreeds.breed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BreedRepository extends
        CrudRepository<Breed, Long> {

    @Query("SELECT b FROM Breed b WHERE b.name = ?1")
    Optional<Breed> findBreedByName(String name);
}
