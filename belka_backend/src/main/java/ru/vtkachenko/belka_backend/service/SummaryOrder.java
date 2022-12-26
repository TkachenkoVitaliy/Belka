package ru.vtkachenko.belka_backend.service;

import lombok.Getter;
import ru.vtkachenko.belka_backend.entity.Order;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SummaryOrder {

    private List<Double> ferrumSummary = new ArrayList<>();

    private List<Double> siliciumSummary = new ArrayList<>();

    private List<Double> aluminiumSummary = new ArrayList<>();

    private List<Double> calciumSummary = new ArrayList<>();

    private List<Double> sulfurSummary = new ArrayList<>();

    public void pushItem(Order order) {
        ferrumSummary.add(order.getFerrumPercentage());
        siliciumSummary.add(order.getSiliciumPercentage());
        aluminiumSummary.add(order.getAluminiumPercentage());
        calciumSummary.add(order.getCalciumPercentage());
        sulfurSummary.add(order.getSulfurPercentage());
    }
}
