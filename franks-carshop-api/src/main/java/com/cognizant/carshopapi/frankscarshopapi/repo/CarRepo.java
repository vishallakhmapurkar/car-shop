package com.cognizant.carshopapi.frankscarshopapi.repo;

import com.cognizant.carshopapi.frankscarshopapi.beans.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepo  extends JpaRepository<Car,Long> {
     List<Car> findAllByOrderByDateAddedAsc();
}
