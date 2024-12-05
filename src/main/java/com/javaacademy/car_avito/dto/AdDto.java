package com.javaacademy.car_avito.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdDto {
    private String brand;
    private String color;
    private BigDecimal price;
}
