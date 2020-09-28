package com.cognizant.carshopapi.frankscarshopapi.beans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String warehousename;
    private String lat;
    private String lng;
    private String location;
    private String make;
    private String model;
    private Integer yearModel;
    private Double price;
    private Boolean licensed;
    private Date dateAdded;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehousename() {
        return warehousename;
    }

    public void setWarehousename(String warehousename) {
        this.warehousename = warehousename;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearModel() {
        return yearModel;
    }

    public void setYearModel(Integer yearModel) {
        this.yearModel = yearModel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getLicensed() {
        return licensed;
    }

    public void setLicensed(Boolean licensed) {
        this.licensed = licensed;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", warehousename='" + warehousename + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", location='" + location + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearModel=" + yearModel +
                ", price=" + price +
                ", licensed=" + licensed +
                ", dateAdded=" + dateAdded +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(warehousename, car.warehousename) &&
                Objects.equals(lat, car.lat) &&
                Objects.equals(lng, car.lng) &&
                Objects.equals(location, car.location) &&
                Objects.equals(make, car.make) &&
                Objects.equals(model, car.model) &&
                Objects.equals(yearModel, car.yearModel) &&
                Objects.equals(price, car.price) &&
                Objects.equals(licensed, car.licensed) &&
                Objects.equals(dateAdded, car.dateAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, warehousename, lat, lng, location, make, model, yearModel, price, licensed, dateAdded);
    }
}
