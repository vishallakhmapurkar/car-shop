package com.cognizant.carshopapi.frankscarshopapi;

import com.cognizant.carshopapi.frankscarshopapi.beans.Car;
import com.cognizant.carshopapi.frankscarshopapi.beans.CarsWareHouse;
import com.cognizant.carshopapi.frankscarshopapi.beans.Vehicle;
import com.cognizant.carshopapi.frankscarshopapi.contoller.CarController;
import com.cognizant.carshopapi.frankscarshopapi.repo.CarRepo;
import com.cognizant.carshopapi.frankscarshopapi.service.ICarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(controllers = CarController.class)
class FranksCarshopApiApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ICarService carService;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private CarRepo carRepo;

	private CarsWareHouse[] carsWareHouses;

	private List<Car> cars;
	@BeforeEach
	void setUp() throws Exception {
		CarsWareHouse[] carsWareHouses = mapper.readValue(new ClassPathResource("carewarehouse.json").getInputStream(), CarsWareHouse[].class);

		for (CarsWareHouse carsWareHouse : carsWareHouses) {

			for (Vehicle vehicle : carsWareHouse.getCars().getVehicles()) {
				Car car = new Car();
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
			cars = (List<Car>) carRepo.findAll();
		}
	}
		@Test
		@WithMockUser(username = "caruser", password = "caruser", roles = {"USER", "ADMIN"})
		void carLoa() throws Exception {

			given(carService.getAllCarsData()).willReturn(cars);


			this.mockMvc.perform(get("/car-api/all-cars"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.size()", is(cars.size())));
		}
	}

