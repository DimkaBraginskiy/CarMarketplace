package org.example.carmarketplace.DTOs.Response;

public class PublicationVehicleDetailedResponseDto {
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

    // NEW fields for detailed view
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;

    public PublicationVehicleDetailedResponseDto(Long vehicleId, String brandName, String engineName, String gearboxType,
                                                 int year, String fuelType, String color, double horsePower,
                                                 String condition, double price, String description,
                                                 String ownerName, String ownerEmail, String ownerPhone) {
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
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;
    }

    // Getters and setters...

    public Long getVehicleId() { return vehicleId; }
    public String getBrandName() { return brandName; }
    public String getEngineName() { return engineName; }
    public String getGearboxType() { return gearboxType; }
    public int getYear() { return year; }
    public String getFuelType() { return fuelType; }
    public String getColor() { return color; }
    public double getHorsePower() { return horsePower; }
    public String getCondition() { return condition; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public String getOwnerName() { return ownerName; }
    public String getOwnerEmail() { return ownerEmail; }
    public String getOwnerPhone() { return ownerPhone; }
}
