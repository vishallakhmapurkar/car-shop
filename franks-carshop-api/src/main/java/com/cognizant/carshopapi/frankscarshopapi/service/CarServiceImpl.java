package com.cognizant.carshopapi.frankscarshopapi.service;

import com.cognizant.carshopapi.frankscarshopapi.beans.Car;
import com.cognizant.carshopapi.frankscarshopapi.beans.Vehicle;
import com.cognizant.carshopapi.frankscarshopapi.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CarServiceImpl implements ICarService{
    //create ObjectMapper instance
    @Autowired
    CarRepo carRepo;



    @Override
    public List<Car> getAllCarsData() throws IOException {
        return (List<Car>) carRepo.findAll();
    }

    @Override
    public List<Car> findAllByOrderByDateAddedAsc() throws IOException {
        return carRepo.findAllByOrderByDateAddedAsc();
    }


    private List<Vehicle> getSortedList(List<Vehicle> vehicleList){

         Collections.sort(vehicleList, new VehicleComparator());
         return vehicleList;
    }

    private class VehicleComparator implements Comparator<Vehicle> {


        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            return v1.getDateAdded().compareTo(v2.getDateAdded());
        }
    }
}
