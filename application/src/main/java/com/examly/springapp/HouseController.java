package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
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
    public House saveHouse(@RequestBody House house) {
        return houseService.saveHouse(house);
    }

    @GetMapping("/getAllHouse")
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @GetMapping("/getByType")
    public List<House> getByType(@RequestParam("type") String houseType) {
        return houseService.getByType(houseType);
    }

    @GetMapping("/getHouse")
    public House getHouseById(@RequestParam("id") Long id) {
        return houseService.getHouseById(id);
    }

    @GetMapping("/deleteHouse")
    public void deleteHouse(@RequestParam("id") Long id) {
        houseService.deleteHouse(id);
    }
}

