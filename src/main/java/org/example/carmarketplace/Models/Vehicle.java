package org.example.carmarketplace.Models;

import jakarta.persistence.*;
import org.example.carmarketplace.Models.FuelType;
import org.example.carmarketplace.ENUMs.GearboxType;
import org.example.carmarketplace.ENUMs.VehicleCondition;
import org.example.carmarketplace.ENUMs.VehicleType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25, nullable = false)
    private String vin;

    @Column(length = 10, nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private LocalDate productionDate;

    @Column(nullable = false)
    private Integer mileage;

    @Column(length = 50)
    private String engineName;

    @Column(nullable = false)
    private Double horsePower;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type", nullable = false, length = 50)
    private VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_condition", nullable = false, length = 50)
    private VehicleCondition vehicleCondition;

    @Enumerated(EnumType.STRING)
    @Column(name = "gearbox_type", nullable = false, length = 50)
    private GearboxType gearboxType;

    @ManyToMany
    @JoinTable(
            name = "comfort_features_vehicle",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "comfort_features_id")
    )
    private List<ComfortFeatures> comfortFeatures;

    @ManyToMany
    @JoinTable(
            name = "vehicle_fuel_type",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "fuel_type_id")
    )
    private List<FuelType> fuelTypes;


    public Vehicle(Long id, String vin, String licensePlate, LocalDate productionDate, Integer mileage, String engineName, Double horsePower, User owner, Brand brand, VehicleCondition vehicleCondition, GearboxType gearboxType, List<ComfortFeatures> comfortFeatures, List<FuelType> fuelTypes, VehicleType vehicleType) {
        this.id = id;
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.productionDate = productionDate;
        this.mileage = mileage;
        this.engineName = engineName;
        this.horsePower = horsePower;
        this.owner = owner;
        this.brand = brand;
        this.vehicleCondition = vehicleCondition;
        this.gearboxType = gearboxType;
        this.comfortFeatures = comfortFeatures;
        this.fuelTypes = fuelTypes;
        this.vehicleType = vehicleType;
    }

    public Vehicle() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public void setHorsePower(Double horsePower) {
        this.horsePower = horsePower;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setVehicleCondition(VehicleCondition vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public void setComfortFeatures(List<ComfortFeatures> comfortFeatures) {
        this.comfortFeatures = comfortFeatures;
    }

    public void setFuelTypes(List<FuelType> fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public Integer getMileage() {
        return mileage;
    }

    public String getEngineName() {
        return engineName;
    }

    public Double getHorsePower() {
        return horsePower;
    }

    public User getOwner() {
        return owner;
    }

    public Brand getBrand() {
        return brand;
    }

    public VehicleCondition getVehicleCondition() {
        return vehicleCondition;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public List<ComfortFeatures> getComfortFeatures() {
        return comfortFeatures;
    }

    public List<FuelType> getFuelTypes() {
        return fuelTypes;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
