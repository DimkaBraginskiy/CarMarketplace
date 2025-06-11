package org.example.carmarketplace.Mappers;

import org.example.carmarketplace.DTOs.Request.PublicationVehicleRequestDto;
import org.example.carmarketplace.DTOs.Response.PublicationVehicleDetailedResponseDto;
import org.example.carmarketplace.DTOs.Response.PublicationVehicleResponseDto;
import org.example.carmarketplace.Models.*;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublicationMapper {

    public static PublicationVehicleResponseDto toCardDto(Publication publication) {
        Vehicle v = publication.getVehicle();
        return new PublicationVehicleResponseDto(
                v.getId(),
                v.getBrand().getName(),
                v.getEngineName(),
                v.getGearboxType().toString(),
                v.getProductionDate().getYear(),
                v.getFuelTypes().isEmpty() ? "N/A" : v.getFuelTypes().get(0).getName(),
                v.getColor().getName(),
                v.getHorsePower(),
                v.getVehicleCondition().toString(),
                publication.getPrice(),
                publication.getDescription()
        );
    }

    public static PublicationVehicleDetailedResponseDto toDetailedDto(Publication publication) {
        Vehicle v = publication.getVehicle();
        User owner = v.getOwner();
        return new PublicationVehicleDetailedResponseDto(
                v.getId(),
                v.getBrand().getName(),
                v.getEngineName(),
                v.getGearboxType().toString(),
                v.getProductionDate().getYear(),
                v.getFuelTypes().isEmpty() ? "N/A" : v.getFuelTypes().get(0).getName(),
                v.getColor().getName(),
                v.getHorsePower(),
                v.getVehicleCondition().toString(),
                publication.getPrice(),
                publication.getDescription(),
                owner.getUsername(),
                owner.getEmail(),
                owner.getPhoneNumber()
        );
    }

    public Vehicle toVehicle(PublicationVehicleRequestDto dto, User owner, Brand brand,
                             List<ComfortFeatures> comfortFeatures, List<FuelType> fuelTypes) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(dto.getVin());
        vehicle.setLicensePlate(dto.getLicensePlate());
        vehicle.setProductionDate(dto.getProductionDate());
        vehicle.setMileage(dto.getMileage());
        vehicle.setEngineName(dto.getEngineName());
        vehicle.setHorsePower(dto.getHorsePower());
        vehicle.setOwner(owner);
        vehicle.setBrand(brand);
        vehicle.setVehicleType(dto.getVehicleType());
        vehicle.setVehicleCondition(dto.getVehicleCondition());
        vehicle.setGearboxType(dto.getGearboxType());
        vehicle.setComfortFeatures(comfortFeatures);
        vehicle.setFuelTypes(fuelTypes);
        return vehicle;
    }

    public Publication toPublication(PublicationVehicleRequestDto dto, Vehicle vehicle) {

        Publication publication = new Publication();
        publication.setActive(true);
        publication.setDescription(dto.getDescription());
        publication.setPrice(dto.getPrice());
        publication.setVehicle(vehicle);

        return publication;
    }
}

