package main.controller.reactHook;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class Controller {

    private Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @CrossOrigin
    @PostMapping("/saving")
    public HookIngredient save(@RequestBody HookIngredient hookIngredient) {
        return repository.save(hookIngredient);
    }

    @CrossOrigin
    @GetMapping("/find/{name}")
    public Object find(@PathVariable String name) {
        Optional<HookIngredient> result = repository.findByTitle(name);
        if (result.isPresent()) {
            HookIngredient[] hookIngredients = {result.get()};
            return hookIngredients;
        } else {
            return "Not Found";
        }
    }

    @CrossOrigin
    @RequestMapping("/find")
    public Object findAll() {
        Iterable<HookIngredient> result = repository.findAll();
        return result;
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteById(id);
    }
}
