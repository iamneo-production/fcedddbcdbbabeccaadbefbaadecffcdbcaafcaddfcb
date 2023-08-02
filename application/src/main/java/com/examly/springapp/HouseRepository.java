package com.examly.springapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {}
