package com.cognizant.carshopapi.frankscarshopapi.service;

import com.cognizant.carshopapi.frankscarshopapi.beans.Car;
import com.cognizant.carshopapi.frankscarshopapi.beans.CarsWareHouse;

import java.io.IOException;
import java.util.List;

public interface ICarService {
    List<Car> getAllCarsData() throws IOException;
    List<Car> findAllByOrderByDateAddedAsc() throws IOException;
}
