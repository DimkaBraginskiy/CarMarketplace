package org.example.carmarketplace.Mappers;

import org.example.carmarketplace.DTOs.Request.PublicationVehicleRequestDto;
import org.example.carmarketplace.DTOs.Response.PublicationVehicleDetailedResponseDto;
import org.example.carmarketplace.DTOs.Response.PublicationVehicleResponseDto;
import org.example.carmarketplace.Models.*;
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
}

