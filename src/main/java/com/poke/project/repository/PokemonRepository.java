package com.poke.project.repository;

import com.poke.project.model.Pokemon;
import com.poke.project.model.Raridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findAllByRarity(Raridade raridade);

}
