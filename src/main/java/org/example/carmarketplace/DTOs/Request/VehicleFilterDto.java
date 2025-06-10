package org.example.carmarketplace.DTOs.Request;

import org.example.carmarketplace.ENUMs.GearboxType;
import org.example.carmarketplace.ENUMs.VehicleCondition;
import org.example.carmarketplace.ENUMs.VehicleType;

public class VehicleFilterDto {
    private VehicleType vehicleType;
    private Long brandId;
    private Long fuelTypeId;
    private Integer yearFrom;
    private Integer yearTo;
    private Long colorId;
    private VehicleCondition condition;
    private GearboxType gearboxType;
    private Integer hpFrom;
    private Integer hpTo;
    private String keyword;

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setFuelTypeId(Long fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public void setCondition(VehicleCondition condition) {
        this.condition = condition;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public void setHpFrom(Integer hpFrom) {
        this.hpFrom = hpFrom;
    }

    public void setHpTo(Integer hpTo) {
        this.hpTo = hpTo;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getFuelTypeId() {
        return fuelTypeId;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public Long getColorId() {
        return colorId;
    }

    public VehicleCondition getCondition() {
        return condition;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public Integer getHpFrom() {
        return hpFrom;
    }

    public Integer getHpTo() {
        return hpTo;
    }

    public String getKeyword() {
        return keyword;
    }
}