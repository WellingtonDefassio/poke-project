package com.poke.project.controller;

import com.poke.project.dto.PokemonDTO;
import com.poke.project.model.Pokemon;
import com.poke.project.repository.PokemonRepository;
import com.poke.project.repository.TypeRepository;
import com.poke.project.service.PokemonDraw;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    PokemonRepository pokemonRepository;
    TypeRepository typeRepository;

    PokemonDraw pokemonDraw;

    public PokemonController(PokemonRepository pokemonRepository, TypeRepository typeRepository, PokemonDraw pokemonDraw) {
        this.pokemonRepository = pokemonRepository;
        this.typeRepository = typeRepository;
        this.pokemonDraw = pokemonDraw;
    }

    @PostMapping()
    public ResponseEntity createPokemon(@RequestBody PokemonDTO pokemonDTO) {

        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDTO.getName());
        pokemon.setRarity(pokemonDTO.getRarity());
        pokemonRepository.save(pokemon);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity getList() {

        List<Pokemon> pokemonList = this.pokemonRepository.findAll();

        return new ResponseEntity(pokemonList, HttpStatus.OK);

    }

    @GetMapping("{id}")
    public ResponseEntity getByName(@PathVariable Long id) {

        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);

        if(!optionalPokemon.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(optionalPokemon.get(), HttpStatus.OK);

    }

  @GetMapping("sortear")
    public ResponseEntity getSorteio() {

      Pokemon pokemon = this.pokemonDraw.basicDrawPokemon();

      return new ResponseEntity(pokemon, HttpStatus.OK);
  }


}
