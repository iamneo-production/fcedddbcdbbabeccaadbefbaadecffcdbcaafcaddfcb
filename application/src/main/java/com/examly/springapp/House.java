package com.examly.springapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="House")
public class House {

    @Id
    private String houseId;
    private String houseNo;
    private String status;
    private String type;

    public House() {
    }

    public House(String houseId, String houseNo, String status, String type) {
        this.houseId = houseId;
        this.houseNo = houseNo;
        this.status = status;
        this.type = type;
    }

    // Getters and Setters

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
