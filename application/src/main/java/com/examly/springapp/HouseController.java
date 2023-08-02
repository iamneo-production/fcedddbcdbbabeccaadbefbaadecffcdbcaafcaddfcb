package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping("/saveHouse")
    public ResponseEntity<House> saveHouse(@RequestBody House house) {
        houseService.saveHouse(house);
        return ResponseEntity.ok(house);
    }

    @GetMapping("/getAllHouse")
    public ResponseEntity<List<House>> getAllHouses() {
        List<House> houses = houseService.getAllHouses();
        return ResponseEntity.ok(houses);
    }

    @GetMapping("/getByType")
    public ResponseEntity<List<House>> getByType(@RequestParam("type") String houseType) {
        List<House> houses = houseService.getByType(houseType);
        return ResponseEntity.ok(houses);
    }

    @GetMapping("/getHouse")
    public ResponseEntity<House> getHouseById(@RequestParam("id") String houseId) {
        House house = houseService.getHouseById(houseId);
        return ResponseEntity.ok(house);
    }

    @GetMapping("/deleteHouse")
    public ResponseEntity<Void> deleteHouse(@RequestParam("id") String houseId) {
        houseService.deleteHouse(houseId);
        return ResponseEntity.ok().build();
    }
}
