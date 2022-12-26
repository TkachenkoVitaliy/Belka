package ru.vtkachenko.belka_backend.controller.payload;

import org.springframework.stereotype.Component;
import ru.vtkachenko.belka_backend.entity.Order;

@Component
public class OrderMapper {
    public Order fromRequest(OrderRequest request) {
        return Order.builder()
                .id(request.getId())
                .month(request.getMonth())
                .year(request.getYear())
                .name(request.getName())
                .aluminiumPercentage(request.getAluminium())
                .siliciumPercentage(request.getSilicium())
                .aluminiumPercentage(request.getAluminium())
                .calciumPercentage(request.getCalcium())
                .sulfurPercentage(request.getSulfur())
                .build();
    }

    public OrderResponse toResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .month(order.getMonth())
                .year(order.getYear())
                .name(order.getName())
                .aluminium(order.getAluminiumPercentage())
                .silicium(order.getSiliciumPercentage())
                .aluminium(order.getAluminiumPercentage())
                .calcium(order.getCalciumPercentage())
                .sulfur(order.getSulfurPercentage())
                .build();
    }
}
