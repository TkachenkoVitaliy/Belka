package ru.vtkachenko.belka_backend.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportResponse {

    private List<ReportElement> report = new ArrayList<>();

    private LocalDateTime createdAt;

    public ReportResponse(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
