package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.model.Advertisement;
import com.javaacademy.car_avito.storage.AdvertisementStorage;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("test")
@RequiredArgsConstructor
public class InitDataService {
    private  final AdvertisementStorage storage;

    @PostConstruct
    public void init() {
        Advertisement ad1 = createAd(-1, "Toyota", "красный", new BigDecimal("20000"));
        Advertisement ad2 = createAd(0, null, "синий", new BigDecimal("30000"));
        storage.save(ad1);
        storage.save(ad2);
    }

    private Advertisement createAd(Integer id, String brand, String color, BigDecimal price) {
        return new Advertisement(id, brand, color, price);
    }
}
