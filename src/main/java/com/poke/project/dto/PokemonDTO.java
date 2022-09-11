package com.poke.project.dto;

import com.poke.project.model.Raridade;

public class PokemonDTO {

    public String name;

    public Raridade rarity;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Raridade getRarity() {
        return rarity;
    }

    public void setRarity(Raridade rarity) {
        this.rarity = rarity;
    }
}
