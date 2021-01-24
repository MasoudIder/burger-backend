package main.controller;

import lombok.extern.slf4j.Slf4j;
import main.domain.Ingredient;
import main.domain.Order;
import main.domain.Token;
import main.domain.User;
import main.service.IngredientService;
import main.service.OrderService;
import main.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
public class MyController {

    private OrderService orderService;
    private IngredientService ingredientService;
    private UserService userService;

    public MyController(OrderService orderService, IngredientService ingredientService, UserService userService) {
        this.orderService = orderService;
        this.ingredientService = ingredientService;
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("/order")
    public void addBurgerOrder(@RequestBody Order order) {
        orderService.save(order);
        //log.warn(order.toString());
    }

    @CrossOrigin
    @GetMapping("/orders")
    public Object getOrders(@RequestHeader Map<String, String> headers) {
        String token = headers.get("token").toString();
        if (token.equals("T123456789")) {
            return orderService.findAll();
        } else {
            return "user is not authenticated";
        }
    }

    @CrossOrigin
    @GetMapping("ingredient")
    public Ingredient getIngredient() {
        return ingredientService.first().get();
    }

    @CrossOrigin
    @PostMapping("/auth")
    public String authentication(@RequestBody User user) {
        boolean check = userService.findByEmailAndPassword(user.getEmail(), user.getPassword()).isPresent();
        if (check) {
            return new Token().toString();
        } else {
            return "false";
        }
    }

    @CrossOrigin
    @PostMapping("/sign-up")
    public boolean saveUser(@RequestBody User user) {
        userService.save(user);
        return true;
    }
}
