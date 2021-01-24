package main.controller.reactHook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class HookeStarter implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    @Qualifier("repository")
    private Repository repository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        repository.save(new HookIngredient("burger", 3));
    }
}
