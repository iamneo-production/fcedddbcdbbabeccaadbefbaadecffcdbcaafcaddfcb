// HouseRepository.java
package com.examly.springapp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HouseRepository extends CrudRepository<House, String> {
    List<House> findByType(String type);
}
