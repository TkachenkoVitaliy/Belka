package ru.vtkachenko.belka_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.vtkachenko.belka_backend.controller.payload.*;
import ru.vtkachenko.belka_backend.entity.Order;
import ru.vtkachenko.belka_backend.service.OrderService;
import ru.vtkachenko.belka_backend.service.ReportService;
import ru.vtkachenko.belka_backend.service.SummaryOrder;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MainController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final ReportService reportService;

    @Autowired
    public MainController(OrderService orderService, OrderMapper orderMapper, ReportService reportService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.reportService = reportService;
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity testMapping() {

        return ResponseEntity.ok("HELLO");
    }

    @GetMapping("/orders/{year}/{month}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<OrderResponse>> getOrdersByMonthAndYear(@PathVariable("year") Integer year,
                                                                       @PathVariable("month") Integer month) {
        List<Order> ordersByMonthAndYear = orderService.getOrdersByMonthAndYear(month, year);

        return ResponseEntity.ok(ordersByMonthAndYear.stream()
                .map(orderMapper::toResponse).toList());
    }

    @PostMapping("/orders")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<OrderResponse>> saveOrders(@RequestBody List<OrderRequest> orderRequests) {
         List<OrderResponse> orderResponses = orderRequests.stream()
                .map(orderMapper::fromRequest)
                .map(orderService::saveOrder)
                .map(orderMapper::toResponse)
                .toList();

         return ResponseEntity.ok(orderResponses);
    }

    @GetMapping("/reports/{year}/{month}")
    public ResponseEntity<ReportResponse> getReport(@PathVariable("year") Integer year,
                          @PathVariable("month") Integer month) {

        List<Order> orders = orderService.getOrdersByMonthAndYear(month, year);

        // Ответ с пустым списком
        if (orders.isEmpty()) {
            return ResponseEntity.ok(new ReportResponse(LocalDateTime.now()));
        }

        List<ReportElement> reportElements = reportService.calculateReport(orders);

       return ResponseEntity.ok(new ReportResponse(reportElements, LocalDateTime.now()));
    }
}
