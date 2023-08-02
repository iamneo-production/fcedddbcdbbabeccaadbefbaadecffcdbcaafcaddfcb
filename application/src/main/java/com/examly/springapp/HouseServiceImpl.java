package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public House saveHouse(House house) {
        return houseRepository.save(house);
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    @Override
    public List<House> getByType(String houseType) {
        return houseRepository.findByType(houseType);
    }

    @Override
    public House getHouseById(Long id) {
        return houseRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteHouse(Long id) {
        houseRepository.deleteById(id);
    }
}

