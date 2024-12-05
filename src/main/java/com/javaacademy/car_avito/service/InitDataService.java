package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.model.Ad;
import com.javaacademy.car_avito.storage.Storage;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("test")
@RequiredArgsConstructor
public class InitDataService {
    private  final Storage storage;

    @PostConstruct
    void init() {
        Ad ad1 = createAd(-1, "Toyota", "красный", new BigDecimal("20000"));
        Ad ad2 = createAd(0, null, "синий", new BigDecimal("30000"));
        storage.saveAd(ad1);
        storage.saveAd(ad2);
    }

    private Ad createAd(Integer id, String brand, String color, BigDecimal price) {
        return new Ad(id, brand, color, price);
    }
}
