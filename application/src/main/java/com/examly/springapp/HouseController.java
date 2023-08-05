// HouseController.java
package com.examly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping("/saveHouse")
    public ResponseEntity<String> saveHouse(@RequestBody House house) {
        houseService.saveHouse(house);
        return new ResponseEntity<>("House saved successfully", HttpStatus.OK);
    }

    @GetMapping("/getAllHouse")
    public ResponseEntity<List<House>> getAllHouse() {
        List<House> houses = houseService.getAllHouses();
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/getHouse")
    public ResponseEntity<House> getHouseById(@RequestParam String id) {
        Optional<House> house = houseService.getHouseById(id);
        return house.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getByType")
    public ResponseEntity<List<House>> getHousesByType(@RequestParam String type) {
        List<House> houses = houseService.getHousesByType(type);
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @DeleteMapping("/deleteHouse")
    public ResponseEntity<String> deleteHouse(@RequestParam String id) {
        Optional<House> house = houseService.getHouseById(id);
        if (house.isPresent()) {
            houseService.deleteHouse(id);
            return new ResponseEntity<>("House deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("House not found", HttpStatus.NOT_FOUND);
    }
}
