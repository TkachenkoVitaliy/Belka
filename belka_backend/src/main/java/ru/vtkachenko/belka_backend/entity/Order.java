package ru.vtkachenko.belka_backend.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;

    private Integer month;

    private String name;

    private Double ferrumPercentage;

    private Double siliciumPercentage;

    private Double aluminiumPercentage;

    private Double calciumPercentage;

    private Double sulfurPercentage;

    // TODO возможно стоит сделать кастомные констреинты
}
