package com.examly.springapp;

import java.util.List;

public interface HouseService {
    House saveHouse(House house);

    List<House> getAllHouses();

    List<House> getByType(String houseType);

    House getHouseById(Long id);

    void deleteHouse(Long id);
}

