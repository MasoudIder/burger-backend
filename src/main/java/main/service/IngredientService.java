package main.service;

import main.domain.Ingredient;

import java.util.Optional;

public interface IngredientService {
    public Optional<Ingredient> first();

    public void save(Ingredient ingredient);
}
