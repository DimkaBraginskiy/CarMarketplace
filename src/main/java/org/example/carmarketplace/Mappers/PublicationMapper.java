package org.example.carmarketplace.Mappers;

import org.example.carmarketplace.DTOs.Request.PublicationVehicleRequestDto;
import org.example.carmarketplace.Models.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublicationMapper {
    public Vehicle toVehicle(PublicationVehicleRequestDto dto, User owner, Brand brand, List<ComfortFeatures> comfortFeatures, List<FuelType> fuelTypes) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(dto.getVin());
        vehicle.setLicensePlate(dto.getLicensePlate());
        vehicle.setProductionDate(dto.getProductionDate());
        vehicle.setMileage(dto.getMileage());
        vehicle.setEngineName(dto.getEngineName());
        vehicle.setHorsePower(dto.getHorsePower());
        vehicle.setOwner(owner);
        vehicle.setBrand(brand);
        vehicle.setVehicleCondition(dto.getVehicleCondition());
        vehicle.setGearboxType(dto.getGearboxType());
        vehicle.setVehicleType(dto.getVehicleType());
        vehicle.setComfortFeatures(comfortFeatures);
        vehicle.setFuelTypes(fuelTypes);
        return vehicle;
    }

    public Publication toPublication(PublicationVehicleRequestDto dto, Vehicle vehicle) {
        Publication pub = new Publication();
        pub.setActive(true);
        pub.setDescription(dto.getDescription());
        pub.setPrice(dto.getPrice());
        pub.setVehicle(vehicle);
        return pub;
    }
}
