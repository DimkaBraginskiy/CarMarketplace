package org.example.carmarketplace.Services;

import org.example.carmarketplace.DTOs.Request.PublicationVehicleRequestDto;
import org.example.carmarketplace.DTOs.Request.VehicleFilterDto;
import org.example.carmarketplace.ENUMs.VehicleType;
import org.example.carmarketplace.Mappers.PublicationMapper;
import org.example.carmarketplace.Models.*;
import org.example.carmarketplace.Repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {
    private final VehicleRepository vehicleRepo;
    private final PublicationRepository publicationRepo;
    private final UserRepository userRepo;
    private final BrandRepository brandRepo;
    private final ComfortFeaturesRepository comfortRepo;
    private final ColorRepository colorRepository;
    private final FuelTypeRepository fuelRepo;
    private final PublicationMapper mapper;


    public PublicationService(VehicleRepository vehicleRepo, PublicationRepository publicationRepo, UserRepository userRepo, BrandRepository brandRepo, ComfortFeaturesRepository comfortRepo, FuelTypeRepository fuelRepo, PublicationMapper mapper, ColorRepository colorRepository) {
        this.vehicleRepo = vehicleRepo;
        this.publicationRepo = publicationRepo;
        this.userRepo = userRepo;
        this.brandRepo = brandRepo;
        this.comfortRepo = comfortRepo;
        this.fuelRepo = fuelRepo;
        this.mapper = mapper;
        this.colorRepository = colorRepository;
    }

    public void createPublicationWithVehicle(PublicationVehicleRequestDto dto) {
        User owner = userRepo.findById(dto.getOwnerId()).orElseThrow(() -> new RuntimeException("User not found"));


        Brand brand = brandRepo.findById(dto.getBrandId()).orElseThrow(() -> new RuntimeException("brand not found"));

//        Color color = colorRepository.findById(dto.getColorId())
//                .orElseThrow(() -> new RuntimeException("Color not found"));


        List<ComfortFeatures> comfortFeatures = comfortRepo.findAllById(dto.getComfortFeatureIds());
        List<FuelType> fuelTypes = fuelRepo.findAllById(dto.getFuelTypeIds());

        Vehicle vehicle = mapper.toVehicle(dto, owner, brand, comfortFeatures, fuelTypes);
        vehicle = vehicleRepo.save(vehicle);

        Publication publication = mapper.toPublication(dto, vehicle);
        publicationRepo.save(publication);
    }

    public List<Publication> getAllActivePublications() {
        return publicationRepo.findByIsActiveTrue();
    }

    public List<Publication> searchPublications(VehicleFilterDto filter) {
        return publicationRepo.advancedSearch(filter);
    }

    public Publication getPublicationById(Long id) {
        return publicationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication not found"));
    }
}
