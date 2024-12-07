package com.javaacademy.car_avito.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Advertisement {
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String brand;
    private String color;
    private BigDecimal price;
}
