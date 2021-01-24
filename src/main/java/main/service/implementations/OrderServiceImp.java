package main.service.implementations;

import main.domain.Order;
import main.domain.repository.OrderRepository;
import main.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class OrderServiceImp implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Set<Order> findAll() {
        Set<Order> orders=new HashSet<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }
}
