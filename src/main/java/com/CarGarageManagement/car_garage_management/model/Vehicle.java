package com.CarGarageManagement.car_garage_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private String id;
    private String make;
    private String model;
    private int year;
    private int mileage;
}
