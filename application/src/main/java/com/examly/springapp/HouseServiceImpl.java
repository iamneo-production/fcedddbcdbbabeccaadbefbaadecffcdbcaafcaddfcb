package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public void saveHouse(House house) {
        houseRepository.save(house);
    }

    @Override
    public void updateHouseStatus(String houseId, String status) {
        Optional<House> house = houseRepository.findById(houseId);
        if (house.isPresent()) {
            House h = house.get();
            h.setStatus(status);
            houseRepository.save(h);
        }
    }

    @Override
    public void deleteHouse(String houseId) {
        houseRepository.deleteById(houseId);
    }

    @Override
    public List<House> getAllHouses() {
        List<House> houses = new ArrayList<>();
        houseRepository.findAll().forEach(houses::add);
        return houses;
    }

    @Override
    public House getHouseById(String houseId) {
        Optional<House> house = houseRepository.findById(houseId);
        if (house.isPresent()) {
            return house.get();
        } else {
            throw new HouseNotFoundException("House not found with id: " + houseId);
        }
    }
}
