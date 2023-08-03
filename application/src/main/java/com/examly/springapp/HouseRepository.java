package com.examly.springapp;

import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<House, String> {
}
