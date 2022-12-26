package ru.vtkachenko.belka_backend.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private Long id;

    private Integer month;

    private Integer year;

    private String name;

    private Double ferrum;

    private Double silicium;

    private Double aluminium;

    private Double calcium;

    private Double sulfur;
}
