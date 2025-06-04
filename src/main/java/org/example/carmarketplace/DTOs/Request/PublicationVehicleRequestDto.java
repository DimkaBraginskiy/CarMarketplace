package org.example.carmarketplace.DTOs.Request;

import org.example.carmarketplace.ENUMs.GearboxType;
import org.example.carmarketplace.ENUMs.VehicleCondition;
import org.example.carmarketplace.ENUMs.VehicleType;

import java.time.LocalDate;
import java.util.List;

public class PublicationVehicleRequestDto {

    // Vehicle fields
    private String vin;
    private String licensePlate;
    private LocalDate productionDate;
    private Integer mileage;
    private String engineName;
    private Double horsePower;
    private Long ownerId;
    private Long brandId;
    private VehicleCondition vehicleCondition;
    private GearboxType gearboxType;
    private VehicleType vehicleType;
    private List<Long> comfortFeatureIds;
    private List<Long> fuelTypeIds;

    // Publication fields
    private String description;
    private Double price;

    public PublicationVehicleRequestDto(String vin, String licensePlate, LocalDate productionDate, Integer mileage, String engineName, Double horsePower, Long ownerId, Long brandId, VehicleCondition vehicleCondition, GearboxType gearboxType, VehicleType vehicleType, List<Long> comfortFeatureIds, List<Long> fuelTypeIds, String description, Double price) {
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.productionDate = productionDate;
        this.mileage = mileage;
        this.engineName = engineName;
        this.horsePower = horsePower;
        this.ownerId = ownerId;
        this.brandId = brandId;
        this.vehicleCondition = vehicleCondition;
        this.gearboxType = gearboxType;
        this.vehicleType = vehicleType;
        this.comfortFeatureIds = comfortFeatureIds;
        this.fuelTypeIds = fuelTypeIds;
        this.description = description;
        this.price = price;
    }

    public PublicationVehicleRequestDto() {
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

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setVehicleCondition(VehicleCondition vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setComfortFeatureIds(List<Long> comfortFeatureIds) {
        this.comfortFeatureIds = comfortFeatureIds;
    }

    public void setFuelTypeIds(List<Long> fuelTypeIds) {
        this.fuelTypeIds = fuelTypeIds;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Long getOwnerId() {
        return ownerId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public VehicleCondition getVehicleCondition() {
        return vehicleCondition;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public List<Long> getComfortFeatureIds() {
        return comfortFeatureIds;
    }

    public List<Long> getFuelTypeIds() {
        return fuelTypeIds;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
