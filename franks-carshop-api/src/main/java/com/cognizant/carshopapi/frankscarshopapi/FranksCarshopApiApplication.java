package com.cognizant.carshopapi.frankscarshopapi;

import com.cognizant.carshopapi.frankscarshopapi.beans.Car;
import com.cognizant.carshopapi.frankscarshopapi.beans.CarsWareHouse;
import com.cognizant.carshopapi.frankscarshopapi.beans.Vehicle;
import com.cognizant.carshopapi.frankscarshopapi.repo.CarRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@SpringBootApplication
public class FranksCarshopApiApplication implements CommandLineRunner {

	@Autowired
	private CarRepo carRepo;
	public static void main(String[] args) {
		SpringApplication.run(FranksCarshopApiApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}
	@Override
	public void run(String... args) throws Exception {
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		CarsWareHouse[] carsWareHouses = objectMapper.readValue(new ClassPathResource("carewarehouse.json").getInputStream()	, CarsWareHouse[].class);

		for (CarsWareHouse carsWareHouse:carsWareHouses) {

			for(Vehicle vehicle:carsWareHouse.getCars().getVehicles()){
				Car car =new Car();
				car.setWarehousename(carsWareHouse.getName());
				car.setLocation(carsWareHouse.getCars().getLocation());
				car.setLat(carsWareHouse.getLocation().getLat());
				car.setLng(carsWareHouse.getLocation().getLat());
				car.setDateAdded(vehicle.getDateAdded());
				car.setLicensed(vehicle.getLicensed());
				car.setMake(vehicle.getMake());
				car.setModel(vehicle.getModel());
				car.setYearModel(vehicle.getYearModel());
				car.setPrice(vehicle.getPrice().doubleValue());
				carRepo.save(car);
			}

		}



	}
}
