package com.example.housemanagement.controller;

import com.example.housemanagement.exception.HouseNotFoundException;
import com.example.housemanagement.model.House;
import com.example.housemanagement.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    @PostMapping("/saveHouse")
    public House saveHouse(@RequestBody House house) {
        return houseRepository.save(house);
    }

    @GetMapping("/getHouse")
    public ResponseEntity<House> getHouseById(@RequestParam Long id) {
        House house = houseRepository.findById(id)
                .orElseThrow(() -> new HouseNotFoundException("House not found with id: " + id));
        return ResponseEntity.ok(house);
    }

    @GetMapping("/getAllHouse")
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    @GetMapping("/getByType")
    public List<House> getHousesByType(@RequestParam String type) {
        return houseRepository.findByType(type);
    }

    @GetMapping("/deleteHouse")
    public String deleteHouseById(@RequestParam Long id) {
        House house = houseRepository.findById(id)
                .orElseThrow(() -> new HouseNotFoundException("House not found with id: " + id));
        houseRepository.delete(house);
        return "Deleted successfully";
    }
}
