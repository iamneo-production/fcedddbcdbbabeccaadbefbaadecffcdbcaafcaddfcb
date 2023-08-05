package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    public void saveHouse(House house) {
        houseRepository.save(house);
    }

    public List<House> getAllHouses() {
        return (List<House>) houseRepository.findAll();
    }

    public Optional<House> getHouseById(String houseId) {
        return houseRepository.findById(houseId);
    }

    public List<House> getHousesByType(String type) {
        return houseRepository.findByType(type);
    }

    public void deleteHouse(String houseId) {
        houseRepository.deleteById(houseId);
    }
}
