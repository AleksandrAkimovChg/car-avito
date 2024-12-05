package com.javaacademy.car_avito.storage;

import com.javaacademy.car_avito.model.Ad;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Storage {
    private final Map<Integer, Ad> storage = new HashMap<>();

    public void saveAd(Ad ad) {
        storage.put(ad.getId(), ad);
    }

    public Map<Integer, Ad> getAllAd() {
        return new HashMap<>(storage);
    }

    public boolean deleteAdById(Integer id) {
        return storage.remove(id) != null;
    }
}
