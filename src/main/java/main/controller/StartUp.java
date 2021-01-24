package main.controller;

import main.domain.Ingredient;
import main.domain.Order;
import main.domain.User;
import main.service.IngredientService;
import main.service.OrderService;
import main.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements ApplicationListener<ContextRefreshedEvent> {

    private OrderService orderService;
    private IngredientService ingredientService;
    private UserService userService;

    public StartUp(OrderService orderService, IngredientService ingredientService, UserService userService) {
        this.orderService = orderService;
        this.ingredientService = ingredientService;
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Order order = new Order(1, 1, 1, 1, 12.00, "MasoudIder", "ider@yahoo.com", "09139887321", "cheap");
        orderService.save(order);

        Ingredient ingredient = new Ingredient(0, 0, 0, 0);
        ingredientService.save(ingredient);

        User user = new User("i@y.c", "1 ");
        userService.save(user);
    }
}
