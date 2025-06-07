package org.example.carmarketplace.Mappers;

import org.example.carmarketplace.DTOs.Request.PublicationVehicleRequestDto;
import org.example.carmarketplace.DTOs.Response.PublicationVehicleResponseDto;
import org.example.carmarketplace.Models.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublicationMapper {

    public static PublicationVehicleResponseDto toCardDto(Publication publication) {
        Vehicle v = publication.getVehicle();

        return new PublicationVehicleResponseDto(
                // Assuming you add imageUrl field
                v.getId(),
                v.getBrand().getName(),
                v.getEngineName(),
                v.getGearboxType().toString(),
                v.getProductionDate().getYear(),
                v.getFuelTypes().isEmpty() ? "N/A" : v.getFuelTypes().get(0).getName(),
                v.getColor().getName(),
                v.getHorsePower(),
                v.getVehicleCondition().toString(),
                publication.getPrice()
        );
    }
}
