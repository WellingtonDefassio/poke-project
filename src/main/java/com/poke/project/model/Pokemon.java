package com.poke.project.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Raridade rarity;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pokemon_types", joinColumns = @JoinColumn(name = "pokemon_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
    private List<Type> types;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Raridade getRarity() {
        return rarity;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public void setRarity(Raridade rarity) {
        this.rarity = rarity;
    }
}
