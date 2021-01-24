package main.controller.reactHook;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface Repository extends CrudRepository<HookIngredient, Integer> {
    Optional<HookIngredient> findByTitle(String title);

    HookIngredient save(HookIngredient ingredient);
}
