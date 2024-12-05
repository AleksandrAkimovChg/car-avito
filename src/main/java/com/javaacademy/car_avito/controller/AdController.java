package com.javaacademy.car_avito.controller;

import com.javaacademy.car_avito.dto.AdDto;
import com.javaacademy.car_avito.model.Ad;
import com.javaacademy.car_avito.service.AdService;
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
@RequestMapping("/ad")
public class AdController {
    private final AdService adService;

    @PostMapping
    public void saveAd(@RequestBody AdDto adDto) {
        log.info(adDto.toString());
        adService.saveAd(adDto.getBrand(), adDto.getColor(), adDto.getPrice());
    }

    @GetMapping("/search/brand/{brand}")
    public List<Ad> findAllAdByBrand(@PathVariable String brand) {
        log.info("brand input: {}", brand);
        return adService.getAllAdByParam(brand, null, null);
    }

    @GetMapping("/search/id/{id}")
    public Ad findAdById(@PathVariable Integer id) {
        log.info("id: {}", id);
        return adService.getAdByAd(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public boolean getStorage(@PathVariable Integer id) {
        return adService.deleteAdById(id);
    }

    @GetMapping("/search")
    public List<Ad> findAdByParam(@RequestParam(required = false) String brand,
                                  @RequestParam(required = false) String color,
                                  @RequestParam(required = false) BigDecimal price) {
        log.info("brand: {}, color: {}, price: {}", brand, color, price);
        return adService.getAllAdByParam(brand, color, price);
    }
}
