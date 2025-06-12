package org.example.carmarketplace.DTOs.Response;

public class PublicationVehicleResponseDto {
    private Long vehicleId;
    private String brandName;
    private String engineName;
    private String gearboxType;
    private int year;
    private String fuelType;
    private String color;
    private double horsePower;
    private String condition;
    private double price;
    private String description;

    private boolean active;

    public PublicationVehicleResponseDto(Long vehicleId, String brandName, String engineName,
                                         String gearboxType, int year, String fuelType,
                                         String color, double horsePower, String condition,
                                         double price, String description, boolean active) {
        this.vehicleId = vehicleId;
        this.brandName = brandName;
        this.engineName = engineName;
        this.gearboxType = gearboxType;
        this.year = year;
        this.fuelType = fuelType;
        this.color = color;
        this.horsePower = horsePower;
        this.condition = condition;
        this.price = price;
        this.description = description;

        this.active =  active;
    }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getEngineName() {
        return engineName;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public int getYear() {
        return year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getColor() {
        return color;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public String getCondition() {
        return condition;
    }

    public double getPrice() {
        return price;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
