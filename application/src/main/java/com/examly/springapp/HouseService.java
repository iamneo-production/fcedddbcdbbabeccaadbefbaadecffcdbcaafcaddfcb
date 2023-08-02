package com.examly.springapp;

import java.util.List;

public interface HouseService {
    void saveHouse(House house);

    void updateHouseStatus(String houseId, String status);

    void deleteHouse(String houseId);

    List<House> getAllHouses();

    House getHouseById(String houseId);
}
