package ru.vtkachenko.belka_backend.service;

import org.springframework.stereotype.Service;
import ru.vtkachenko.belka_backend.controller.payload.ReportElement;
import ru.vtkachenko.belka_backend.controller.payload.ReportResponse;
import ru.vtkachenko.belka_backend.entity.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

@Service
public class ReportService {

    public List<ReportElement> calculateReport(List<Order> orders) {
        SummaryOrder summaryOrder = new SummaryOrder();
        orders.forEach(summaryOrder::pushItem);

        List<ReportElement> reportElements = new ArrayList<>();

        reportElements.add(calculateElement(summaryOrder.getFerrumSummary(), "ferrum"));
        reportElements.add(calculateElement(summaryOrder.getFerrumSummary(), "silicium"));
        reportElements.add(calculateElement(summaryOrder.getFerrumSummary(), "aluminium"));
        reportElements.add(calculateElement(summaryOrder.getFerrumSummary(), "calcium"));
        reportElements.add(calculateElement(summaryOrder.getFerrumSummary(), "sulfur"));

        return reportElements;
    }

    private ReportElement calculateElement(List<Double> values, String name) {
        Double average = values.stream()
                .mapToDouble(value -> value)
                .average()
                .getAsDouble();


        return ReportElement.builder()
                .name(name)
                .min(Collections.min(values))
                .max(Collections.max(values))
                .average(average)
                .build();
    }


}
