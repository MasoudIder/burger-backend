package main.service.implementations;

import main.domain.Ingredient;
import main.domain.repository.IngredientRepository;
import main.service.IngredientService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IngredientServiceImp implements IngredientService {

    private IngredientRepository repository;

    public IngredientServiceImp(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Ingredient> first() {
        return repository.findById(1);
    }

    @Override
    public void save(Ingredient ingredient) {
        repository.save(ingredient);
    }
}
