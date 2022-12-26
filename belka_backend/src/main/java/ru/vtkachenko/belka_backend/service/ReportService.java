package ru.vtkachenko.belka_backend.service;

import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final OrderService orderService;

    public ReportService(OrderService orderService) {
        this.orderService = orderService;
    }


}
