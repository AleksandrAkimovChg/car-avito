package com.javaacademy.car_avito.storage;

import com.javaacademy.car_avito.model.Advertisement;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AdvertisementStorage {
    private final Map<Integer, Advertisement> storage = new HashMap<>();

    public void save(Advertisement ad) {
        storage.put(ad.getId(), ad);
    }

    public Map<Integer, Advertisement> getAllAd() {
        return new HashMap<>(storage);
    }

    public boolean deleteAdById(Integer id) {
        return storage.remove(id) != null;
    }
}
