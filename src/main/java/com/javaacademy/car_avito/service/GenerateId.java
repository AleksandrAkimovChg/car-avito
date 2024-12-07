package com.javaacademy.car_avito.service;

import org.springframework.stereotype.Component;

@Component
public class GenerateId {
    private Integer count = 0;

    public Integer getId() {
        count++;
        return count;
    }
}
