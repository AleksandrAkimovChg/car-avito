package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.model.Ad;
import com.javaacademy.car_avito.model.GenerateId;
import com.javaacademy.car_avito.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdService {
    private final Storage storage;
    private final GenerateId generateId;

    public void saveAd(String brand, String color, BigDecimal price) {
        Ad ad = new Ad(generateId.getId(), brand, color, price);
        storage.saveAd(ad);
    }

    public Optional<Ad> getAdByAd(Integer id) {
        return Optional.ofNullable(storage.getAllAd().get(id));
    }

    public boolean deleteAdById(Integer id) {
        return storage.deleteAdById(id);
    }

    public List<Ad> getAllAdByParam(String brand, String color, BigDecimal price) {
        return storage
                .getAllAd()
                .values()
                .stream()
                .filter(ad -> matchesAll(ad, brand, color, price))
                .toList();
    }

    private boolean matchesAll(Ad ad, String brand, String color, BigDecimal price) {
        return matchesBrand(ad, brand) && matchesColor(ad, color) && matchesPrice(ad, price);
    }

    private boolean matchesBrand(Ad ad, String brand) {
        return (brand == null) || brand.equalsIgnoreCase(ad.getBrand());
    }

    private boolean matchesColor(Ad ad, String color) {
        return (color == null) || color.equalsIgnoreCase(ad.getColor());
    }

    private boolean matchesPrice(Ad ad, BigDecimal price) {
        return (price == null) || price.equals(ad.getPrice());
    }
}
