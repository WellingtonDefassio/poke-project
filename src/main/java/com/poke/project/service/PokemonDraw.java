package com.poke.project.service;

import com.poke.project.model.Pokemon;
import com.poke.project.model.Raridade;
import com.poke.project.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonDraw {


    PokemonRepository pokemonRepository;


    public PokemonDraw(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon basicDrawPokemon() {

        double random = Math.random() * 100;
        System.out.println(random);

        if(random<70) {

            List<Pokemon> pokemonList = pokemonRepository.findAllByRarity(Raridade.NORMAL);

            int index = (int)(Math.random() * pokemonList.size());

            return pokemonList.get(index);

        }

       else if(random<90) {

            List<Pokemon> pokemonList = pokemonRepository.findAllByRarity(Raridade.RARE);

            int index = (int)(Math.random() * pokemonList.size());

            return pokemonList.get(index);

        }    else if(random<98) {

            List<Pokemon> pokemonList = pokemonRepository.findAllByRarity(Raridade.EPIC);

            int index = (int)(Math.random() * pokemonList.size());

            return pokemonList.get(index);

        }else if(random<100) {

            List<Pokemon> pokemonList = pokemonRepository.findAllByRarity(Raridade.LEGENDARY);

            int index = (int)(Math.random() * pokemonList.size());

            return pokemonList.get(index);

        }
        System.out.println("não deveria chegar");
        return new Pokemon();
    }

}
