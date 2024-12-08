package com.javaacademy.car_avito.controller;

import com.javaacademy.car_avito.dto.AdvertisementDto;
import com.javaacademy.car_avito.model.Advertisement;
import com.javaacademy.car_avito.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/advertisement")
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    /**
     * Создать объявление http://localhost:8003/advertisement/brand/приус
     */
    @PostMapping
    public void saveAd(@RequestBody AdvertisementDto advertisementDto) {
        log.info(advertisementDto.toString());
        advertisementService.save(advertisementDto);
    }

    /**
     * Поиск объявления
     */
    @GetMapping("/brand/{brand}")
    public List<Advertisement> findAllAdByBrand(@PathVariable String brand) {
        log.info("brand input: {}", brand);
        return advertisementService.getAllAdByBrand(brand);
    }

    /**
     * Получить объявление http://localhost:8003/advertisement/1
     */
    @GetMapping("/{id}")
    public Advertisement findAdById(@PathVariable Integer id) {
        log.info("id: {}", id);
        return advertisementService.getAdByAd(id).orElseThrow();
    }

    /**
     * Удалить объявление http://localhost:8003/advertisement/1
     */
    @DeleteMapping("/{id}")
    public boolean getStorage(@PathVariable Integer id) {
        return advertisementService.deleteAdById(id);
    }



    @GetMapping("/search")
    public List<Advertisement> findAdByParam(@RequestParam(required = false) String brand,
                                             @RequestParam(required = false) String color,
                                             @RequestParam(required = false) BigDecimal price) {
        log.info("brand: {}, color: {}, price: {}", brand, color, price);
        return advertisementService.getAllAdByParam(brand, color, price);
    }
}
