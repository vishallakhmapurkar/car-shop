package com.cognizant.carshopapi.frankscarshopapi.contoller;

import com.cognizant.carshopapi.frankscarshopapi.beans.Car;
import com.cognizant.carshopapi.frankscarshopapi.beans.CarsWareHouse;
import com.cognizant.carshopapi.frankscarshopapi.service.ICarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/car-api")
public class CarController {
    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private ICarService carService;
    @GetMapping(path="/all-cars",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> loadcars() {
        LOG.debug("Request call for all-cars");
        List<Car> carsWareHouses = null;
        try {
            carsWareHouses = carService.getAllCarsData();

            LOG.debug("carsWareHouses data"+carsWareHouses.size());
        } catch (IOException e) {
            LOG.error(e.getMessage(),e);
        }
        return new ResponseEntity<Object>(carsWareHouses, HttpStatus.OK);
    }

    @GetMapping(path="/allcarsbydateadded",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> allcarsbydateadded() {
        LOG.debug("Request call for all-cars");
        List<Car> carsWareHouses = null;
        try {
            carsWareHouses = carService.findAllByOrderByDateAddedAsc();

            LOG.debug("carsWareHouses data"+carsWareHouses.size());
        } catch (IOException e) {
            LOG.error(e.getMessage(),e);
        }
        return new ResponseEntity<Object>(carsWareHouses, HttpStatus.OK);
    }



}
