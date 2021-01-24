package main.service;

import main.domain.Order;

import java.util.Set;

public interface OrderService {
    public void save(Order order);

    public Set<Order> findAll();
}
