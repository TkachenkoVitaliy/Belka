package ru.vtkachenko.belka_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vtkachenko.belka_backend.repository.OrderRepository;
import ru.vtkachenko.belka_backend.entity.Order;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public List<Order> saveOrders(List<Order> orders) {
        return orderRepository.saveAll(orders);
    }

    public List<Order> getOrdersByMonthAndYear(Integer month, Integer year) {
        return orderRepository.findOrdersByMonthAndYear(month, year);
    }
}
