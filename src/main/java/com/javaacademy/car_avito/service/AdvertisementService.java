package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.dto.AdvertisementDto;
import com.javaacademy.car_avito.model.Advertisement;
import com.javaacademy.car_avito.storage.AdvertisementStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdvertisementService {
    private final AdvertisementStorage storage;
    private final GenerateId generateId;

    public void save(AdvertisementDto advertisementDto) {
        Advertisement ad = new Advertisement(
                generateId.getId(),
                advertisementDto.getBrand(),
                advertisementDto.getColor(),
                advertisementDto.getPrice());
        storage.save(ad);
    }

    public Optional<Advertisement> getAdByAd(Integer id) {
        return Optional.ofNullable(storage.getAllAd().get(id));
    }

    public boolean deleteAdById(Integer id) {
        return storage.deleteAdById(id);
    }

    public List<Advertisement> getAllAdByParam(String brand, String color, BigDecimal price) {
        return storage.getAllAd().values().stream().filter(ad -> matchesAll(ad, brand, color, price)).toList();
    }

    private boolean matchesAll(Advertisement ad, String brand, String color, BigDecimal price) {
        return matchesBrand(ad, brand) && matchesColor(ad, color) && matchesPrice(ad, price);
    }

    private boolean matchesBrand(Advertisement ad, String brand) {
        return (brand == null) || brand.equalsIgnoreCase(ad.getBrand());
    }

    private boolean matchesColor(Advertisement ad, String color) {
        return (color == null) || color.equalsIgnoreCase(ad.getColor());
    }

    private boolean matchesPrice(Advertisement ad, BigDecimal price) {
        return (price == null) || price.equals(ad.getPrice());
    }
}
