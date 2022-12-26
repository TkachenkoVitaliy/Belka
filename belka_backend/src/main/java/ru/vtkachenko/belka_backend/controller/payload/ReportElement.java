package ru.vtkachenko.belka_backend.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportElement {
    private String name;
    private Double min;
    private Double average;
    private Double max;
}
